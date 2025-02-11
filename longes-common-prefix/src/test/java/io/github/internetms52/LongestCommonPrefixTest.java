package io.github.internetms52;

import org.junit.jupiter.api.Test;

public class LongestCommonPrefixTest {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    @Test
    public void test1(){
        String result = longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flower","flower","flower"});
        System.out.println(result);
    }
}
