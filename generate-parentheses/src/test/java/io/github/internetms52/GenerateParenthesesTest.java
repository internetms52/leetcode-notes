package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenerateParenthesesTest {
    GenerateParenthesesBacktrack generateParentheses = new GenerateParenthesesBacktrack();
    GenerateParenthesesN4 generateParenthesesN4 = new GenerateParenthesesN4();

    @Test
    public void case2() {
        List<String> ansList = List.of("((((()))))", "(((()())))", "(((())()))", "(((()))())", "(((())))()", "((()(())))", "((()()()))", "((()())())", "((()()))()", "((())(()))", "((())()())", "((())())()", "((()))(())", "((()))()()", "(()((())))", "(()(()()))", "(()(())())", "(()(()))()", "(()()(()))", "(()()()())", "(()()())()", "(()())(())", "(()())()()", "(())((()))", "(())(()())", "(())(())()", "(())()(())", "(())()()()", "()(((())))", "()((()()))", "()((())())", "()((()))()", "()(()(()))", "()(()()())", "()(()())()", "()(())(())", "()(())()()", "()()((()))", "()()(()())", "()()(())()", "()()()(())", "()()()()()");
        List<String> resultList = generateParenthesesN4.generateParenthesis(5);
        Assertions.assertTrue(resultList.containsAll(ansList));
        Assertions.assertEquals(resultList.size(), ansList.size());
    }
}
