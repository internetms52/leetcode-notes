# 16. 3Sum Closest
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

## Example1:
Input: nums = [-1,2,1,-4], target = 1 \
Output: 2 \
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

## Example2:
Input: nums = [0,0,0], target = 1\
Output: 0\
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

## Thinking:
- 兩數距離
- 可以移除重覆邏輯

### 原答案:
```
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        return processSortedNums(sortedNums,target);
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
```

## 學習：
- 排序、雙指針、距離計算
- 距離計算要包含正負，不是純距離，因為要決定哪一個指針要移動