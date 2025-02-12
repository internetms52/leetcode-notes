package io.github.internetms52;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        return process(nums);
    }

    public List<List<Integer>> process(int[] nums) {
        List<List<Integer>> resultList = new ArrayList();
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();

        for (int fixIdx = 0; fixIdx < nums.length; fixIdx++) {
            for (int i = fixIdx + 1; i < nums.length; i++) {
                int sum1 = nums[fixIdx] + nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (sum1 > 0 && nums[j] > 0) {
                        continue;
                    }
                    if (sum1 < 0 && nums[j] < 0) {
                        continue;
                    }
                    if (sum1 + nums[j] == 0) {
                        resultList.add(List.of(nums[fixIdx], nums[i], nums[j]));
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
