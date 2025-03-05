package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;
import hobby.internetms52.leetcode.validation.ListNodeValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseNodesInKGroupWithStackTest {
    ReverseNodesInKGroupWithStack reverseNodesInKGroupWithStack = new ReverseNodesInKGroupWithStack();

    @Test
    public void case1() {
        ListNode result = reverseNodesInKGroupWithStack.reverseKGroup(TestDataSet.case12Given(), TestDataSet.case1GivenK());
        Assertions.assertTrue(ListNodeValidation.areEquivalent(result, TestDataSet.case1Ans()));
    }

    @Test
    public void case2() {
        ListNode result = reverseNodesInKGroupWithStack.reverseKGroup(TestDataSet.case12Given(),TestDataSet.case2GivenK());
        Assertions.assertTrue(ListNodeValidation.areEquivalent(result, TestDataSet.case2Ans()));
    }

}
