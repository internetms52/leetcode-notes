package io.github.internetms52;

public class DivideTwoIntegersWithLeftShift {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("除數不能為 0");
        }

        // 處理溢出的特殊情況
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 處理符號
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // 轉為正數（使用 long 避免溢出）
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long result = 0;

        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            long multiple = 1;

            // 找到最大的 divisor * 2^k <= dividend
            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            absDividend -= temp;
            result += multiple;
        }

        return negative ? -(int)result : (int)result;
    }

}
