package io.github.internetms52;

import hobby.internetms52.leetcode.definition.ListNode;

import java.util.Stack;

@Deprecated
public class ReverseNodesInKGroupWithStack {
    Stack<ListNode> st = new Stack<>();
    public ListNode reverseKGroup(ListNode head, int k) {
        if(st.size()==k){
            ListNode newHead = null;
            ListNode currentNode = null;
            while(!st.isEmpty()){
                if(newHead==null){
                    newHead = st.pop();
                    currentNode = newHead;
                }else{
                    currentNode.next = st.pop();
                    currentNode = currentNode.next;
                }
            }
            currentNode.next = reverseKGroup(head,k);
            return newHead;
        } else {
            if(head!=null){
                st.push(head);
                return reverseKGroup(head.next,k);
            }else{
                ListNode newHead = null;
                while(!st.isEmpty()){
                    newHead = st.pop();
                }
                return newHead;
            }
        }
    }
}
