package io.github.internetms52;

public class TestDataSet {
    public static ListNode case1Given() {
        return new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)
                                )
                        )
                )
        );
    }

    public static ListNode case1Ans() {
        return new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(3,
                                new ListNode(5, null)
                        )
                )
        );
    }

    public static ListNode case2Given() {
        return new ListNode(1);
    }

    public static ListNode case3Given() {
        return new ListNode(1, new ListNode(2, null));
    }

    public static ListNode case3Ans() {
        return new ListNode(1, null);
    }
}
