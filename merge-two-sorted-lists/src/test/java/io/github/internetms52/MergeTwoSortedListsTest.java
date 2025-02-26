package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;
import hobby.internetms52.leetcode.validation.ListNodeValidation;
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
        Assertions.assertTrue(ListNodeValidation.areEquivalent(TestDataSet.case2Ans(), resultListNode));
    }

    @Test
    public void case3() {
        ListNode resultListNode = mergeTwoSortedLists.mergeTwoLists(new ListNode(5), TestDataSet.case1Given1());
        Assertions.assertTrue(ListNodeValidation.areEquivalent(TestDataSet.case3Ans(), resultListNode));
    }

    @Test
    public void case4() {
        ListNode resultListNode = mergeTwoSortedLists.mergeTwoLists(null, null);
        Assertions.assertNull(resultListNode);
    }

    @Test
    public void case5() {
        ListNode resultListNode = mergeTwoSortedLists.mergeTwoLists(null, new ListNode(0));
        Assertions.assertTrue(ListNodeValidation.areEquivalent(new ListNode(0), resultListNode));
    }

    @Test
    public void case6() {
        ListNode resultListNode = mergeTwoSortedLists.mergeTwoLists(TestDataSet.case6Given1(), TestDataSet.case6Given2());
        Assertions.assertTrue(ListNodeValidation.areEquivalent(TestDataSet.case6Ans(), resultListNode));
    }

}
