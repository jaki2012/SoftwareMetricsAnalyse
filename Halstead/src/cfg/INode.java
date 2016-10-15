package cfg;

import java.util.List;

/**
 * Project: Halstead
 * Package: cfg
 * Author:  Novemser
 * 2016/10/15
 */
public interface INode {
    public abstract void addNode(INode node);

    public abstract List<INode> getNodes();

    public abstract void setNodes(List<INode> nodes);

    public abstract String getValue();

    public abstract void setValue(String value);

    public abstract int getType();

    public abstract void setType(int type);

    public abstract int getSize();

    public abstract boolean isCovered();

    public abstract void setCovered();

    public abstract void setInfo(String str);

    public abstract String getInfo();

    public abstract boolean isFolded();
    public abstract void setFolded(boolean folded);
}
