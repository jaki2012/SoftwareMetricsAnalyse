package cfg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: Halstead
 * Package: cfg
 * Author:  Novemser
 * 2016/10/15
 */
public class FNode implements Serializable, Cloneable, INode {
    private static final long serialVersionUID = 4372661154947355355L;
    private List<INode> nodes = new ArrayList<INode>();
    private String value = "";
    private String fullInfo = "";
    private int type = -1;
    private boolean folded = false;

    public String toString() {
        return getValue();
    }

    // -------------------------- GETTER SETTER CONSTRUCTOR

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void addNode(INode node) {
        nodes.add(node);
    }

    public List<INode> getNodes() {
        return nodes;
    }

    public void setNodes(List<INode> nodes) {
        this.nodes = nodes;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public FNode(List<INode> nodes, String value, int type) {
        this.nodes = nodes;
        this.value = value;
        this.type = type;
    }

    public FNode(String value, int type) {
        this.value = value;
        this.type = type;
    }

    public FNode() {
    }

    @Override
    public int getSize() {
        return nodes.size();
    }

    @Override
    public boolean isCovered() {
        return false;
    }

    @Override
    public void setCovered() {
        // Nothing to do
    }

    @Override
    public String getInfo() {
        return fullInfo;
    }

    @Override
    public void setInfo(String str) {
        this.fullInfo = str;
    }

    @Override
    public boolean isFolded() {
        return folded;
    }

    @Override
    public void setFolded(boolean folded) {
        this.folded = folded;
    }

}

