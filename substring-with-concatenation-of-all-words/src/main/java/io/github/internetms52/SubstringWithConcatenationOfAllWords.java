package io.github.internetms52;

import java.util.ArrayList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int[] traverseArr = genTraverseArr(s,words);
        List<Integer> resultList = new ArrayList();
        int ansLength = getAnsLength(words);
        int currentAnsIdx=-1;
        int totalSize = 0;
        for(int i=0;i<traverseArr.length;i++){
            if(traverseArr[i]==1 && currentAnsIdx<0){
                currentAnsIdx=i;
            }
            if(currentAnsIdx>0){
                totalSize++;
            }
            if(traverseArr[i]==0){
                if(currentAnsIdx>0 && totalSize==ansLength){
                    resultList.add(currentAnsIdx);

                }
                currentAnsIdx=-1;
                totalSize=0;
            }
        }
        return resultList;
    }

    public int getAnsLength(String[] words){
        int ansLength =0;
        for(int i=0;i<words.length;i++){
            ansLength+=words[i].length();
        }
        return ansLength;
    }

    public int[] genTraverseArr(String s, String[] words){
        int[] resultTraverseArr = new int[s.length()];
        for(int i=0;i<s.length();i++){
            char charI = s.charAt(i);
            for(int j=0;j<words.length;j++){
                for(int k=0;k<words[j].length();k++){
                    //match char
                    if(charI==words[j].charAt(k)){
                        if(k==0){
                            resultTraverseArr[i]=1;
                        }else{
                            if(resultTraverseArr[i-1]==1){
                                resultTraverseArr[i]=1;
                            }
                        }
                    }
                }
            }
        }
        return resultTraverseArr;
    }
}
