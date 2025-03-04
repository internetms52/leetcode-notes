package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;
import hobby.internetms52.leetcode.validation.ListNodeValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwapNodesInPairsTest {
    SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();

    @Test
    public void case1() {
        ListNode result = swapNodesInPairs.swapPairs(TestDataSet.case1Given());
        Assertions.assertTrue(ListNodeValidation.areEquivalent(result, TestDataSet.case1Ans()));
    }

    @Test
    public void case2() {
        ListNode result = swapNodesInPairs.swapPairs(TestDataSet.case2Given());
        Assertions.assertNull(result);
    }

    @Test
    public void case3() {
        ListNode result = swapNodesInPairs.swapPairs(TestDataSet.case3Given());
        Assertions.assertTrue(ListNodeValidation.areEquivalent(result, TestDataSet.case3Ans()));
    }

    @Test
    public void case4() {
        ListNode result = swapNodesInPairs.swapPairs(TestDataSet.case4Given());
        Assertions.assertTrue(ListNodeValidation.areEquivalent(result, TestDataSet.case4Ans()));
    }

}
