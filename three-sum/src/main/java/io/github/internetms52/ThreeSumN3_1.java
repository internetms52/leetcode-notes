package io.github.internetms52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSumN3_1 {

    public List<List<Integer>> threeSum(int[] nums) {
        return process(nums);
    }

    public List<List<Integer>> process(int[] nums) {
        List<List<Integer>> resultList = new ArrayList();
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        for (int fixIdx = 0; fixIdx < nums.length; fixIdx++) {
            for (int i = fixIdx + 1; i < nums.length; i++) {
                int sum1 = sortedNums[fixIdx] + sortedNums[i];
                if (sum1 > 0 && -sum1 < sortedNums[0]) {
                    continue;
                }
                if (sum1 < 0 && -sum1 > sortedNums[sortedNums.length - 1]) {
                    continue;
                }
                for (int j = i + 1; j < sortedNums.length; j++) {
                    if (sum1 > 0 && sortedNums[j] > 0) {
                        continue;
                    }
                    if (sum1 < 0 && sortedNums[j] < 0) {
                        continue;
                    }
                    if (sum1 + sortedNums[j] == 0) {
                        resultList.add(List.of(sortedNums[fixIdx], sortedNums[i], sortedNums[j]));
                        break;
                    }
                }
            }
        }
        if (resultList.size() > 1) {
            return removeDuplicateList(resultList);
        } else {
            return resultList;
        }
    }

    public List<List<Integer>> removeDuplicateList(List<List<Integer>> numList) {
        List<List<Integer>> resultList = new ArrayList(numList);
        for (int i = 0; i < numList.size(); i++) {
            HashSet<Integer> iSet = new HashSet<>(numList.get(i));
            for (int j = i + 1; j < numList.size(); j++) {
                HashSet<Integer> jSet = new HashSet<>(numList.get(j));
                if (iSet.equals(jSet)) {
                    resultList.remove(numList.get(i));
                    break;
                }
            }
        }
        return resultList;
    }
}
