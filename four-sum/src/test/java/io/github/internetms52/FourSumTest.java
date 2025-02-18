package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FourSumTest {
    FourSum fourSum = new FourSum();

    public boolean check(List<Integer> aList, List<Integer> bList) {
        if (aList.size() != bList.size()) {
            return false;
        }
        HashSet<Integer> aSet = new HashSet<>(aList);
        HashSet<Integer> bSet = new HashSet<>(bList);
        return aSet.equals(bSet);
    }

    public boolean checkResult(List<List<Integer>> resultList, List<List<Integer>> targetList) {
        if (resultList.size() != targetList.size()) {
            return false;
        } else {
            List<List<Integer>> sortedResultList = resultList.stream().map(list -> {
                return list.stream().sorted().collect(Collectors.toList());
            }).toList();
            List<List<Integer>> sortedTargetList = targetList.stream().map(list -> {
                return list.stream().sorted().collect(Collectors.toList());
            }).toList();
            for (int i = 0; i < resultList.size(); i++) {
                if (!check(sortedTargetList.get(i), sortedResultList.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test1() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(List.of(2, 2, 2, 2));
        Assertions.assertTrue(checkResult(result, answerList));
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
        Assertions.assertTrue(checkResult(result, answerList));
    }

    @Test
    public void test4() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        Assertions.assertEquals(0, result.size());
    }

}
