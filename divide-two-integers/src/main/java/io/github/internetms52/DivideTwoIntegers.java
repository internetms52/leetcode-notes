package io.github.internetms52;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long remain = Math.abs(Long.valueOf(dividend));
        long absDivisor = Math.abs(divisor);
        long result = 0;
        boolean diffRange = diffRange(dividend, divisor);
        int overflow = 0;
        if (absDivisor < 0) {
            overflow = 1;
            absDivisor = Math.abs(divisor - 1);
        }
        while (remain >= absDivisor && absDivisor != 1) {
            if (overflow > 0) {
                remain = remain - (absDivisor + overflow);
                overflow = 0;
            } else {
                remain -= absDivisor;
            }
            if (remain > 0) {
                result++;
            }
        }
        if (absDivisor == 1) {
            result = remain;
        }
        if (diffRange) {
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

    boolean diffRange(int dividend, int divisor) {
        return dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;
    }
}
