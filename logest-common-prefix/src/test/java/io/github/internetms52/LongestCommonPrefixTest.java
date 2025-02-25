package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonPrefixTest {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    @Test
    public void test1() {
        String result = longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flower", "flower", "flower"});
        Assertions.assertEquals("flower", result);
    }

    @Test
    public void test2() {
        String result = longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"});
        Assertions.assertEquals("fl", result);
    }

    @Test
    public void test3() {
        String result = longestCommonPrefix.longestCommonPrefix(new String[]{"a"});
        Assertions.assertEquals("a", result);
    }
    @Test
    public void test4() {
        String result = longestCommonPrefix.longestCommonPrefix(new String[]{"cir","car"});
        Assertions.assertEquals("c", result);
    }
}
