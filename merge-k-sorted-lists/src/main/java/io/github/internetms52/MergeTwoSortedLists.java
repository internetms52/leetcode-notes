package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return mergeSortedListNodes(list1, list2);
    }

    private ListNode mergeSortedListNodes(ListNode list1, ListNode list2) {
        ListNode result;
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result = newNode(list1.val);
                result.next = mergeSortedListNodes(list1.next, list2);
            } else {
                result = newNode(list2.val);
                result.next = mergeSortedListNodes(list1, list2.next);
            }
        } else if (list1 != null) {
            return list1;
        } else {
            return list2;
        }
        return result;
    }

    private ListNode newNode(int value) {
        return new ListNode(value);
    }
}
