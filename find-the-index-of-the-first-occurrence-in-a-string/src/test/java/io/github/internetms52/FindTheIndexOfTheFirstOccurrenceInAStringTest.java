package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindTheIndexOfTheFirstOccurrenceInAStringTest {
    private static final FindTheIndexOfTheFirstOccurrenceInAString ftiotfoias = new FindTheIndexOfTheFirstOccurrenceInAString();

    @Test
    void case1() {
        int firstIdx = ftiotfoias.findStr("sadbutsad", "sad");
        Assertions.assertEquals(0, firstIdx);
    }

    @Test
    void case2() {
        int firstIdx = ftiotfoias.findStr("leetcode", "leeto");
        Assertions.assertEquals(-1, firstIdx);
    }

    @Test
    void case3() {
        int firstIdx = ftiotfoias.findStr("hello", "ll");
        Assertions.assertEquals(2, firstIdx);
    }

    @Test
    void case4() {
        int firstIdx = ftiotfoias.findStr("aaa", "aaaa");
        Assertions.assertEquals(-1, firstIdx);
    }

    @Test
    void case5() {
        int firstIdx = ftiotfoias.findStr("mississippi", "issipi");
        Assertions.assertEquals(-1, firstIdx);
    }

    @Test
    void case6() {
        int firstIdx = ftiotfoias.findStr("a", "a");
        Assertions.assertEquals(0, firstIdx);
    }

}
