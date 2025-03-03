package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;

public class MergeKSortedListsDivide {
    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
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
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return mergeTwoSortedLists.mergeTwoLists(left, right);
    }
}
