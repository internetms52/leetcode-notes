package io.github.internetms52;

import hobby.internetms52.leetcode.validation.ArrayValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DivideTwoIntegersTest {
    DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();

    @Test
    void case1() {
        int k = divideTwoIntegers.divide(-1010369383,-2147483648);
        System.out.println(k);
    }
}
