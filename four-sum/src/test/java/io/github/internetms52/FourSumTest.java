package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FourSumTest {
    FourSum fourSum = new FourSum();

    public boolean checkExists(List<List<Integer>> resultList, List<List<Integer>> targetList) {
        List<List<Integer>> removeList = new ArrayList<>();
        List<List<Integer>> tmpList = new ArrayList<>(targetList);
        for (List<Integer> result : resultList) {
            HashSet<Integer> rSet = new HashSet<>(result);
            for (List<Integer> target : tmpList) {
                HashSet<Integer> jSet = new HashSet<>(target);
                if (rSet.equals(jSet)) {
                    removeList.add(target);
                }
            }
            tmpList.removeAll(removeList);
        }
        return removeList.size() == resultList.size() && resultList.size() == targetList.size();
    }

    @Test
    public void test1() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(List.of(2, 2, 2, 2));
        Assertions.assertTrue(checkExists(result, answerList));
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
        answerList.add(List.of(-2, -1, 1, 2));
        answerList.add(List.of(-1, -1, 1, 1));
        Assertions.assertTrue(checkExists(result, answerList));
    }

    @Test
    public void test4() {
        List<List<Integer>> result = fourSum.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        Assertions.assertEquals(0, result.size());
    }

}
