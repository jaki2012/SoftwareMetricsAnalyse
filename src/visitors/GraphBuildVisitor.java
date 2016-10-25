package visitors;

import ast.graph.Edge;
import ast.graph.Graph;
import ast.graph.GraphInformation;
import ast.graph.Node;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.sun.javaws.Main;
import domain.constants.Layer;
import domain.graph.visitors.DataComplexVisitor;
import domain.graph.visitors.EssComplexVisitor;
import domain.graph.visitors.ModuleComplexVisitor;
import domain.utils.ANTLRModuleStream;
import metrics.*;
import org.apache.commons.lang3.SerializationUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Project: Halstead
 * Package: visitors
 * Author:  Novemser
 * 2016/10/6
 */
public class GraphBuildVisitor extends VoidVisitorAdapter {
    private Graph<Integer> sourceGraph;
    private int nodeNum;
    private int edgeNum;
    private Stack<Node<Integer>> prevNode;
    private Stack<Node<Integer>> continueNode;
    private Stack<Node<Integer>> breakNode;
    private boolean controlFlag;
    private boolean returnFlag;
    private boolean caseFlag;
    private Node<Integer> finalnode;
    private byte[] hash;
    private GraphInformation infos;
    private int callPairs;
    private int branchCount;
    private int multiConditionCount;
    private int modifiedConditionCount;
    private int conditionsCount;
    private int decisionCount;
    private int globalParameters;
    private double essComplexity;
    private double moduleDesignComplexity;
    private double dataComplexity;
    private double cyclomaticComplexity;
    private double decisionDensity;
    private double designDensity;
    private double essDensity;
    private String methodName;

    private Stack<Node<Integer>> switchBegin;
    private Stack<Node<Integer>> switchEnd;

    private MetricsEvaluator evaluator;

    private HashSet<String> variableDeclarators;
    private List<EnumDeclaration> enumFields;
    private Set<String> parameters;

    @Deprecated
    public GraphBuildVisitor(MetricsEvaluator evaluator) {
        this(evaluator, "");
    }

    public GraphBuildVisitor(MetricsEvaluator evaluator, String methodName) {
        this.evaluator = evaluator;
        initBuilder(methodName);
    }

    private void initBuilder(String methodName) {
        this.methodName = methodName; // name of the methodName to be analyzed.
        nodeNum = 0; // number of the node.
        edgeNum = 0;
        callPairs = 0; // number of function calls
        branchCount = 0; // The number of branches. Branches are defined as those edges that exit from a decision node.
        multiConditionCount = 0;
        modifiedConditionCount = 0;
        conditionsCount = 0;
        decisionCount = 0;
        globalParameters = 0;
        variableDeclarators = new HashSet<>();
        sourceGraph = new Graph<>(); // the graph.
        sourceGraph.addMetadataLayer(); // the layer that associate the sourceGraph elements to the layoutGraph elements.
        sourceGraph.addMetadataLayer(); // the layer that contains the code cycles.
        sourceGraph.addMetadataLayer(); // the layer that contains the code instructions.
        enumFields = new LinkedList<>(); // the enum class attributes.
        prevNode = new Stack<>(); // stack that contain the predecessor nodes.
        continueNode = new Stack<>(); // stack that contains the node to be linked if a continue occurs.
        breakNode = new Stack<>(); // stack that contains the node to be linked if a break occurs.
        switchBegin = new Stack<>();
        switchEnd = new Stack<>();
        controlFlag = false; // flag that control if a continue or a break occur.
        returnFlag = false; // flag that control if a return occur.
        caseFlag = false; // flag that control the occurrence of a break in the previous case;
        Node<Integer> initial = new Node<>(nodeNum); // the initial node.
        sourceGraph.addInitialNode(initial); // add first node to the graph.
        prevNode.push(initial); // add first node to the previous node stack.
        finalnode = initial; // The final node.
        infos = new GraphInformation(); // the graph informations.
        parameters = new TreeSet<>();
    }

    @Override
    public void visit(EnumDeclaration n, Object arg) {
        enumFields.add(n);
    }

    @Override
    public void visit(ExpressionStmt n, Object arg) {
        infos.addInformationToLayer1(sourceGraph, prevNode.peek(), n.toString());
        super.visit(n, arg);
    }

