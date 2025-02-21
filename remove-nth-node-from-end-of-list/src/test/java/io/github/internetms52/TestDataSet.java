package io.github.internetms52;

public class TestDataSet {
    public static ListNode case1Data() {
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
}
