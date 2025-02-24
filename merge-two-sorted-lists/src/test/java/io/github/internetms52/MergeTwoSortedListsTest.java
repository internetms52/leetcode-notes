package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeTwoSortedListsTest {
    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    @Test
    public void case1() {
        ListNode resultListNode = mergeTwoSortedLists.mergeTwoLists(TestDataSet.case1Given1(), TestDataSet.case1Given2());
        Assertions.assertTrue(ListNodeValidation.areEquivalent(resultListNode, TestDataSet.case1Ans()));
    }

    @Test
    public void case2() {
        ListNode resultListNode = mergeTwoSortedLists.mergeTwoLists(new ListNode(2), new ListNode(1));
        Assertions.assertEquals(0, resultListNode.compareTo(TestDataSet.case1Ans()));
    }

    @Test
    public void case3() {
        ListNode resultListNode = mergeTwoSortedLists.mergeTwoLists(new ListNode(5), TestDataSet.case1Given1());
        Assertions.assertEquals(0, resultListNode.compareTo(TestDataSet.case1Ans()));
    }
}
