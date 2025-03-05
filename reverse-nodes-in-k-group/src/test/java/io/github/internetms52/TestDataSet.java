package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;

public class TestDataSet {

    public static ListNode case12Given() {
        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    }

    public static int case1GivenK() {
        return 2;
    }

    public static int case2GivenK() {
        return 3;
    }

    public static ListNode case1Ans() {
        return new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(5, null)))));
    }

    public static ListNode case2Ans() {
        return new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(5, null)))));
    }
}
