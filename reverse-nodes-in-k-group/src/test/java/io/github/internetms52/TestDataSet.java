package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;

public class TestDataSet {

    public static ListNode case1Given() {
        return new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
    }

    public static ListNode case1Ans() {
        return new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(3, null))));
    }

    public static ListNode case2Given() {
        return null;
    }

    public static ListNode case3Given() {
        return new ListNode(1);
    }

    public static ListNode case3Ans() {
        return new ListNode(1);
    }

    public static ListNode case4Given() {
        return new ListNode(1, new ListNode(2, new ListNode(3, null)));
    }

    public static ListNode case4Ans() {
        return new ListNode(2, new ListNode(1, new ListNode(3, null)));
    }
}
