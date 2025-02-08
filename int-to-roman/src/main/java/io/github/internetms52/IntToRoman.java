package io.github.internetms52;

public class IntToRoman {
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
        String result = "";
        int numLength = String.valueOf(num).toCharArray().length;
        for (int i = 0; i < numLength; i++) {
            int d = getByDecimalPlaces(i, num);
            if (d == 0) {
                continue;
            }
            for (int j = 0; j < romanNums.length; j++) {
                int tenBaseNum = revertTenBaseNum(i, d);
                if (romanNums[j] == tenBaseNum) {
                    result = romanWords[j] + result;
                    break;
                }
                if (romanNums[j] > tenBaseNum) {
                    if (d == 4 || d == 9) {
                        int remains = romanNums[j] - tenBaseNum;
                        if (remains > 0) {
                            result = romanConvertRecursively(remains) + romanWords[j] + result;
                            break;
                        }
                    }
                    if (j - 1 >= 0) {
                        int remains = tenBaseNum - romanNums[j - 1];
                        result = romanWords[j - 1] + romanConvertRecursively(remains) + result;
                        break;
                    }
                } else if (j + 1 == romanNums.length) {
                    int remains = tenBaseNum - romanNums[j];
                    result = romanWords[j] + romanConvertRecursively(remains) + result;
                    break;
                }
            }
        }
        return result;
    }
}
