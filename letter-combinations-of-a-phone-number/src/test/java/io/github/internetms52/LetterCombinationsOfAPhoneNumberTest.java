package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LetterCombinationsOfAPhoneNumberTest {
    private static final LetterCombinationsOfAPhoneNumber LETTER_COMBINATIONS_OF_A_PHONE_NUMBER = new LetterCombinationsOfAPhoneNumber();

    @Test
    void case1() {
        Assertions.assertEquals(
                LETTER_COMBINATIONS_OF_A_PHONE_NUMBER.letterCombinations("23"),
                List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
        );
    }

}
