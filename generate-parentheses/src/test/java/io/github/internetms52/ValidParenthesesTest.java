package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidParenthesesTest {
    ValidParentheses validParentheses = new ValidParentheses();

    @Test
    public void case1() {
        Assertions.assertTrue(validParentheses.isValid("()[]{}"));
    }

    @Test
    public void case2() {
        Assertions.assertFalse(validParentheses.isValid("(]"));
    }

    @Test
    public void case3(){
        Assertions.assertFalse(validParentheses.isValid("(("));
    }
}
