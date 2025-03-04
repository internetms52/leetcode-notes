package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;

public class MergeKSortedListsDivide {
    private static final MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if(lists.length==0){
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return mergeTwoSortedLists.mergeTwoLists(lists[start], lists[end]);
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeTwoSortedLists.mergeTwoLists(left, right);
    }
}
