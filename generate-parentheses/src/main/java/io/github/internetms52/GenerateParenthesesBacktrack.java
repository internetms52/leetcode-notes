package io.github.internetms52;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesesBacktrack {

    public List<String> generateParenthesis(int n) {
        HashSet<String> resultSet = new HashSet<>();
        generateParenthesisRecursively("", 0, 0, n, resultSet);
        return new ArrayList<>(resultSet);
    }

    public void generateParenthesisRecursively(String current, int open, int close, int n, Set<String> resultSet) {
        if (open == n && close == n) {
            resultSet.add(current);
            return;
        }
        if (open < n) {
            generateParenthesisRecursively(current + "(", open + 1, close, n, resultSet);
        }
        if (close < open) {
            generateParenthesisRecursively(current + ")", open, close + 1, n, resultSet);
        }
    }
}
