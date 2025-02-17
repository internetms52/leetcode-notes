package io.github.internetms52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        return letterCombinationRecursively(digits);
    }

    private List<String> letterCombinationRecursively(String digits) {
        if (digits.length() <= 0) {
            return new ArrayList();
        }
        String chartA = String.valueOf(digits.charAt(0));
        String[] a = letterMapping(chartA);
        if (digits.length() == 1) {
            return Arrays.asList(a);
        } else {
            return letterCombinationWithTwo(
                    a, letterCombinationRecursively(digits.substring(1)).toArray(new String[]{})
            );
        }
    }

    private List<String> letterCombinationWithTwo(String[] a, String[] b) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (String c : b) {
                resultList.add(a[i] + c);
            }
        }
        return resultList;
    }

    private String[] letterMapping(String digit) {
        return switch (digit) {
            case "2" -> new String[]{"a", "b", "c"};
            case "3" -> new String[]{"d", "e", "f"};
            case "4" -> new String[]{"g", "h", "i"};
            case "5" -> new String[]{"j", "k", "l"};
            case "6" -> new String[]{"m", "n", "o"};
            case "7" -> new String[]{"p", "q", "r", "s"};
            case "8" -> new String[]{"t", "u", "v"};
            case "9" -> new String[]{"w", "x", "y", "z"};
            default -> new String[]{};
        };
    }
}
