package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArrayTest {
    private static final RemoveDuplicatesFromSortedArray rdfsa = new RemoveDuplicatesFromSortedArray();

    @Test
    void case1() {
        int[] given = TestData.case1Given();
        int[] ans = TestData.case1Ans();
        int k = rdfsa.removeDuplicates(given);
        Assertions.assertEquals(k, ans.length);
        Assertions.assertTrue(
                areArraysEqual(
                        Arrays.copyOfRange(given, 0, k), ans
                )
        );
    }

    @Test
    void case2() {
        int[] given = TestData.case2Given();
        int[] ans = TestData.case2Ans();
        int k = rdfsa.removeDuplicates(given);
        Assertions.assertEquals(k, ans.length);
        Assertions.assertTrue(
                areArraysEqual(
                        Arrays.copyOfRange(given, 0, k), ans
                )
        );
    }

    public boolean areArraysEqual(int[] array1, int[] array2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        if (array1.length != array2.length) {
            return false;
        }

        for (int num : array1) {
            set1.add(num);
        }

        for (int num : array2) {
            set2.add(num);
        }

        return set1.equals(set2);
    }

}
