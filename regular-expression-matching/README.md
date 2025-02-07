# 10. Regular Expression Matching 
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

## Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

## Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

## dynamic programming dptable, Example 3:
Input: s = "mississippi", p = ```mis*is*ip*i```
| p\s | m   | i   | s   | s   | i   | s   | s   | i   | p   | p   | i   |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| m   | **1**   | -1  | -1  | -1  | -1  | -1  | -1  | -1  | -1  | -1  | -1  |
| i   | -1  | **1**   | -1  | -1  | 1   | -1  | -1  | 1   | -1  | -1  | 1   |
| s*  | -2  | -2  | **2**   | **2**   | -2  | 2   | 2   | -2  | -2  | -2  | -2  |
| i   | -1  | 1   | -1  | -1  | **1**   | -1  | -1  | 1   | -1  | -1  | 1   |
| s*  | -2  | -2  | 2   | 2   | -2  | **2**   | **2**   | -2  | -2  | -2  | -2  |
| i   | -1  | 1   | -1  | -1  | 1   | -1  | -1  | **1**   | -1  | -1  | 1   |
| p*  | -2  | -2  | -2  | -2  | -2  | -2  | -2  | -2  | **2**   | **2**   | -1  |
| .   | 1   | 1   | 1   | 1   | 1   | 1   | 1   | 1   | 1   | 1   | **1**   |
