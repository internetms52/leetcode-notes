package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivideTwoIntegersTest {
    DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();

    @Test
    void case1() {
        int k = divideTwoIntegers.divide(-1010369383, -2147483648);
        Assertions.assertEquals(k, 0);
    }

    @Test
    void case2() {
        int k = divideTwoIntegers.divide(10, 3);
        Assertions.assertEquals(k, 3);
    }

    @Test
    void case3() {
        int k = divideTwoIntegers.divide(7, -3);
        Assertions.assertEquals(k, -2);
    }

    @Test
    void case4() {
        int k = divideTwoIntegers.divide(-2147483648, -1);
        Assertions.assertEquals(k, 2147483647);
    }
}
