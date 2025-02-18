package io.github.internetms52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        return fourSumSolution(sortedNums, target);
    }

    public List<List<Integer>> fourSumSolution(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int leftIdx = j + 1;
                int rightIdx = nums.length - 1;
                while (leftIdx < rightIdx) {
                    double sum = (double) nums[i] + (double) nums[j] + (double) nums[leftIdx] + (double) nums[rightIdx];
                    if (sum == target && sum <= Integer.MAX_VALUE) {
                        resultList.add(List.of(nums[i], nums[j], nums[leftIdx], nums[rightIdx]));
                        leftIdx += 1;
                        rightIdx -= 1;
                        while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]) {
                            leftIdx += 1;
                        }
                        while (leftIdx < rightIdx && rightIdx + 1 < nums.length && nums[rightIdx] == nums[rightIdx + 1]) {
                            rightIdx -= 1;
                        }
                    }
                    if (sum > target) {
                        rightIdx -= 1;
                    }
                    if (sum < target) {
                        leftIdx += 1;
                    }
                }
            }
        }
        return resultList;
    }
}
