package io.github.internetms52;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSolution(String s, String[] words) {
        int[] traverseArr = genTraverseArr(s, words);
        List<Integer> resultList = new ArrayList();

        int ansLength = getAnsLength(words);
        int toIdx = ansLength;
        int fromIdx = 0;
        int currentIdx = 0;
        int wordCount = 0;
        Set<Integer> wordsIdxSet = new HashSet<>();
        while (toIdx < s.length()) {
            int fromWordIdx = traverseArr[fromIdx];
            if (fromWordIdx == 0) {
                fromIdx++;
                toIdx++;
                currentIdx = fromIdx;
                wordsIdxSet.clear();
                wordCount = 0;
                continue;
            }
            int matchIdx = traverseArr[currentIdx];
            if (matchIdx != 0) {
                wordCount++;
                if (wordCount == words[matchIdx - 1].length()) {
                    wordsIdxSet.add(matchIdx);
                    wordCount = 0;
                }
            }
            if (currentIdx == toIdx || matchIdx == 0) {
                if (wordsIdxSet.size() == words.length) {
                    resultList.add(fromIdx);
                }
                //reset
                int wordLength = words[fromWordIdx - 1].length();
                fromIdx += wordLength;
                toIdx += wordLength;
                currentIdx = fromIdx;
                wordsIdxSet.clear();
                wordCount = 0;
            } else {
                currentIdx++;
            }
        }

        return resultList;
    }

    public int getAnsLength(String[] words) {
        int ansLength = 0;
        for (int i = 0; i < words.length; i++) {
            ansLength += words[i].length();
        }
        return ansLength;
    }

    public int[] genTraverseArr(String s, String[] words) {
        int[] resultTraverseArr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char charI = s.charAt(i);
            for (int j = 0; j < words.length; j++) {
                for (int k = 0; k < words[j].length(); k++) {
                    //match char
                    if (charI == words[j].charAt(k)) {
                        if (k == 0) {
                            resultTraverseArr[i] = j + 1;
                        } else {
                            if (resultTraverseArr[i - 1] == j + 1) {
                                resultTraverseArr[i] = j + 1;
                            }
                        }
                    }
                }
            }
        }
        return resultTraverseArr;
    }
}
