package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;

import java.util.List;

public class TestDataSet {
    public static ListNode[] case1Given() {
        return new ListNode[]{case1Given11(), case1Given12(), case1Given13()};
    }

    private static ListNode case1Given11() {
        return new ListNode(
                1,
                new ListNode(
                        4,
                        new ListNode(5, null)
                )
        );
    }

    private static ListNode case1Given12() {
        return new ListNode(
                1,
                new ListNode(
                        3,
                        new ListNode(4, null)
                )
        );
    }

    private static ListNode case1Given13() {
        return new ListNode(
                2,
                new ListNode(
                        6,
                        null
                )
        );
    }

    public static ListNode case1Ans() {
        return new ListNode(
                1,
                new ListNode(
                        1,
                        new ListNode(
                                2,
                                new ListNode(
                                        3,
                                        new ListNode(
                                                4,
                                                new ListNode(
                                                        4,
                                                        new ListNode(
                                                                5,
                                                                new ListNode(
                                                                        6, null
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    public static ListNode[] case2Given() {
        return new ListNode[]{};
    }

    public static ListNode case2Ans() {
        return new ListNode();
    }

    public static ListNode[] case3Given(){
        return new ListNode[]{new ListNode()};
    }

    public static ListNode case3Ans(){
        return new ListNode();
    }

}
