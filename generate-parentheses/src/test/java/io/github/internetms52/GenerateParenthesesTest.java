package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenerateParenthesesTest {
    GenerateParenthesesBacktrack generateParentheses = new GenerateParenthesesBacktrack();
    GenerateParenthesesN3 generateParenthesesN3 = new GenerateParenthesesN3();

    @Test
    public void case2() {
        List<String> ansList = List.of("((((()))))", "(((()())))", "(((())()))", "(((()))())", "(((())))()", "((()(())))", "((()()()))", "((()())())", "((()()))()", "((())(()))", "((())()())", "((())())()", "((()))(())", "((()))()()", "(()((())))", "(()(()()))", "(()(())())", "(()(()))()", "(()()(()))", "(()()()())", "(()()())()", "(()())(())", "(()())()()", "(())((()))", "(())(()())", "(())(())()", "(())()(())", "(())()()()", "()(((())))", "()((()()))", "()((())())", "()((()))()", "()(()(()))", "()(()()())", "()(()())()", "()(())(())", "()(())()()", "()()((()))", "()()(()())", "()()(())()", "()()()(())", "()()()()()");
        List<String> resultList = generateParenthesesN3.generateParenthesis(5);
        Assertions.assertTrue(resultList.containsAll(ansList));
        Assertions.assertEquals(resultList.size(), ansList.size());
    }
}
