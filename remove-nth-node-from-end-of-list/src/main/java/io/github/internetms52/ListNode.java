package io.github.internetms52;

public class ListNode implements Comparable<ListNode> {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public int compareTo(ListNode o) {
        if (val == o.val) {
            if (next != null && o.next != null) {
                return next.compareTo(o.next);
            }
            if (next == null && o.next == null) {
                return 0;
            }
        }
        return -1;
    }
}
