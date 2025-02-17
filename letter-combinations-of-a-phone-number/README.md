# 17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive,\ 
return all possible letter combinations that the number could represent.\
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below.\ 
Note that 1 does not map to any letters.

## Example1:
Input: digits = "23"\
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

## Example2:
Input: digits = ""\
Output: []

## Example3:
Input: digits = "2"\
Output: ["a","b","c"]

## 分析:
- 至少需要一個mapping方法，把char轉為字串，考量到範例中是用String array，我們準備String Array比較方便.
- a,b -> ["ad","ae","af","bd","be","bf","cd","ce","cf"] ，考量到他沒有說digits會有幾位，用迴圈不太好，可能要用recursive.
- 用substring拆解digits直到2位然候計算，再用String Array傳入再做計算就完成了.

## 感想：
這題其實偏簡單，發揮空間也比較多