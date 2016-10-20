package domain.graph.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Project: Halstead
 * Package: domain.graph.structures
 * Author:  Novemser
 * 2016/10/20
 */
public class StructureProvider<V extends Comparable<V>> implements Iterable {
    private List<IStructure<V>> list;

    public StructureProvider () {
        list = new ArrayList<>();
    }

    public void addStructure(IStructure<V> structure) {
        if (!list.contains(structure))
            list.add(structure);
    }

    /**
     * Get the container's iterator
     * @return Iterator
     */
    @Override
    public Iterator<IStructure<V>> iterator() {
        return list.iterator();
    }
}
