package io.github.internetms52;

public class ListNodeValidation {
    public static boolean areEquivalent(ListNode listNode1, ListNode listNode2) {
        if (listNode1 != null && listNode2 != null) {
            boolean result = listNode1.val == listNode2.val;
            if (listNode1.next != null && listNode2.next != null) {
                return result && areEquivalent(listNode1.next, listNode2.next);
            }
            if (listNode1.next == null && listNode2.next == null) {
                return true;
            }
        }
        return false;
    }
}
