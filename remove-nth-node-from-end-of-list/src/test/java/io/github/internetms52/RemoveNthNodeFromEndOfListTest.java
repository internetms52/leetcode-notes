package io.github.internetms52;

import org.junit.jupiter.api.Test;

import static io.github.internetms52.TestDataSet.case1Data;

public class RemoveNthNodeFromEndOfListTest {
    private static final RemoveNthNodeFromEndOfList rnnfeol = new RemoveNthNodeFromEndOfList();

    @Test
    public void case1() {
        ListNode resultListNode = rnnfeol.removeNthFromEnd(case1Data(), 2);
        
    }
}
