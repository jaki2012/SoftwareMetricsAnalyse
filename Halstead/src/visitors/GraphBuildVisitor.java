package visitors;

import adt.graph.Edge;
import adt.graph.Graph;
import adt.graph.GraphInformation;
import adt.graph.Node;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import domain.constants.Layer;
import domain.graph.visitors.EssComplexVisitor;
import domain.graph.visitors.RenumNodesGraphVisitor;
import metrics.MetricsEvaluator;
import metrics.SymbolAnalyzer;
import org.apache.commons.lang3.SerializationUtils;

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
    private int decisionDensity;
    private int globalParameters;
    private Stack<Node<Integer>> switchBegin;
    private Stack<Node<Integer>> swichEnd;

    private MetricsEvaluator evaluator;

    private HashSet<String> variableDeclarators;
    //    private List<SingleVariableDeclaration> params;
    private List<EnumDeclaration> enumFields;

    public GraphBuildVisitor(MetricsEvaluator evaluator) {
        this.evaluator = evaluator;
        initBuilder();
    }

    private void initBuilder() {
        //this.methodName = methodName; // name of the method to be analyzed.
        nodeNum = 0; // number of the node.
        edgeNum = 0;
        callPairs = 0; // number of function calls
        branchCount = 0; // The number of branches. Branches are defined as those edges that exit from a decision node.
        multiConditionCount = 0;
        modifiedConditionCount = 0;
        conditionsCount = 0;
        decisionDensity = 0;
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
        swichEnd = new Stack<>();
        controlFlag = false; // flag that control if a continue or a break occur.
        returnFlag = false; // flag that control if a return occur.
        caseFlag = false; // flag that control the occurrence of a break in the previous case;
        Node<Integer> initial = new Node<>(nodeNum); // the initial node.
        sourceGraph.addInitialNode(initial); // add first node to the graph.
        prevNode.push(initial); // add first node to the previous node stack.
        finalnode = initial; // The final node.
        infos = new GraphInformation(); // the graph informations.
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

    @Override
    public void visit(ThrowStmt n, Object arg) {
        if (!prevNode.isEmpty()) {
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
//        Edge<Integer> edgeThen = createConnection();
//        infos.addInformationToLayer2(sourceGraph, edgeThen, n.toString());
//        Node<Integer> nodeTryThen = edgeThen.getEndNode();
//        prevNode.push(nodeTry);
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
//        prevNode.push(noEndSwitch);
//        prevNode.push(noSwitch); // the graph continues from the initial node of the SwitchStatement.
        switchBegin.push(noSwitch);
        swichEnd.push(noEndSwitch);

        super.visit(n, arg);
        swichEnd.pop();
        switchBegin.pop();
    }

    @Override
    public void visit(SwitchEntryStmt node, Object arg) {
//        List<Statement> switchEntryStmts = node.getStmts();
//        StringBuilder entryBuilder = new StringBuilder();
        addBranchCount();
//        String endStmt = switchEntryStmts.get(switchEntryStmts.size() - 1).toString(); // get last statement
//        if (endStmt.contains("return"))
//            returnFlag = true;
//        if (endStmt.contains("break"))
//            controlFlag = false;
        prevNode.push(switchBegin.peek());
        Edge<Integer> edgeCase = createConnection();
        if (node.getLabel() == null)
            infos.addInformationToLayer2(sourceGraph, edgeCase, "default");
        else
            infos.addInformationToLayer2(sourceGraph, edgeCase, "case" + node.getLabel());
        Node<Integer> noCase = edgeCase.getEndNode(); // the initial node of the EnhancedForStatement.
        prevNode.push(noCase);

        if(node.getStmts() != null) {
            Iterator var3 = node.getStmts().iterator();
            while(var3.hasNext()) {
                Statement s = (Statement)var3.next();
                s.accept(this, arg);
            }
        }

//        if (!returnFlag) { // verify if a return occur in the SwitchBody.
////            sourceGraph.addEdge(noCase, swichEnd);
//            returnFlag = false;
//        }
//        nodeNum++;
//        Node<Integer> n = sourceGraph.addNode(nodeNum); // create the node of the case.
//        infos.addInformationToLayer1(sourceGraph, n, node.toString());
//        Edge<Integer> edge = null;
//        if (!caseFlag && prevNode.size() > 2)
//            edge = sourceGraph.addEdge(prevNode.pop(), n); // create a edge from the previous node to this node.
//        edge = sourceGraph.addEdge(prevNode.peek(), n); // create a edge from the begin of switch to this node.
//        if (node.getLabel() == null)// if the node is the default of the switch.
//            infos.addInformationToLayer2(sourceGraph, edge, "default:");
//        else
//            infos.addInformationToLayer2(sourceGraph, edge, "case " + node.toString());
//        prevNode.push(n); // the graph continues from the case node of the SwitchStatement.

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
     * @param n
     * @param arg
     */
    @Override
    public void visit(FieldDeclaration n, Object arg) {
        for (VariableDeclarator declarator : n.getVariables()) {
            variableDeclarators.add(declarator.getId().toString());
        }
        super.visit(n, arg);
    }

    @Override
    public void visit(MethodDeclaration node, Object arg) {
        addGlobalParameter(node.getParameters().size());
        super.visit(node, arg);

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

        Graph<Integer> clonedObj = SerializationUtils.clone(sourceGraph);
        EssComplexVisitor<Integer> visitor = new EssComplexVisitor<>(clonedObj);
        clonedObj.accept(visitor);

        sourceGraph.sortNodes();

        calculateFinal();

//        printEdges(sourceGraph);

        System.out.println("Method name:" + node.getDeclarationAsString(false, false) + " Node:" + nodeNum + " Edge:" + edgeNum + " CC:" + calculateCC());
        initBuilder();
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
     * WARNING: Call this after calculateFinal()
     * @return calculated Cyclomatic Complexity
     */
    private int calculateCC() {
        int offset;

        offset = sourceGraph.getFinalNodes().size();
        // all final nodes counts for one
        // in CC calculation
        offset = offset == 1? (offset - 1): (offset - 2);
        return edgeNum - (nodeNum - offset) + 2;
    }

    private void calculateFinal() {
        multiConditionCount += modifiedConditionCount * 2;
        conditionsCount = multiConditionCount * 2;
        nodeNum = getNodeCount();
        edgeNum = getEdgeCount();
//        decisionDensity = conditionsCount / dp;
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

    public int getNodeCount() {
        return getGraph().size();
    }

    public int getEdgeCount() {
        return getGraph().edgeCount();
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
        prevNode.peek().containsMethodCall(); // set this node to contains method call
    }
}
