package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.github.internetms52.TestDataSet.case1Ans;
import static io.github.internetms52.TestDataSet.case1Given;

public class RemoveNthNodeFromEndOfListTest {
    private static final RemoveNthNodeFromEndOfList rnnfeol = new RemoveNthNodeFromEndOfList();

    @Test
    public void case1() {
        ListNode resultListNode = rnnfeol.removeNthFromEnd(case1Given(), 2);
        Assertions.assertEquals(0, resultListNode.compareTo(case1Ans()));
    }
}
