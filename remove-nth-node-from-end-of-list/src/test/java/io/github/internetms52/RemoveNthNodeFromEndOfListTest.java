package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RemoveNthNodeFromEndOfListTest {
    private static final RemoveNthNodeFromEndOfList rnnfeol = new RemoveNthNodeFromEndOfList();

    @Test
    public void case1() {
        ListNode resultListNode = rnnfeol.removeNthFromEnd(TestDataSet.case1Given(), 2);
        Assertions.assertEquals(0, resultListNode.compareTo(TestDataSet.case1Ans()));
    }

    @Test
    public void case2() {
        ListNode resultListNode = rnnfeol.removeNthFromEnd(TestDataSet.case2Given(), 1);
        Assertions.assertNull(resultListNode);
    }

    @Test
    public void case3() {
        ListNode resultListNode = rnnfeol.removeNthFromEnd(TestDataSet.case3Given(), 1);
        Assertions.assertEquals(0, resultListNode.compareTo(TestDataSet.case3Ans()));
    }
}
