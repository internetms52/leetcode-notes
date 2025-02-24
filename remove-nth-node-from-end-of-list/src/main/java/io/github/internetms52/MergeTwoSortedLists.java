package io.github.internetms52;

import java.util.Stack;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return sortListNodes2(list1, list2);
    }

    public ListNode sortListNodes2(ListNode list1, ListNode list2) {
        ListNode result;
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result = newNode(list1.val);
                result.next = sortListNodes2(list1.next, list2);
            } else {
                result = newNode(list2.val);
                result.next = sortListNodes2(list1, list2.next);
            }
        } else if (list1 != null) {
            return list1;
        } else {
            return list2;
        }
        return result;
    }


    public ListNode sortListNodes(ListNode listNode) {
        Stack<ListNode> listNodeStack = new Stack<>();
        ListNode current = listNode;
        while (current != null) {
            if (listNodeStack.isEmpty()) {
                listNodeStack.push(current);
            } else {
                ListNode prevNode = listNodeStack.pop();
                if (prevNode.val > current.val) {
                    listNodeStack.push(current);
                    listNodeStack.push(prevNode);
                } else {
                    listNodeStack.push(prevNode);
                    listNodeStack.push(current);
                }
            }
            current = current.next;
        }
        ListNode result = null;
        while (!listNodeStack.isEmpty()) {
            ListNode popNode = listNodeStack.pop();
            if (result == null) {
                popNode.next = null;
                result = popNode;
            } else {
                popNode.next = result;
                result = popNode;
            }
        }
        return result;
    }

    public ListNode mergeListNodes(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            ListNode result = newNode(list1.val);
            result.next = newNode(list2.val);
            result.next.next = mergeListNodes(list1.next, list2.next);
            return result;
        } else if (list1 != null) {
            return list1;
        } else {
            return list2;
        }
    }

    private ListNode mergeMultiNodeWhile(ListNode list1, ListNode list2) {
        ListNode rootNode = null;
        ListNode nextNode = null;
        ListNode idxNode1 = list1;
        ListNode idxNode2 = list2;
        while (idxNode1 != null || idxNode2 != null) {
            if (rootNode == null) {
                if (idxNode1 != null && idxNode2 != null) {
                    rootNode = mergeNode(newNode(idxNode1.val), newNode(idxNode2.val));
                    idxNode1 = idxNode1.next;
                    idxNode2 = idxNode2.next;
                } else {
                    if (idxNode1 == null) {
                        rootNode = idxNode2;
                        break;
                    }
                    if (idxNode2 == null) {
                        rootNode = idxNode1;
                        break;
                    }
                }
                nextNode = rootNode.next;
            } else {
                if (idxNode1 != null) {
                    nextNode = latestNode(mergeNode(nextNode, newNode(idxNode1.val)));
                    idxNode1 = idxNode1.next;
                }
                if (idxNode2 != null) {
                    nextNode = latestNode(mergeNode(nextNode, newNode(idxNode2.val)));
                    idxNode2 = idxNode2.next;
                }
            }
        }
        return rootNode;
    }

    private ListNode latestNode(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        } else {
            return latestNode(listNode.next);
        }
    }

    private ListNode newNode(int value) {
        return new ListNode(value);
    }

    public ListNode mergeNode(ListNode list1, ListNode list2) {
        if (list1.val > list2.val) {
            list2.next = list1;
            return list2;
        } else {
            list1.next = list2;
            return list1;
        }
    }
}
