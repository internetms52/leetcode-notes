package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanToIntTest {
    private static final RomanToInt ROMAN_TO_INT = new RomanToInt();

    @Test
    void case1() {
        Assertions.assertEquals(ROMAN_TO_INT.romanToInt("III"),3);
    }

    @Test
    void case2() {
        Assertions.assertEquals(ROMAN_TO_INT.romanToInt("LVIII"),58);
    }

    @Test
    void case3() {
        Assertions.assertEquals(ROMAN_TO_INT.romanToInt("MCMXCIV"),1994);
    }

    @Test
    void case4() {
        Assertions.assertEquals(ROMAN_TO_INT.romanToInt("MCDLXXVI"),1476);
    }
}
