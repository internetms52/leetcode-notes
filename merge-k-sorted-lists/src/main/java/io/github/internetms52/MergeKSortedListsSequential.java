package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;

public class MergeKSortedListsSequential {
    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultListNode = null;
        for (int i = 0; i < lists.length; i++) {
            if (resultListNode == null) {
                resultListNode = lists[i];
            } else {
                resultListNode = mergeTwoSortedLists.mergeTwoLists(resultListNode, lists[i]);
            }
        }
        return resultListNode;
    }
}
