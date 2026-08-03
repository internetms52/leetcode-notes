package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SubstringWithConcatenationOfAllWordsTest {
    private static final SubstringWithConcatenationOfAllWords swcoaw = new SubstringWithConcatenationOfAllWords();

    @Test
    void case1() {
        List<Integer> resultList = swcoaw.findSolution("barfoothefoobarman", new String[]{"foo", "bar"});
        List<String> resultStringList = resultList.stream().map(String::valueOf).toList();
        String result = String.join(",", resultStringList);
        Assertions.assertEquals("0,9",result);
    }

    @Test
    void case2(){
        List<Integer> resultList = swcoaw.findSolution("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
        List<String> resultStringList = resultList.stream().map(String::valueOf).toList();
        String result = String.join(",", resultStringList);
        Assertions.assertEquals("6,9,12",result);
    }

}
