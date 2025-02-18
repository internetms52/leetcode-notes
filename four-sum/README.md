# 18. 4Sum
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:\

0 <= a, b, c, d < n\
a, b, c, and d are distinct.\
nums[a] + nums[b] + nums[c] + nums[d] == target\
You may return the answer in any order.

## Example1:
Input: nums = [1,0,-1,0,-2,2], target = 0\
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

## Example2:
Input: nums = [2,2,2,2,2], target = 8\
Output: [[2,2,2,2]]

## Thinking:
- 3Sum變形，從固定一個變成固定兩個，原3Sum演算法已經優化過，這裡直接加一層應該不會影響很多
- 新固定的參數要處理重覆問題
- 測資中有溢位Integer，所以要特別處理Integer的溢位問題

## 學習：
- 基本上還是延續上三角形的做法，也就是j不需要從頭開始確認，只要從i+1的地方開始確認就好了
- 重覆邏輯也應該要從第一個以後，也就是j>i+1的時候進行處理
- 溢位問題要用double轉型來解決，研究了一下似乎直接轉double就好了
- 3Sum中的目標是0，這裡有一些3Sum Closest的影子，加入了target，記得把0換成target
