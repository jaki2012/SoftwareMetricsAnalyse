package visitors;

import adt.graph.Edge;
import adt.graph.Graph;
import adt.graph.GraphInformation;
import adt.graph.Node;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import domain.constants.Layer;
import domain.graph.visitors.RenumNodesGraphVisitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Novemser on 2016/10/6.
 */
public class GraphBuildVisitor extends VoidVisitorAdapter {
    private Graph<Integer> sourceGraph;
    private String methodName;
    private int nodeNum;
    private Stack<Node<Integer>> prevNode;
    private Stack<Node<Integer>> continueNode;
    private Stack<Node<Integer>> breakNode;
    private boolean controlFlag;
    private boolean returnFlag;
    private boolean caseFlag;
    private Node<Integer> finalnode;
    private byte[] hash;
    private GraphInformation infos;
    //    private List<SingleVariableDeclaration> params;
//    private List<VariableDeclarationFragment> attributes;
    private List<EnumDeclaration> enumFields;

    public GraphBuildVisitor(String methodName) {
        initBuilder(methodName);
    }

    private void initBuilder(String methodName) {
        this.methodName = methodName; // name of the method to be analyzed.
        nodeNum = 0; // number of the node.
        sourceGraph = new Graph<Integer>(); // the graph.
        sourceGraph.addMetadataLayer(); // the layer that associate the sourceGraph elements to the layoutGraph elements.
        sourceGraph.addMetadataLayer(); // the layer that contains the code cycles.
        sourceGraph.addMetadataLayer(); // the layer that contains the code instructions.
        enumFields = new LinkedList<EnumDeclaration>(); // the enum class attributes.
        prevNode = new Stack<Node<Integer>>(); // stack that contain the predecessor nodes.
        continueNode = new Stack<Node<Integer>>(); // stack that contains the node to be linked if a continue occurs.
        breakNode = new Stack<Node<Integer>>(); // stack that contains the node to be linked if a break occurs.
        controlFlag = false; // flag that control if a continue or a break occur.
        returnFlag = false; // flag that control if a return occur.
        caseFlag = false; // flag that control the occurrence of a break in the previous case;
        Node<Integer> initial = new Node<Integer>(nodeNum); // the initial node.
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

    //    @Override
//    public void visit(TryStmt n, Object arg) {
//        System.out.println(prevNode.isEmpty());
//        if (!prevNode.isEmpty()) {
//            Edge<Integer> edge = createConnection(); // create the edge from the previous node to the throws node.
//            sourceGraph.addFinalNode(edge.getEndNode()); // add the throws node to the final nodes.
//            returnFlag = false;
//            finalnode = null;
//        }
//        super.visit(n, arg);
//    }
//
//    @Override
//    public void visit(CatchClause n, Object arg) {
//        System.out.println(prevNode.isEmpty());
//        if (!prevNode.isEmpty()) {
//            Edge<Integer> edge = createConnection(); // create the edge from the previous node to the throws node.
//            sourceGraph.addFinalNode(edge.getEndNode()); // add the throws node to the final nodes.
//            returnFlag = false;
//            finalnode = null;
//        }
//        super.visit(n, arg);
//    }


    @Override
    public void visit(IfStmt node, Object arg) {
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
                    infos.addInformationToLayer2(sourceGraph, edge, "("+ node.toString()+")");
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

    @Override
    public void visit(DoStmt node, Object arg) {
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

    @Override
    public void visit(ForStmt node, Object arg) {
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
        Edge<Integer> edge = createConnection(); // connect the previous node to this node.
        Node<Integer> noForEach = edge.getEndNode(); // the initial node of the EnhancedForStatement.
        prevNode.push(noForEach);
        Node<Integer> noEndForEach = sourceGraph.addNode(++nodeNum); // the final node of the EnhancedForStatement.
        breakNode.push(noEndForEach); // if a break occur goes to the final node of the EnhancedForStatement.
        continueNode.push(noForEach); // if a break occur goes to the initial node of the EnhancedForStatement.
        Edge<Integer> edgeBody = createConnection(); // visit the forEach body block.
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
        sourceGraph.addEdge(noForEach, noEndForEach); // the loop connection.
        prevNode.push(noEndForEach); // the graph continues from the final node of the EnhancedForStatement.
        finalnode = noEndForEach; // update the final node.
        super.visit(node, arg);
    }

    @Override
    public void visit(SwitchStmt n, Object arg) {
        Edge<Integer> edge = createConnection(); // connect the previous node to this node.
        Node<Integer> noSwitch = edge.getEndNode(); // the initial node of the SwitchStatement.
        Node<Integer> noEndSwitch = sourceGraph.addNode(++nodeNum); // the final node of the SwitchStatement.
        breakNode.push(noEndSwitch); // if a break occur goes to the final node of the ForStatement.
        continueNode.push(noEndSwitch); // if a continue occur goes to the incFor node.
        prevNode.push(noEndSwitch);
        prevNode.push(noSwitch); // the graph continues from the initial node of the SwitchStatement.
        super.visit(n, arg);
        // if the default case doesn't have a break.
        // the number 2 represents the initial and the final nodes of the SwitchStatement.
        if (prevNode.size() > 2) {
            sourceGraph.addEdge(prevNode.pop(), breakNode.peek());
            while (prevNode.size() != 2) // if one or more cases doesn't have a break.
                prevNode.pop();
        }
        breakNode.pop(); // when ends clean the stack.
        continueNode.pop(); // when ends clean the stack.
        prevNode.pop(); // the graph continues from the final node of the SwitchStatement.
        finalnode = prevNode.peek(); // update the final node.
        controlFlag = false;
        returnFlag = false;
    }

    @Override
    public void visit(SwitchEntryStmt node, Object arg) {
        if (!returnFlag) { // verify if a return occur in the SwitchBody.
            if (controlFlag) { // if there is a case with no break.
                while (prevNode.size() != 2) // the number 2 represents the initial and the final nodes of the SwitchStatement.
                    prevNode.pop();
                controlFlag = false;
                caseFlag = true;
            } else
                caseFlag = false;
        } else
            returnFlag = false;
        nodeNum++;
        Node<Integer> n = sourceGraph.addNode(nodeNum); // create the node of the case.

        if (!caseFlag && prevNode.size() > 2)
            sourceGraph.addEdge(prevNode.pop(), n); // create a edge from the previous node to this node.
        sourceGraph.addEdge(prevNode.peek(), n); // create a edge from the begin of switch to this node.
        prevNode.push(n); // the graph continues from the case node of the SwitchStatement.
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
        if(!prevNode.isEmpty()) {
            Edge<Integer> edge = createConnection(); // create the edge from the previous node to the return node.
            infos.addInformationToLayer2(sourceGraph, edge, "return;"); // add information to previous node - return.
            sourceGraph.addFinalNode(edge.getEndNode()); // add the return node to the final nodes.
            infos.addInformationToLayer1(sourceGraph, edge.getEndNode(), n.toString()); // add information to return node.
            returnFlag = true;
            finalnode = null;
        }
    }

    @Override
    public void visit(MethodDeclaration node, Object arg) {
        super.visit(node, arg);

        List<Node<Integer>> nodesToRemove = new LinkedList<Node<Integer>>();
        List<Edge<Integer>> edgesToRemove = new LinkedList<Edge<Integer>>();
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

        RenumNodesGraphVisitor visitor = new RenumNodesGraphVisitor();
        sourceGraph.accept(visitor);
        sourceGraph.sortNodes();

        System.out.println("Method name:" + node.getDeclarationAsString(false, false) + " Node:" + getGraph().size());
        initBuilder(methodName);
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
}
