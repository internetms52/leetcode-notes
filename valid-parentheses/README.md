# 20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

## Example1:

Input: s = "()"
Output: true

## Example2:

Input: s = "()[]{}"
Output: true

## Example3:

Input: s = "(]"
Output: false

## Example4:

Input: s = "([])"
Output: true

## Thinking:
- 感覺可以用recursively，但實際用紙模擬的時候發現不太行，因為沒有很明確的子字串分界
  - 因為當某一個子字串處理完並不能簡單的標示還有剩下多少字串要處理
- 最後想了一下這個跟stack非常的搭配，因為
  - 我只要比對當前這個是不是要進stack
  - 如果他把前一個bracket close了，那我就pop他

這應該是一個資料結構題，很有趣，沒有想到可以做到這種題目，當用stack的時候，整個處理流程優雅許多