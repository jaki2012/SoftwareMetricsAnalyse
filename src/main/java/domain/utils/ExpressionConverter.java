package domain.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Project: SoftwareMetricsAnalyse
 * Package: domain.utils
 * Author:  Novemser
 * 2017/3/20
 */
public class ExpressionConverter {
    /**
     * 优先级比较
     * @param operator1 比较值
     * @param operator2 被比较值
     * @return 小于等于返回false,大于返回true
     */
    public boolean comparePrior(String operator1, String operator2) {
        if("(".equals(operator2)) {
            return true;
        }
        if ("*".equals(operator1) || "/".equals(operator1)) {
            if ("+".equals(operator2) || "-".equals(operator2)) {
                return true;
            }
        }
        return false;
    }

    public String[] toSuffixExpression(String[] expressionStrs) {
        //新组成的表达式
        List<String> newExpressionStrs = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < expressionStrs.length; i++) {
            if ("(".equals(expressionStrs[i])) { // 如果是左括号,则入栈
                stack.push(expressionStrs[i]);
            } else if ("+".equals(expressionStrs[i]) || "-".equals(expressionStrs[i]) || "*".equals(expressionStrs[i]) || "/".equals(expressionStrs[i])) {
                if (!stack.empty()) { // 取出先入栈的运算符
                    String s = stack.pop();
                    if(comparePrior(expressionStrs[i], s)) { //如果栈值优先级小于要入栈的值,则继续压入栈
                        stack.push(s);
                    } else {  //否则取出值
                        newExpressionStrs.add(s);
                    }
                }
                stack.push(expressionStrs[i]);
            } else if (")".equals(expressionStrs[i])) { //如果是")",则出栈,一直到遇到"("
                while (!stack.empty()) {
                    String s = stack.pop();
                    if (!"(".equals(s)) {
                        newExpressionStrs.add(s);
                    } else {
                        break;
                    }
                }
            } else {
                newExpressionStrs.add(expressionStrs[i]);
            }
        }
        while (!stack.empty()) {
            String s = stack.pop();
            newExpressionStrs.add(s);
        }
        return newExpressionStrs.toArray(new String[0]);
    }
    public static void main(String[] args) {
        //前台传过来的字符格式,所以测试也写成这个格式
        String expressionStr = "5;+;(;4;-;5;+;1;);-;4;+;(;6;-;5;+;3;);+;2;";
        // 分割成表达式数组
        String[] expressionStrs = expressionStr.split(";");
        String[] newExpressionStrs = new ExpressionConverter().toSuffixExpression(expressionStrs);
        for (String newExpressionStr : newExpressionStrs) {
            System.out.print(newExpressionStr);
        }

        System.out.println();

        expressionStr = "5;+;(;4;-;5;*;1;);-;4;/;(;6;*;5;+;3;);/;2;";
        expressionStrs = expressionStr.split(";");
        newExpressionStrs = new ExpressionConverter().toSuffixExpression(expressionStrs);
        for (String newExpressionStr : newExpressionStrs) {
            System.out.print(newExpressionStr);
        }
    }
}
