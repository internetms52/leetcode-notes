package io.github.internetms52;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long remain = Math.abs(Long.valueOf(dividend));
        long absDivisor = Math.abs(divisor);
        long result = 0;
        while (remain >= absDivisor && absDivisor != 1) {
            remain -= absDivisor;
            result++;
        }
        if (absDivisor == 1) {
            result = remain;
        }
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            if (result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return Long.valueOf(-result).intValue();
            }
        } else {
            if (result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return Long.valueOf(result).intValue();
            }
        }
    }
}
