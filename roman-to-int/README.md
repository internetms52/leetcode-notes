# 13. Roman to Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

## Example2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

## Example3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

## Thinking:
### Word Mapping
| 1   | 5   | 10   | 50   | 100   | 500   | 1000 |
|-----| --- | ---  | ---  | ---   | ---   | ---  |
| I   | V   | X   | L   | C   | D   | M   |      |

### mapping 1:
```
I  I  I
|  |  |---> 1
|  |------> 1
|---------> 1
```
### mapping 2:
```
I  V
|  |------> 5
|---------> 1
(5-1)
```

### general mapping check 3:
```
L  V  I  I
|  |  |  |------> 1
|  |  |---------> 1
|  |------------> 5
|---------------> 50
50+5+1+1=58
```

### complex mapping check 4:
```
M  C  D  L  X  X  V  I
|  |  |  |  |  |  |  |-------> 1  
|  |  |  |  |  |  |----------> 5
|  |  |  |  |  |-------------> 10
|  |  |  |  |----------------> 10
|  |  |  |-------------------> 50
|  |  |----------------------> 500
|  |-------------------------> 100 
|----------------------------> 1000
1000+(500-100)+50+10+10+5+1=1476
```

### rules
- 所有的規則看起來都可以兩個字兩個字讀取來解決
- 倒序看起來對於規則4 or 9更方便
- 不一定要用map，可以用index取代，因為index對應的內容實際上大的也是比較大