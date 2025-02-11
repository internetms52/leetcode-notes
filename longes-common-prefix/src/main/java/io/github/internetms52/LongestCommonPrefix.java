package io.github.internetms52;

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
