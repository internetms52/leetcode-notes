package io.github.internetms52;

public class RomanToInt {
    int[] romanNums = new int[]{1, 5, 10, 50, 100, 500, 1000};
    String[] romanWords = new String[]{"I", "V", "X", "L", "C", "D", "M"};

    public String intToRoman(int num) {
        return romanConvertRecursively(num);
    }

    int getByDecimalPlaces(int power, int num) {
        return num / Double.valueOf(Math.pow(10, power)).intValue() % 10;
    }

    int revertTenBaseNum(int power, int num) {
        return num * Double.valueOf(Math.pow(10, power)).intValue();
    }

    String romanConvertRecursively(int num) {
        StringBuilder result = new StringBuilder();
        int numLength = String.valueOf(num).length();
        for (int i = 0; i < numLength; i++) {
            int d = getByDecimalPlaces(i, num);
            if (d == 0) {
                continue;
            }
            for (int j = 0; j < romanNums.length; j++) {
                int tenBaseNum = revertTenBaseNum(i, d);
                if (romanNums[j] == tenBaseNum) {
                    result.insert(0, romanWords[j]);
                    break;
                }
                if (romanNums[j] > tenBaseNum) {
                    if (d == 4 || d == 9) {
                        int remains = romanNums[j] - tenBaseNum;
                        if (remains > 0) {
                            result.insert(0, romanConvertRecursively(remains) + romanWords[j]);
                            break;
                        }
                    }
                    if (j - 1 >= 0) {
                        int remains = tenBaseNum - romanNums[j - 1];
                        result.insert(0, romanWords[j - 1] + romanConvertRecursively(remains));
                        break;
                    }
                } else if (j + 1 == romanNums.length) {
                    int remains = tenBaseNum - romanNums[j];
                    result.insert(0, romanWords[j] + romanConvertRecursively(remains));
                    break;
                }
            }
        }
        return result.toString();
    }
}
