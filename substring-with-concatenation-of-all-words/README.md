# 30. Substring with Concatenation of All Words
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

## Example1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]

Explanation:
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

## Example2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []

## Example3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]

## Thinking Example3:
### Word Mapping
| b   | a   | r   | f   | o   | o   | f   | o   | o   | b   | a   | r   | t   | h   | e   | f   | o   | o   | b   | a   | r   | m | a | n|
|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|
| 1   | 1   | 1   | 2   | 2   | 2   | 2   | 2   | 2   | 1   | 1   | 1   | 3   | 3   | 3   | 2   | 2   | 2   | 1   | 1   | 1   |0|0|0|

### resultIdxArr
[0][0]="0,9,18" \
[0][1]="1,10,19" \
[0][2]="2,11,20" 

[1][0]="3,6,15" \
[1][1]="4,7,16" \ 
[1][2]="5,8,17" 

[2][0]="12" \
[2][1]="13" \
[2][2]="14"

### 困難點
1. 答案字串可以重疊判定(如Example3)
2. 字串需要連續判定，中間不能插入其它的(Example1)
3. 記錄是否包含該字不夠，還要知道是哪一個字
4. 解答判定時，光確認該字不夠，還要確認是否包含該字的每一個字元

