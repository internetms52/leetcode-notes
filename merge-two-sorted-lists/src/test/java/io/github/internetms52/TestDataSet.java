package io.github.internetms52;

public class TestDataSet {
    static ListNode case1Given1() {
        return new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(4, null)
                )
        );
    }

    static ListNode case1Given2() {
        return new ListNode(
                1,
                new ListNode(
                        3,
                        new ListNode(4, null)
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
                                                        null
                                                )
                                        )
                                )
                        )
                )
        );
    }
}
