package io.github.internetms52;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int findStr(String haystack, String needle) {
        int idx = 0;
        int cIdx = 0;
        while (idx < haystack.length()) {
            if (haystack.length() - idx < needle.length()) {
                return -1;
            }
            if (idx + cIdx > haystack.length()) {
                return -1;
            }
            if (cIdx == needle.length()) {
                return idx;
            }
            if (haystack.charAt(idx + cIdx) != needle.charAt(cIdx)) {
                idx++;
                cIdx = 0;
            } else {
                cIdx++;
            }
        }
        return -1;
    }
}
