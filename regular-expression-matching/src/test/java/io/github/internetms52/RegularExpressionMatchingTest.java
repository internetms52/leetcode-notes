package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegularExpressionMatchingTest {
    private static final RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();

    @Test
    void case1() {
        Assertions.assertFalse(regularExpressionMatching.isMatch("acbbcbcbcbaaacaac", "ac*.a*ac*.*ab*b*ac"));
    }

    @Test
    void case2() {
        Assertions.assertFalse(regularExpressionMatching.isMatch("aaa", "ab*a"));
    }

    @Test
    void case3() {
        Assertions.assertFalse(regularExpressionMatching.isMatch("abcd", "d*"));
    }

    @Test
    void case4() {
        Assertions.assertFalse(regularExpressionMatching.isMatch("baa", ".ba"));
    }

    @Test
    void case5() {
        Assertions.assertTrue(regularExpressionMatching.isMatch("a", "..*"));
    }

    @Test
    void case6() {
        Assertions.assertTrue(regularExpressionMatching.isMatch("ab", ".*"));
    }

    @Test
    void case7() {
        Assertions.assertTrue(regularExpressionMatching.isMatch("aaa", "ab*ac*a"));
    }

    @Test
    void case8() {
        Assertions.assertTrue(regularExpressionMatching.isMatch("a", "c*."));
    }

}
