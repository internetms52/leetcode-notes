package io.github.internetms52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSumN2_1 {

    public List<List<Integer>> threeSum(int[] nums) {
        return process(nums);
    }

    public List<List<Integer>> process(int[] nums) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        return processSortedNums(sortedNums);
    }

    public List<List<Integer>> processSortedNums(int[] nums) {
        List<List<Integer>> resultList = new ArrayList();
        for (int i = 0; i < nums.length - 2; i++) {
            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (leftIdx < rightIdx) {
                int sum = nums[i] + nums[leftIdx] + nums[rightIdx];
                if (sum == 0) {
                    resultList.add(List.of(nums[i], nums[leftIdx], nums[rightIdx]));
                    leftIdx += 1;
                    rightIdx -= 1;
                    while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]) {
                        leftIdx += 1;
                    }
                    while (leftIdx < rightIdx && rightIdx + 1 < nums.length && nums[rightIdx] == nums[rightIdx + 1]) {
                        rightIdx -= 1;
                    }
                }
                if (sum > 0) {
                    rightIdx -= 1;
                }
                if (sum < 0) {
                    leftIdx += 1;
                }
            }
        }
        return resultList;
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
