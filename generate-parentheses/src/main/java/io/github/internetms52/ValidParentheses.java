package io.github.internetms52;

import java.util.Stack;

public class ValidParentheses {
    Stack<Character> st = new Stack<>();
    String openBrackets = "([{";
    String closeBrackets = ")]}";

    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (st.isEmpty()) {
                st.push(c);
            } else {
                if (openBrackets.indexOf(c) >= 0) {
                    st.push(c);
                } else {
                    int idxOfClose = closeBrackets.indexOf(c);
                    if (!st.pop().equals(openBrackets.charAt(idxOfClose))) {
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }
}
