package io.github.internetms52;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeTwoSortedListsTest {
    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    @Test
    public void case1() {
        ListNode resultListNode = mergeTwoSortedLists.mergeTwoLists(case1Given1(), case1Given2());
        Assertions.assertEquals(0, resultListNode.compareTo(TestDataSet.case1Ans()));
    }

    @Test
    public void case2() {
        ListNode resultListNode = mergeTwoSortedLists.mergeTwoLists(new ListNode(2), new ListNode(1));
        Assertions.assertEquals(0, resultListNode.compareTo(TestDataSet.case1Ans()));
    }

    @Test
    public void case3() {
        ListNode resultListNode = mergeTwoSortedLists.mergeTwoLists(new ListNode(5), case1Given1());
        Assertions.assertEquals(0, resultListNode.compareTo(TestDataSet.case1Ans()));
    }

    private static ListNode case1Given1() {
        return new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(4, null)
                )
        );
    }

    private static ListNode case1Given2() {
        return new ListNode(
                1,
                new ListNode(
                        3,
                        new ListNode(4, null)
                )
        );
    }

}
