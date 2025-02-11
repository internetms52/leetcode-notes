# 14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

## Example1:
Input: strs = ["flower","flow","flight"] \
Output: "fl"

## Example2:
Input: strs = ["dog","racecar","car"] \
Output: ""
Explanation: There is no common prefix among the input strings.

## Thinking:
- 用第一個字串比較就可以了
- 遇到只有一個字串直接返回
- 使用vertical index跟horizontal index比較
- 因為有可能要一直進行toCharArray()，所以要用cache

## Claude 檢討(因為我的答案只有10% runtime beats Q_Q，所以只好檢討了)：
