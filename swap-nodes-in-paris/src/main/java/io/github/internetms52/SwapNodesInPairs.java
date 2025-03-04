package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        return swapPairsRecursively(head);
    }

    public ListNode swapPairsRecursively(ListNode current){
        if(current!=null && current.next!=null){
            ListNode newCurrent = current.next;
            if(newCurrent.next!=null && newCurrent.next.next!=null){
                current.next = swapPairsRecursively(newCurrent.next);
            }else{
                current.next = current.next.next;
            }
            newCurrent.next = current;
            return newCurrent;
        }else{
            return current;
        }
    }
}
