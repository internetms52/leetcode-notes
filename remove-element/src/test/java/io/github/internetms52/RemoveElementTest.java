package io.github.internetms52;

import hobby.internetms52.leetcode.validation.ArrayValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveElementTest {
    private static final RemoveElement rdfsa = new RemoveElement();

    @Test
    void case1() {
        int[] given = TestData.case1Given();
        int[] ans = TestData.case1Ans();
        int k = rdfsa.removeElement(given, 3);
        Assertions.assertEquals(k, ans.length);
        Assertions.assertTrue(
                ArrayValidation.areEquivalent(
                        Arrays.copyOfRange(given, 0, k), ans
                )
        );
    }

    @Test
    void case2() {
        int[] given = TestData.case2Given();
        int[] ans = TestData.case2Ans();
        int k = rdfsa.removeElement(given, 2);
        Assertions.assertEquals(k, ans.length);
        Assertions.assertTrue(
                ArrayValidation.areEquivalent(
                        Arrays.copyOfRange(given, 0, k), ans
                )
        );
    }

}
