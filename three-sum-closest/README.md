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

## 兩數距離
int from, to;\
consider from=-2, to=1\
1-(-2) = 3, to-from

consider from=-4, to=-1\
3, -1-(-4)=3, to-from

consider from=0, to=1\
1, to

consider from=-1, to=0\
1, -(-1), -from

consider from=2, to=4\
2, 4-2, to-from

## 學習：
- 排序、雙指針、距離計算
- 距離計算要包含正負，不是純距離，因為要決定哪一個指針要移動
- 這題如果沒有先做過3Sum就有點吃虧了