    @Override
    public void visit(AssertStmt n, Object arg) {
        infos.addInformationToLayer1(sourceGraph, prevNode.peek(), n.toString());
        super.visit(n, arg);
    }

    @Override
    public void visit(EmptyStmt n, Object arg) {
        infos.addInformationToLayer1(sourceGraph, prevNode.peek(), n.toString());
        super.visit(n, arg);
    }

    @Override
    public void visit(VariableDeclarationExpr n, Object arg) {
        infos.addInformationToLayer1(sourceGraph, prevNode.peek(), n.toString());
        super.visit(n, arg);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(ThrowStmt n, Object arg) {
        if (!prevNode.isEmpty()) {
            n.getExpr().accept(this, arg);
            Edge<Integer> edge = createConnection(); // create the edge from the previous node to the throws node.
            infos.addInformationToLayer2(sourceGraph, edge, "throws;"); // add information to previous node - throws.
            sourceGraph.addFinalNode(edge.getEndNode()); // add the throws node to the final nodes.
            infos.addInformationToLayer1(sourceGraph, edge.getEndNode(), n.toString()); // add information to throws node.
            returnFlag = true;
            finalnode = null;
        }
    }

    @Override
    public void visit(TypeDeclarationStmt n, Object arg) {
        infos.addInformationToLayer1(sourceGraph, prevNode.peek(), n.toString());
        super.visit(n, arg);
    }

    @Override
    public void visit(MethodCallExpr n, Object arg) {
        addCallPairs();
        super.visit(n, arg);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(TryStmt n, Object arg) {
        Edge<Integer> edge = createConnection();
        Node<Integer> nodeTry = edge.getEndNode();
        prevNode.push(nodeTry); // the graph continues from the initial node of the TryStatement
        infos.addInformationToLayer1(sourceGraph, nodeTry, n.toString());
        n.getTryBlock().accept(this, arg);
        boolean breakThenFlag = controlFlag; // verify if a break or a continue occur in the TryThen.
        boolean returnThenFlag = returnFlag; // verify if a return occur in the TryThen.
        controlFlag = false;
        returnFlag = false;
        prevNode.push(nodeTry); // the graph continues from the initial node of the TryStatement
        Node<Integer> finalNode = null;

        if (!returnThenFlag || !breakThenFlag) {
            // Create the final node of try statement
            edge = createConnection();
            finalNode = edge.getEndNode();
            prevNode.push(nodeTry); // the graph continues from the initial node of the TryStatement
        }

        List<CatchClause> catchStatements = n.getCatchs();
        for (CatchClause clause : catchStatements) {
            Edge<Integer> edgeCatch = createConnection();
            infos.addInformationToLayer2(sourceGraph, edgeCatch, clause.toString());
            Node<Integer> nodeCatch = edgeCatch.getEndNode();
            prevNode.push(nodeCatch);
            infos.addInformationToLayer1(sourceGraph, nodeCatch, clause.toString());
            clause.accept(this, arg);
            if (finalNode != null && !returnFlag && !controlFlag)
                sourceGraph.addEdge(nodeCatch, finalNode);
            prevNode.push(nodeTry);
        }

        if (finalNode != null)
            prevNode.push(finalNode);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(IfStmt node, Object arg) {
        addModifiedCondition(node.getCondition());
        addBranchCount(2);
        Edge<Integer> edge = createConnection(); // connect the previous node to this node.
        Node<Integer> noIf = edge.getEndNode(); // the initial node of the IFStatement.
        prevNode.push(noIf); // the graph continues from the initial node of the IFStatement.
        node.getCondition().accept(this, arg); // visit condition
        infos.addInformationToLayer1(sourceGraph, noIf, node.toString());
        Edge<Integer> edgeThen = createConnection(); // visit the Then block.
        infos.addInformationToLayer2(sourceGraph, edgeThen, node.toString());
        Node<Integer> noIfThen = edgeThen.getEndNode(); // create the IFThen node.
        prevNode.push(noIfThen); // the graph continues from the IFThen node.
        node.getThenStmt().accept(this, arg);
        boolean breakThenFlag = controlFlag; // verify if a break or a continue occur in the IFThen.
        boolean returnThenFlag = returnFlag; // verify if a return occur in the IFThen.
        controlFlag = false;
        returnFlag = false;
        prevNode.push(noIf); // the graph continues from the initial node of the IFStatement.
        Statement elseStatement = node.getElseStmt(); // get the Else block.
        if (elseStatement != null) { // if exists visit the Else block.
            Edge<Integer> edgeElse = createConnection();
            infos.addInformationToLayer2(sourceGraph, edgeElse, "(" + node.toString() + ")");
            Node<Integer> noIfElse = edgeElse.getEndNode(); // create the IFElse node.
            prevNode.push(noIfElse); // the graph continues from the IFElse node.
            elseStatement.accept(this, arg);
        }
        boolean breakElseFlag = controlFlag; // verify if a break or a continue occur in the IFElse.
        boolean returnElseFlag = returnFlag; // verify if a return occur in the IFElse.
        if (!returnThenFlag || !returnElseFlag) { // if exist in maximum one return.
            if (!prevNode.isEmpty()) {
                edge = createConnection(); // create the final node of the IFStatement.
                if (elseStatement == null)
                    infos.addInformationToLayer2(sourceGraph, edge, "(" + node.toString() + ")");
                returnFlag = (returnThenFlag || returnElseFlag);
                if (!returnFlag) { // if there are no returns.
                    if (!breakThenFlag || !breakElseFlag) { // if exist in maximum one break or continue.
                        controlFlag = (breakThenFlag || breakElseFlag);
                        if (!controlFlag) // if there are no breaks or continues.
                            sourceGraph.addEdge(prevNode.pop(), edge.getEndNode()); // the connection from previous node to the final node of the IFStatement.
                        else
                            controlFlag = false;
                    }
                } else
                    returnFlag = false;
                finalnode = edge.getEndNode(); // update the final node.
                prevNode.push(edge.getEndNode());
            }
        }
    }

    @Override
    public void visit(WhileStmt node, Object arg) {
        addModifiedCondition(node.getCondition());
        addBranchCount(2);
        Edge<Integer> edge = createConnection(); // connect the previous node to this node.
        Node<Integer> noWhile = edge.getEndNode(); // the initial node of the WhileStatement.
        prevNode.push(noWhile); // the graph continues from the initial node of the WhileStatement.
        node.getCondition().accept(this, arg);
        infos.addInformationToLayer1(sourceGraph, noWhile, node.toString());
        Node<Integer> noEndWhile = sourceGraph.addNode(++nodeNum); // the final node of the WhileStatement.
        breakNode.push(noEndWhile); // if a break occur goes to the final node of the WhileStatement.
        continueNode.push(noWhile); // if a continue occur goes to the initial node of the WhileStatement.
        Edge<Integer> edgeBody = createConnection(); // visit the while body block.
        infos.addInformationToLayer2(sourceGraph, edgeBody, node.getBody().toString());
        Node<Integer> noWhileBody = edgeBody.getEndNode(); // create the WhileBody node.
        prevNode.push(noWhileBody); // the graph continues from the WhileBody node.
        node.getBody().accept(this, arg);
        continueNode.pop(); // when ends clean the stack.
        breakNode.pop(); // when ends clean the stack.
        if (!returnFlag) { // verify if a return occur in the WhileBody.
            if (!controlFlag) // verify if a break or a continue occur in the WhileBody.
                sourceGraph.addEdge(prevNode.pop(), noWhile); // the loop connection.
            else
                controlFlag = false;
        } else
            returnFlag = false;
        edge = sourceGraph.addEdge(noWhile, noEndWhile); // the connection from the initial node to the final node of the WhileStatement.
        infos.addInformationToLayer2(sourceGraph, edge, "(" + node.getBody().toString() + ")");
        prevNode.push(noEndWhile); // the graph continues from the final node of the WhileStatement.
        finalnode = noEndWhile; // update the final node.
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(DoStmt node, Object arg) {
        addModifiedCondition(node.getCondition());
        addBranchCount(2);
        Edge<Integer> edge = createConnection(); // connect the previous node to this node.
        Node<Integer> noDoWhileBody = edge.getEndNode(); // create the DoWhileBody node.
        prevNode.push(noDoWhileBody); // the graph continues from the DoWhileBody node.
        Node<Integer> noWhile = sourceGraph.addNode(++nodeNum); // the node of the WhileStatement.
        infos.addInformationToLayer1(sourceGraph, noWhile, node.toString());
        Node<Integer> noEndDoWhile = sourceGraph.addNode(++nodeNum); // the final node of the DoStatement.
        prevNode.push(noEndDoWhile);
        node.getCondition().accept(this, arg);
        if (prevNode.contains(noEndDoWhile)) {
            prevNode.remove(noEndDoWhile);
        }
        breakNode.push(noEndDoWhile); // if a break occur goes to the final node of the DoStatement.
        continueNode.push(noWhile); // if a continue occur goes to the WhileStatement node.
        node.getBody().accept(this, arg);
        continueNode.pop(); // when ends clean the stack.
        breakNode.pop(); // when ends clean the stack.
        if (!returnFlag) { // verify if a return occur in the DoWhileBody.
            if (!controlFlag) // verify if a break or a continue occur in the DoWhileBody.
                sourceGraph.addEdge(prevNode.pop(), noWhile); // the connection from the DoWhileBody node to the WhileStatement node.
            else
                controlFlag = false;
        } else
            returnFlag = false;
        edge = sourceGraph.addEdge(noWhile, noDoWhileBody); // the loop connection.
        infos.addInformationToLayer2(sourceGraph, edge, node.toString());
        edge = sourceGraph.addEdge(noWhile, noEndDoWhile); // the connection from the WhileStatement node to the final node of the DoWhileStatement.
        infos.addInformationToLayer2(sourceGraph, edge, "(" + node.toString() + ")");
        prevNode.push(noEndDoWhile); // the graph continues from the final node of the DoWhileStatement.
        finalnode = noEndDoWhile; // update the final node.

    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(ForStmt node, Object arg) {
        addModifiedCondition(node.getCompare());
        addBranchCount(2);
        Edge<Integer> edge = createConnection(); // initialization of the ForStatement.
        for (Expression initNode : node.getInit())
            infos.addInformationToLayer1(sourceGraph, edge.getBeginNode(), initNode.toString());
        Node<Integer> noFor = edge.getEndNode(); // the initial node of the ForStatement.
        Node<Integer> incFor = sourceGraph.addNode(++nodeNum); // the node of the incFor.
        for (Expression incNode : node.getUpdate())
            infos.addInformationToLayer1(sourceGraph, incFor, incNode.toString());
        Node<Integer> noEndFor = sourceGraph.addNode(++nodeNum); // the final node of the ForStatement.
        breakNode.push(noEndFor); // if a break occur goes to the final node of the ForStatement.
        continueNode.push(incFor); // if a continue occur goes to the incFor node.
        prevNode.push(noFor); // the graph continues from the initial node of the ForStatement.

        // iterate statement
        Iterator var3;
        Expression e;
        if (node.getInit() != null) {
            var3 = node.getInit().iterator();

            while (var3.hasNext()) {
                e = (Expression) var3.next();
                e.accept(this, arg);
            }
        }

        if (node.getCompare() != null) {
            node.getCompare().accept(this, arg);
        }

        if (node.getUpdate() != null) {
            var3 = node.getUpdate().iterator();

            while (var3.hasNext()) {
                e = (Expression) var3.next();
                e.accept(this, arg);
            }
        }

        Edge<Integer> edgeBody = createConnection(); // visit the ForStatement body block.
        infos.addInformationToLayer2(sourceGraph, edgeBody, node.toString());
        Node<Integer> noForBody = edgeBody.getEndNode(); // create the ForBody node.
        prevNode.push(noForBody); // the graph continues from the ForBody node.
        node.getBody().accept(this, arg);
        continueNode.pop(); // when ends clean the stack.
        breakNode.pop(); // when ends clean the stack.
        if (!returnFlag) { // verify if a return occur in the ForBody.
            if (!controlFlag) // verify if a break or a continue occur in the ForBody.
                sourceGraph.addEdge(prevNode.pop(), incFor); // connect the previous node to the increment node.
            else
                controlFlag = false;
        } else
            returnFlag = false;
        sourceGraph.addEdge(incFor, noFor); // the loop connection.
        edge = sourceGraph.addEdge(noFor, noEndFor); // the connection from the initial node to the final node of the ForStatement.
        infos.addInformationToLayer2(sourceGraph, edge, "(" + node.toString() + ")");
        prevNode.push(noEndFor); // the graph continues from the final node of the DoWhileStatement.
        finalnode = noEndFor; // update the final node.

    }

    @Override
    public void visit(ForeachStmt node, Object arg) {
        addModifiedCondition();
        addBranchCount(2);
        Edge<Integer> edge = createConnection(); // connect the previous node to this node.
        Node<Integer> noForEach = edge.getEndNode(); // the initial node of the EnhancedForStatement.
        prevNode.push(noForEach);
        node.getVariable().accept(this, arg);
        node.getIterable().accept(this, arg);
        infos.addInformationToLayer1(sourceGraph, noForEach, node.toString());
        Node<Integer> noEndForEach = sourceGraph.addNode(++nodeNum); // the final node of the EnhancedForStatement.
        breakNode.push(noEndForEach); // if a break occur goes to the final node of the EnhancedForStatement.
        continueNode.push(noForEach); // if a break occur goes to the initial node of the EnhancedForStatement.
        Edge<Integer> edgeBody = createConnection(); // visit the forEach body block.
        infos.addInformationToLayer2(sourceGraph, edgeBody, node.toString());
        Node<Integer> noForEachBody = edgeBody.getEndNode(); // create the ForEachBody node.
        prevNode.push(noForEachBody); // the graph continues from the ForEachBody node.
        node.getBody().accept(this, arg);
        continueNode.pop(); // when ends clean the stack.
        breakNode.pop(); // when ends clean the stack.
        if (!returnFlag) { // verify if a return occur in the ForEachBody.
            if (!controlFlag) // verify if a break or a continue occur in the ForEachBody.
                sourceGraph.addEdge(prevNode.pop(), noForEach); // the loop connection.
            else
                controlFlag = false;
        } else
            returnFlag = false;
        edge = sourceGraph.addEdge(noForEach, noEndForEach); // the loop connection.
        infos.addInformationToLayer2(sourceGraph, edge, node.toString());
        prevNode.push(noEndForEach); // the graph continues from the final node of the EnhancedForStatement.
        finalnode = noEndForEach; // update the final node.
    }

    @Override
    public void visit(SwitchStmt n, Object arg) {
        addModifiedCondition(n.getSelector());
        Edge<Integer> edge = createConnection(); // connect the previous node to this node.
        Node<Integer> noSwitch = edge.getEndNode(); // the initial node of the SwitchStatement.
        infos.addInformationToLayer1(sourceGraph, noSwitch, n.toString());
        Node<Integer> noEndSwitch = sourceGraph.addNode(++nodeNum); // the final node of the SwitchStatement.
        breakNode.push(noEndSwitch); // if a break occur goes to the final node of the ForStatement.
        continueNode.push(noEndSwitch); // if a continue occur goes to the incFor node.
        switchBegin.push(noSwitch);
        switchEnd.push(noEndSwitch);
        prevNode.push(noSwitch);

        super.visit(n, arg);
        switchEnd.pop();
        switchBegin.pop();
        prevNode.push(noEndSwitch);
        finalnode = noEndSwitch;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(SwitchEntryStmt node, Object arg) {
        addBranchCount();
        prevNode.push(switchBegin.peek());
        Edge<Integer> edgeCase = createConnection();
        if (node.getLabel() == null)
            infos.addInformationToLayer2(sourceGraph, edgeCase, "default");
        else
            infos.addInformationToLayer2(sourceGraph, edgeCase, "case" + node.getLabel());
        Node<Integer> noCase = edgeCase.getEndNode(); // the initial node of the EnhancedForStatement.
        infos.addInformationToLayer1(sourceGraph, noCase, node.toString());
        prevNode.push(noCase);
        controlFlag = false;
        if (node.getStmts() != null) {
            Iterator var3 = node.getStmts().iterator();
            while (var3.hasNext()) {
                Statement s = (Statement) var3.next();
                s.accept(this, arg);
            }
        }
        if (!controlFlag) { // case without a body
            sourceGraph.addEdge(noCase, switchEnd.peek());
        }
    }

    @Override
    public void visit(BreakStmt n, Object arg) {
        if (!prevNode.isEmpty()) {
            Edge<Integer> edge = sourceGraph.addEdge(prevNode.pop(), breakNode.peek()); // create the edge from the previous node to the break node.
            infos.addInformationToLayer2(sourceGraph, edge, "break;"); // add information to previous node - break.
            infos.addInformationToLayer1(sourceGraph, edge.getBeginNode(), n.toString());
            controlFlag = true;
        }
    }

    @Override
    public void visit(ContinueStmt n, Object arg) {
        if (!prevNode.isEmpty()) {
            Edge<Integer> edge = sourceGraph.addEdge(prevNode.pop(), continueNode.peek()); // create the edge from the previous node to the continue node.
            infos.addInformationToLayer2(sourceGraph, edge, "continue;"); // add information to previous node - continue.
            infos.addInformationToLayer1(sourceGraph, edge.getBeginNode(), n.toString());
            controlFlag = true;
        }
    }

    @Override
    public void visit(ReturnStmt n, Object arg) {
        if (!prevNode.isEmpty()) {
            Edge<Integer> edge = createConnection(); // create the edge from the previous node to the return node.
            infos.addInformationToLayer2(sourceGraph, edge, "return;"); // add information to previous node - return.
            sourceGraph.addFinalNode(edge.getEndNode()); // add the return node to the final nodes.
            infos.addInformationToLayer1(sourceGraph, edge.getEndNode(), n.toString()); // add information to return node.
            returnFlag = true;
            finalnode = null;
        }
    }

    @Override
    public void visit(ConditionalExpr n, Object arg) {
        addMultipleCondition();
        super.visit(n, arg);
    }

    @Override
    public void visit(NameExpr n, Object arg) {
        if (parameters.contains(n.getName()))
            if (prevNode.size() > 0)
                prevNode.peek().containsParamCall();

        if (variableDeclarators.contains(n.toString()))
            addGlobalParameter(1);
        super.visit(n, arg);
    }

    @Override
    public void visit(FieldAccessExpr n, Object arg) {
        addGlobalParameter(1);
        super.visit(n, arg);
    }

    /**
     * Add all field declaration
     * To calculate GLOBAL DATA
     *
     * @param n
     * @param arg
     */
    @Override
    public void visit(FieldDeclaration n, Object arg) {
        for (VariableDeclarator decelerator : n.getVariables()) {
            variableDeclarators.add(decelerator.getId().toString());
        }
        super.visit(n, arg);
    }

    @Override
    public void visit(MethodDeclaration node, Object arg) {
        if (!node.getName().equals(methodName)) {
            String head = "public class Module {";
            String end = "}";
//            System.out.println("===================");
//            System.out.println("Inner Module of:\"" + methodName + "\" Module name:\"" + node.getName() + "\"");
            StringBuilder builder = new StringBuilder();
            builder.append(head);
            builder.append(node.toString());
            builder.append(end);
            ANTLRModuleStream stream = new ANTLRModuleStream(builder.toString().toCharArray());
            try {
                MetricsEvaluator e = (new Initiator()).initiate(stream);
                InputStream inputStream = new ByteArrayInputStream(builder.toString().getBytes());
                LOCAnalyser.calculate(inputStream, e);
                new GraphBuildVisitor(e, node.getName()).visit(node, arg);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return;
        }

        for (Parameter p : node.getParameters()) {
            parameters.add(p.getName());
        }
        addGlobalParameter(node.getParameters().size());
        super.visit(node, arg);

//        System.out.println("======================================");
//        System.out.println("Module name:" + node.getName());

        // Remove unnecessary nodes/edges
        List<Node<Integer>> nodesToRemove = new LinkedList<>();
        List<Edge<Integer>> edgesToRemove = new LinkedList<>();
        for (Node<Integer> graphNode : sourceGraph.getNodes()) {
            sourceGraph.selectMetadataLayer(Layer.INSTRUCTIONS.getLayer()); // select the layer to get the information.
            if (sourceGraph.getMetadata(graphNode) == null &&
                    sourceGraph.getNodeEdges(graphNode).size() == 1) {
                Set<Edge<Integer>> edgeToRemove = sourceGraph.getNodeEndEdges(graphNode);
                Edge<Integer> edgeToFinalNode = (Edge<Integer>) sourceGraph.getNodeEdges(graphNode).toArray()[0];
                for (Edge<Integer> edge : edgeToRemove) {
                    Edge<Integer> newEdge = sourceGraph.addEdge(edge.getBeginNode(), edgeToFinalNode.getEndNode());
                    sourceGraph.selectMetadataLayer(Layer.GUARDS.getLayer()); // select the layer to get the information.
                    infos.addInformationToLayer2(sourceGraph, newEdge, (String) sourceGraph.getMetadata(edge)); // add information newEdge.
                    sourceGraph.removeEdge(edge);
                }
                nodesToRemove.add(graphNode);
                edgesToRemove.add(edgeToFinalNode);
            }
        }

        for (Node<Integer> n : sourceGraph.getNodes())
            if (sourceGraph.getNodeEndEdges(n).size() == 0 && !sourceGraph.isInitialNode(n) && !nodesToRemove.contains(n)) {
                edgesToRemove.addAll(sourceGraph.getNodeEdges(n));
                nodesToRemove.add(n);
            }

        for (Edge<Integer> edge : edgesToRemove)
            sourceGraph.removeEdge(edge);

        for (Node<Integer> n : nodesToRemove)
            sourceGraph.removeNode(n);

        if (!sourceGraph.getInitialNodes().iterator().hasNext())
            sourceGraph.addInitialNode(sourceGraph.getNodes().iterator().next());

//        sourceGraph.accept(new ReNumNodesVisitor());
        getGraph();
        sourceGraph.sortNodes();

//        printEdges(sourceGraph);
        Graph<Integer> essComplexGraph = SerializationUtils.clone(sourceGraph);
        EssComplexVisitor<Integer> visitor = new EssComplexVisitor<>(essComplexGraph);
        essComplexGraph.accept(visitor);
        essComplexity = calculateCC(essComplexGraph);

        Graph<Integer> modDesignGraph = SerializationUtils.clone(sourceGraph);
        ModuleComplexVisitor<Integer> mVisitor = new ModuleComplexVisitor<>(modDesignGraph);
        modDesignGraph.accept(mVisitor);
        moduleDesignComplexity = calculateCC(modDesignGraph);

        Graph<Integer> dataComplexGraph = SerializationUtils.clone(sourceGraph);
        DataComplexVisitor<Integer> dVisitor = new DataComplexVisitor<>(dataComplexGraph);
        dataComplexGraph.accept(dVisitor);
        dataComplexity = calculateCC(dataComplexGraph);

        cyclomaticComplexity = calculateCC(sourceGraph);
        calculateFinal();

        initBuilder(methodName);
    }

    /**
     * Print the edges in graph
     * e.g. (1,2) (2,3) ...etc
     */
    public static void printEdges(Graph sourceGraph) {
        Map<Node<Integer>, Set<Edge<Integer>>> map = sourceGraph.getEdges();
        for (Map.Entry<Node<Integer>, Set<Edge<Integer>>> entry : map.entrySet()) {
            for (Edge<Integer> edge : entry.getValue()) {
                System.out.println(edge.toString());
            }
        }
    }

    /**
     * Call before calculate final
     *
     * @return calculated Cyclomatic Complexity
     */
    private int calculateCC(Graph graph) {
        int offset;

        offset = graph.getFinalNodes().size();
        // all final nodes counts for one
        // in CC calculation
        offset = offset == 1 ? (offset - 1) : (offset - 2);
        if (!graph.equals(sourceGraph))
            offset = 0;
        return graph.edgeCount() - (graph.size() - offset) + 2;
    }

    private void bindToMetric() {
        // CC is always bigger than 0
        assert cyclomaticComplexity <= 0;

        evaluator.putDimension(Dimension.BRANCH_COUNT, (double) branchCount);
        evaluator.putDimension(Dimension.MULTIPLE_CONDITION_COUNT, (double) multiConditionCount);
        evaluator.putDimension(Dimension.MODIFIED_CONDITION_COUNT, (double) modifiedConditionCount);
        evaluator.putDimension(Dimension.NODE_COUNT, (double) sourceGraph.size());
        evaluator.putDimension(Dimension.EDGE_COUNT, (double) sourceGraph.edgeCount());
        evaluator.putDimension(Dimension.CONDITION_COUNT, (double) conditionsCount);
        evaluator.putDimension(Dimension.CALL_PAIRS, (double) callPairs);
        evaluator.putDimension(Dimension.PARAMETER_COUNT, (double) globalParameters);
        evaluator.putDimension(Dimension.CYCLOMATIC_COMPLEXITY, cyclomaticComplexity);
        evaluator.putDimension(Dimension.CYCLOMATIC_DENSITY, cyclomaticComplexity / evaluator.getDimension(Dimension.LOC_TOTAL));
        evaluator.putDimension(Dimension.NORMALIZED_CYCLOMATIC_COMPLEXITY, cyclomaticComplexity / evaluator.getDimension(Dimension.NUMBER_OF_LINES));
        evaluator.putDimension(Dimension.DESIGN_COMPLEXITY, moduleDesignComplexity);
        evaluator.putDimension(Dimension.DESIGN_DENSITY, moduleDesignComplexity / cyclomaticComplexity);
        evaluator.putDimension(Dimension.DECISION_COUNT, (double) decisionCount);
        evaluator.putDimension(Dimension.DECISION_DENSITY, decisionDensity);
        evaluator.putDimension(Dimension.ESSENTIAL_COMPLEXITY, essComplexity);
        evaluator.putDimension(Dimension.ESSENTIAL_DENSITY, essDensity);
        evaluator.putDimension(Dimension.GLOBAL_DATA_COMPLEXITY, dataComplexity);
        evaluator.putDimension(Dimension.GLOBAL_DATA_DENSITY, dataComplexity / cyclomaticComplexity);
        evaluator.putDimension(Dimension.MAINTENANCE_SEVERITY, essComplexity / cyclomaticComplexity);

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Dimension, Double> entry : evaluator.dimensions.entrySet()) {
            builder.append(entry.getValue());
            builder.append(",");
//            String s = String.format("%-35s%-5s", entry.getKey(), entry.getValue());
//            System.out.println(s);
        }
        builder.append("\n");
        if (main.Main.printWriter != null)
            main.Main.printWriter.write(builder.toString());

    }

    private void calculateFinal() {
        multiConditionCount += modifiedConditionCount * 2;
        conditionsCount = multiConditionCount * 2;
        decisionCount = (multiConditionCount % 2 == 0) ? multiConditionCount : multiConditionCount - 1;
        if (decisionCount != 0)
            decisionDensity = conditionsCount / decisionCount;

        designDensity = moduleDesignComplexity / cyclomaticComplexity;
        if (cyclomaticComplexity - 1 > 0 && essComplexity - 1 >= 0)
            essDensity = (essComplexity - 1) / (cyclomaticComplexity - 1);

        bindToMetric();
    }

    private Edge<Integer> createConnection() {
        nodeNum++; // increase the node number.
        Node<Integer> node = sourceGraph.addNode(nodeNum); // create a new node.
        return sourceGraph.addEdge(prevNode.pop(), node); // create a edge to the previous node to the new one.
    }

    public Graph<Integer> getGraph() {
        if (finalnode != null)
            sourceGraph.addFinalNode(finalnode); // add final node to the final nodes of the graph.
        return sourceGraph;
    }

    private void addBranchCount() {
        branchCount++;
    }

    private void addBranchCount(int num) {
        branchCount += num;
    }

    private void addMultipleCondition() {
        multiConditionCount++;
    }

    private void addModifiedCondition(Expression expression) {
        if (null == expression)
            return;
        String s = expression.toString();
        int count = 0;
        for (String str : SymbolAnalyzer.compare) {
            count += (s.length() - s.replace(str, "").length()) / str.length();
        }

        if (count == 0)
            modifiedConditionCount++;
        else
            modifiedConditionCount += count + 1;
    }

    private void addModifiedCondition() {
        modifiedConditionCount++;
    }

    private void addGlobalParameter(int num) {
        globalParameters += num;
    }

    private void addCallPairs() {
        callPairs++;
        prevNode.peek().containsMethodCall(); // set this node to contains methodName call
    }
}
