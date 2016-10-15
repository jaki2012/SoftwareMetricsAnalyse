package cfg;

import java.util.*;

/**
 * Project: Halstead
 * Package: cfg
 * Author:  Novemser
 * 2016/10/15
 */
public class CFGVisitor {

    protected INode rootINode;
    protected Stack<INode> deepFirstStack = new Stack<INode>();
    protected Set<INode> visited = new HashSet<INode>();
    protected Queue<INode> breadthFirstQueue = new LinkedList<INode>();
    protected int circlecomplexity = 1;

    public CFGVisitor(INode root){
        this.rootINode = root;
    }

    protected boolean visitContent(INode node){
        System.out.println(node.getValue());
        if(node.getSize() == 2){
            circlecomplexity += 1;
        }
        if(node.getSize() > 2){
            circlecomplexity += node.getSize() - 2;
        }
        return true;
    }

    public void deepFirstVisit(){
        if(rootINode == null){
            return;
        }
        deepFirstStack.clear();
        visited.clear();
        visitContent(rootINode);
        visited.add(rootINode);
        deepFirstStack.push(rootINode);
        while(!deepFirstStack.empty()){
            INode tempINode = deepFirstStack.peek();
            boolean isAllChildVisited = true;
            for(INode node : tempINode.getNodes()){
                if(!visited.contains(node)){
                    visitContent(node);
                    visited.add(node);
                    deepFirstStack.push(node);
                    isAllChildVisited = false;
                    break;
                }
            }
            if(isAllChildVisited){
                deepFirstStack.pop();
            }
        }
    }

    public void breadthFirstVisit(){
        if(rootINode == null){
            return;
        }
        breadthFirstQueue.clear();
        visited.clear();
        breadthFirstQueue.offer(rootINode);
        while(!breadthFirstQueue.isEmpty()){
            INode tempNode = breadthFirstQueue.poll();
            visitContent(tempNode);
            visited.add(tempNode);
            for(INode node : tempNode.getNodes()){
                if(!visited.contains(node)){
                    breadthFirstQueue.offer(node);
                }
            }
        }
    }

    public int computeCircleComplexity(){
        return circlecomplexity;
    }
}
