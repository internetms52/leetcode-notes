package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;
import hobby.internetms52.leetcode.validation.ListNodeValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeKSortedListsTest {
    MergeKSortedListsDivide mergeKSortedLists = new MergeKSortedListsDivide();

    @Test
    public void case1() {
        ListNode resultListNode = mergeKSortedLists.mergeKLists(TestDataSet.case1Given());
        Assertions.assertTrue(ListNodeValidation.areEquivalent(resultListNode, TestDataSet.case1Ans()));
    }

    @Test
    public void case2() {
        ListNode resultListNode = mergeKSortedLists.mergeKLists(TestDataSet.case2Given());
        Assertions.assertNull(resultListNode);
    }

    @Test
    public void case3() {
        ListNode resultListNode = mergeKSortedLists.mergeKLists(TestDataSet.case3Given());
        Assertions.assertTrue(ListNodeValidation.areEquivalent(TestDataSet.case3Ans(), resultListNode));
    }

}
