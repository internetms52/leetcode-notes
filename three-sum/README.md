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

## Claude 檢討：
(因為我的答案只有10% runtime beats Q_Q，所以只好檢討了)
### 原答案:
```
public class LongestCommonPrefix {
    private char[][] charCache;
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }

        String result = "";
        //i horizontal index
        //j vertical index
        for(int i=0;i<getCharArray(strs,0).length;i++){
            char mapChar='\u0000';
            boolean isBreak = false;
            for(int j=0;j<strs.length;j++){
                char[] chars = getCharArray(strs,j);
                if(i>=chars.length){
                    break;
                }
                if(mapChar=='\u0000'){
                    mapChar = chars[i];
                    continue;
                }
                if(chars[i]!=mapChar){
                    isBreak=true;
                    break;
                }
                if(j+1==strs.length && mapChar!='\u0000'){
                    result+=mapChar;
                }
            }
            if(isBreak){
                break;
            }
        }
        return result;
    }

    public char[] getCharArray(String[] strs,int idx){
        if(charCache==null){
            charCache = new char[strs.length][];
        }
        if(charCache[idx]==null){
            charCache[idx] = strs[idx].toCharArray();
        }
        return charCache[idx];
    }
}
```
### claude修改過後的答案:
```
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    if (strs.length == 1) return strs[0];
    
    // 使用第一個字串作為基準
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
}
```
- 增加了 null 和空陣列的檢查
- 不需要使用字元陣列快取，直接使用 String 的方法
- 邏輯更直觀：以第一個字串為基準，逐漸縮短直到找到共同前綴
- 減少了巢狀迴圈的複雜度

## 學習：
- 只需要比較到最短字串長度這件事是當時分析沒有分析到的，以後要注意終止條件也許可以再更精簡
- 使用str.toCharArray()的時機也許不常見，如果是為了取得字元，也許charAt()方法要好的多，這樣也可以省略cache
- claude的方法用substring來記錄目前對應的結果，更節省記憶體
- claude的方法在遍歷接下來的字串的時候會動態的根據當前prefix的長度來減少比對次數，更節省runtime