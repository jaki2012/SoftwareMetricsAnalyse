package domain.graph.structures.rules;

import ast.graph.Node;
import domain.graph.structures.BaseStructure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Project: Halstead
 * Package: domain.graph.structures.rules
 * Author:  Novemser
 * 2016/10/22
 */
public class BaseRule<V extends Comparable<V>> extends BaseStructure<V> {
    protected String methodName;
    protected Method method;


    public BaseRule(String methodName) {
        this.methodName = methodName;

        for (Method m : Node.class.getDeclaredMethods()) {
            if (m.getName().equals(methodName)) {
                method = m;
            }

        }
    }
}
