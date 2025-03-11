# 28. Find the Index of the First Occurrence in a String
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

## Example 1:
Input: haystack = "sadbutsad", needle = "sad"\
Output: 0\
Explanation: "sad" occurs at index 0 and 6.\
The first occurrence is at index 0, so we return 0.

## Example 2:
Input: haystack = "leetcode", needle = "leeto"\
Output: -1\
Explanation: "leeto" did not occur in "leetcode", so we return -1.

## Thinking:
- 雙指標，向右滑動，有點slide window的感覺
- 注意多個return 條件，到達字串長度、超過字串長度

## 檢討:
- 這題寫完很快，結果只有22%讓我實在搞不懂，試了很多奇怪的方法，還是差不多
- 後來找了0ms的寫法是用substring的，可是這個不就會額外創建字串物件嗎
- 如果字串很長不就每經過一個char，就要建一個字串物件...
- 我覺得我不是很喜歡這個0ms解答
