package io.github.internetms52;

import hobby.internetms52.leetcode.validation.ListOfIntegerLists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FourSumTest {
    FourSum fourSum = new FourSum();

    @Test
    public void test1() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(List.of(2, 2, 2, 2));
        Assertions.assertTrue(ListOfIntegerLists.isMutualContainment(result, answerList));
    }

    @Test
    public void test2() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{0, 0, 0, 0}, 1);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void test3() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(List.of(-2, 1, -1, 2));
        answerList.add(List.of(-1, -1, 1, 1));
        Assertions.assertTrue(ListOfIntegerLists.isMutualContainment(result, answerList));
    }

    @Test
    public void test4() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        Assertions.assertEquals(0, result.size());
    }

}
