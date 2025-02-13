15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

## Example1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

## Example2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

## Thinking:
- 雖然是N^3但分析起來只要遍歷上三角，所以應該不會太慢

## Claude 檢討：
這題答案的測資沒有N^3的生存空間，所以這一題只能是用排序後雙指針完成，其它答案都不會被leetcode接受 \ 
是非常沒有空間的一題

### 原答案:
```
package io.github.internetms52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSumN3_1 {

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

```
### 問過Claude後自己寫的雙指針:
```
package io.github.internetms52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSumN2_1 {

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
}

```

## 學習：
- 3sum，排序，雙指針，I去重覆，left去重覆，right去重覆
- 這雙指針大概誰來寫都長差不多，工作上也不可能會用這個，前提條件太多，根本不會有符合的情境
- 個人認為很無聊的題目，不好玩
- 雖然claude說hash也可以N^2，但我試了一下hash光處理重覆就要出人命了，不太可能N^2

如果hash有N^2版麻煩請會的大大跟我說，非常感謝您