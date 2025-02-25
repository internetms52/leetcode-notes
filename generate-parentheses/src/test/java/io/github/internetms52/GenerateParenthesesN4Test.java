package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenerateParenthesesN4Test {
    GenerateParenthesesBacktrack generateParentheses = new GenerateParenthesesBacktrack();

    @Test
    public void case2() {
        List<String> ansList = List.of("((((()))))", "(((()())))", "(((())()))", "(((()))())", "(((())))()", "((()(())))", "((()()()))", "((()())())", "((()()))()", "((())(()))", "((())()())", "((())())()", "((()))(())", "((()))()()", "(()((())))", "(()(()()))", "(()(())())", "(()(()))()", "(()()(()))", "(()()()())", "(()()())()", "(()())(())", "(()())()()", "(())((()))", "(())(()())", "(())(())()", "(())()(())", "(())()()()", "()(((())))", "()((()()))", "()((())())", "()((()))()", "()(()(()))", "()(()()())", "()(()())()", "()(())(())", "()(())()()", "()()((()))", "()()(()())", "()()(())()", "()()()(())", "()()()()()");
        List<String> resultList = generateParentheses.generateParenthesis(5);
        Assertions.assertTrue(resultList.containsAll(ansList));
        Assertions.assertEquals(resultList.size(), ansList.size());
    }
}
