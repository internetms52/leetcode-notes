package io.github.internetms52;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        return processSortedNums(sortedNums, target);
    }

    public int getDistance(int a, int b) {
        if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
            return b - a;
        } else {
            if (a == 0) {
                return b;
            } else if (b == 0) {
                return -a;
            } else {
                return b - a;
            }
        }
    }

    public int processSortedNums(int[] nums, int target) {
        int result = -1;
        int rDiff = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (leftIdx < rightIdx) {
                int sum = nums[i] + nums[leftIdx] + nums[rightIdx];
                int diff = getDistance(sum, target);
                if (sum == target) {
                    result = sum;
                    rDiff = 0;
                    break;
                }
                if (i == 0 && leftIdx == 1 && rightIdx == nums.length - 1) {
                    result = sum;
                    rDiff = diff;
                }
                if (Math.abs(diff) < Math.abs(rDiff)) {
                    result = sum;
                    rDiff = diff;
                }
                if (diff < 0) {
                    rightIdx -= 1;
                }
                if (diff > 0) {
                    leftIdx += 1;
                }
            }
            if (result == target) {
                break;
            }
        }
        return result;
    }
}
