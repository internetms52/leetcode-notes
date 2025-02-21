package io.github.internetms52;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNthFromEndWithWhile(head,n);
    }

    public ListNode removeNthFromEndWithWhile(ListNode head, int n){
        ListNode currentNode = head;
        ListNode prevNode = null;
        int idx = 1;
        int listLength = getListLength(head);
        int targetIdx = listLength-(n-1);
        while(currentNode.next!=null && idx<=targetIdx){
            if(idx==targetIdx-1){
                prevNode = currentNode;
            }
            if(idx==targetIdx){
                break;
            }else{
                idx++;
                currentNode = currentNode.next;
            }
        }
        if(prevNode!=null && currentNode.next!=null){
            prevNode.next = currentNode.next;
        }
        if(prevNode==null && currentNode.next==null){
            return null;
        }
        if(prevNode!=null && currentNode.next==null){
            prevNode.next=null;
        }
        if(prevNode==null && currentNode.next!=null){
            head=currentNode.next;
        }
        return head;
    }

    public int getListLength(ListNode head){
        int result = 1;
        if(head.next!=null){
            result+=getListLength(head.next);
        }
        return result;
    }
}
