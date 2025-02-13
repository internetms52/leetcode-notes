package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ThreeSumTest {
//    ThreeSum threeSum = new ThreeSum();
//    ThreeSumN3_1 threeSum = new ThreeSumN3_1();
    ThreeSumN2_1 threeSum = new ThreeSumN2_1();
    public boolean checkExists(List<List<Integer>> resultList, List<List<Integer>> targetList) {
        int count = 0;
        for (List<Integer> result : resultList) {
            HashSet<Integer> rSet = new HashSet<>(result);
            for (List<Integer> target : targetList) {
                HashSet<Integer> jSet = new HashSet<>(target);
                if (rSet.equals(jSet)) {
                    count++;
                }
            }
        }
        return count==resultList.size() && resultList.size()==targetList.size();
    }

    @Test
    public void test1() {
        List<List<Integer>> result = threeSum.process(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(List.of(-1, 2, -1));
        answerList.add(List.of(0, 1, -1));
        Assertions.assertTrue(checkExists(result, answerList));
    }

    @Test
    public void test2() {
        List<List<Integer>> result = threeSum.process(new int[]{0,0,0});
        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(List.of(0, 0, 0));
        Assertions.assertTrue(checkExists(result, answerList));
    }

    @Test
    public void test3() {
        List<List<Integer>> result = threeSum.process(new int[]{-9, -14, -3, 2, 0, -11, -5, 11, 5, -5, 4, -4, 5, -15, 14, -8, -11, 10, -6, 1, -14, -12, -13, -11, 9, -7, -2, -13, 2, 2, -15, 1, 3, -3, -12, -12, 1, -2, 6, 14, 0, -4, -13, -10, -12, 8, -2, -8, 3, -1, 8, 4, -6, 2, 1, 10, 2, 14, 4, 12, 1, 4, -2, 11, 9, -7, 6, -13, 7, -3, 8, 14, 8, 10, 12, 11, -4, -13, 10, 14, 1, -4, -4, 2, 5, 4, -11, -7, 3, 8, -10, 11, -11, -5, 7, 13, 3, -2, 8, -13, 2, 1, 9, -12, -11, 6});
        List<List<Integer>> answerList = new ArrayList<>();
        Assertions.assertEquals(118, result.size());
    }

    @Test
    public void test4() {
        System.out.println(threeSum.process(new int[]{12, 13, 12, 13, -3, 3, 11, 7, 10, 5, 1, 6, 6, 14, 2, -8, -1, -4, 3, -10, 3, -13, 7, -15, 12, 10, -2, -14, 3, -3, -7, 0, -12, 12, -1, 0, 0, -13, -8, -12, 7, 0, 9, -1, -8, -12, 6, 6, -1, -13, 3, -13, -11, -4, 9, -14, -9, 14, 9, 2, -3, -13, 9, 0, -15, -15, 7, -8, -12, 6, -5, 10, 14, -11, -6, -9, 14, 8, 4, -10, 10, -8, 14, 6, 3, 8, 0, 2, 8, -6, 11, 12, -3, 5, -3, -11, 6, 11, -4, 1, -6, -1, -4, -7, 3, -2, -9, -5, -9, 10, 0, 8, -12, -8, -1}).size());
    }

    @Test
    public void test5() {
        System.out.println(threeSum.process(new int[]{13, 14, 1, 2, -11, -11, -1, 5, -1, -11, -9, -12, 5, -3, -7, -4, -12, -9, 8, -13, -8, 2, -6, 8, 11, 7, 7, -6, 8, -9, 0, 6, 13, -14, -15, 9, 12, -9, -9, -4, -4, -3, -9, -14, 9, -8, -11, 13, -10, 13, -15, -11, 0, -14, 5, -4, 0, -3, -3, -7, -4, 12, 14, -14, 5, 7, 10, -5, 13, -14, -2, -6, -9, 5, -12, 7, 4, -8, 5, 1, -10, -3, 5, 6, -9, -5, 9, 6, 0, 14, -15, 11, 11, 6, 4, -6, -10, -1, 4, -11, -8, -13, -10, -2, -1, -7, -9, 10, -7, 3, -4, -2, 8, -13}).size());
    }

    @Test
    public void test6() {
        List<List<Integer>> result = threeSum.process(new int[]{-1,0,1});
        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(List.of(-1,0,1));
        Assertions.assertTrue(checkExists(result, answerList));
    }
}
