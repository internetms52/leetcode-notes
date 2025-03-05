package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;

/**
 * claude 討論出來的答案
 */
public class ReverseNodesInKGroupWithSimpleLoop {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 先檢查是否有 k 個節點
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // 如果不足 k 個，則直接返回
        if (count < k) return head;

        // 反轉前 k 個節點
        ListNode prev = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 對剩餘節點遞迴處理，並連接
        head.next = reverseKGroup(curr, k);

        return prev; // prev 現在是反轉後的頭節點
    }
}
