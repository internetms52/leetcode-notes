package io.github.internetms52;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p){
        String[] splitPatterns = splitPatterns(p);
        int[][] dpTable = genMatchingDpTable(s.toCharArray(),splitPatterns);
        return checkMatchingMain(dpTable);
    }

    private boolean checkMatchingMain(int[][] dpTable) {
        int root = dpTable[0][0];
        if (root == 1) {
            return checkMatchingRecursively(1, 1, 0, 0, dpTable);
        }
        if (root == -1) {
            return false;
        }
        if (root == -2) {
            return checkMatchingRecursively(1, 0, 0, 0, dpTable);
        }
        if (root == 2) {
            return checkMatchingRecursively(1, 0, 0, 0, dpTable) || checkMatchingRecursively(1, 1, 0, 0, dpTable);
        }
        return false;
    }

    private boolean checkMatchingRecursively(int pR, int sR, int pIdx, int sIdx, int[][] dpTable) {
        int pBorder = dpTable.length;
        int sBorder = dpTable[0].length;
        int currentValue = dpTable[pIdx][sIdx];
        if (currentValue == -1) {
            return false;
        }
        if (currentValue == 2) {
            if (sIdx + 1 < sBorder) {
                int rightValue = dpTable[pIdx][sIdx + 1];
                if (rightValue == 2) {
                    if (checkMatchingRecursively(pR, sR + 1, pIdx, sIdx + 1, dpTable)) {
                        return true;
                    }
                }
            }
        }
        if (pIdx + 1 < pBorder && sIdx + 1 < sBorder) {
            int bottomRightValue = dpTable[pIdx + 1][sIdx + 1];
            if (bottomRightValue == 1) {
                if (checkMatchingRecursively(pR + 1, sR + 1, pIdx + 1, sIdx + 1, dpTable)) {
                    return true;
                }
            }
            if (bottomRightValue == 2) {
                if (checkMatchingRecursively(pR + 1, sR, pIdx + 1, sIdx + 1, dpTable)) {
                    return true;
                }
                if (checkMatchingRecursively(pR + 1, sR + 1, pIdx + 1, sIdx + 1, dpTable)) {
                    return true;
                }
            }
        }
        if (pIdx + 1 < pBorder) {
            int downValue = dpTable[pIdx + 1][sIdx];
            if (downValue == 1 && sR == 0) {
                if (checkMatchingRecursively(pR + 1, sR + 1, pIdx + 1, sIdx, dpTable)) {
                    return true;
                }
            }
            if (downValue == 2) {
                if (checkMatchingRecursively(pR + 1, sR, pIdx + 1, sIdx, dpTable)) {
                    return true;
                }
                if (checkMatchingRecursively(pR + 1, sR + 1, pIdx + 1, sIdx, dpTable)) {
                    return true;
                }
            }
            if (downValue == -2) {
                if (checkMatchingRecursively(pR + 1, sR, pIdx + 1, sIdx, dpTable)) {
                    return true;
                }
            }
        }
        if (pIdx == pBorder - 1 && sIdx == sBorder - 1) {
            int pDiff = pBorder - pR;
            int sDiff = sBorder - sR;
            if (pDiff == 0 && sDiff == 0) {
                return true;
            }
        }
        return false;
    }

    public int[][] genMatchingDpTable(char[] sChars,String[] patterns){
        int[][] results = new int[patterns.length][sChars.length];
        for(int j=0;j<patterns.length;j++){
            String pattern = patterns[j];
            for(int i=0;i<sChars.length;i++){
                if(pattern.length()==1){
                    if(singleMatching(sChars[i],pattern)){
                        results[j][i] = 1;
                    }else{
                        results[j][i] = -1;
                    }
                }
                if(pattern.length()==2){
                    if(singleMatching(sChars[i],pattern)){
                        results[j][i] = 2;
                    }else{
                        results[j][i] = -2;
                    }
                }
            }
        }
        return results;
    }
    public boolean singleMatching(char c,String pattern){
        char p = pattern.charAt(0);
        if('.' == p){
            return true;
        }else if(c == p){
            return true;
        }else{
            return false;
        }
    }

    private String[] splitPatterns(String s) {
        List<String> patternResults = new ArrayList();
        char[] chars = s.toCharArray();
        int idx = 0;
        String prevStarPattern = "";
        while (idx < chars.length) {
            if (idx + 1 < chars.length && chars[idx + 1] == '*') {
                String pattern = chars[idx] + "" + chars[idx + 1];
                if (!pattern.equals(prevStarPattern)) {
                    patternResults.add(pattern);
                    prevStarPattern = pattern;
                }
                idx = idx + 2;
            } else {
                prevStarPattern = "";
                patternResults.add(chars[idx] + "");
                idx++;
            }
        }
        return patternResults.toArray(new String[]{});
    }
}
