package io.github.internetms52;

public class FindBySubstring {
    public int findStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String subStr = haystack.substring(i, i + needle.length());
            if (subStr.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
