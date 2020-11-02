package leetcode.Problems;

import leetcode.ListNode;

public class LC0147_InsertionSortList {
    public static void main(String[] args) {

    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = head, previous = dummy, temp;
        while (current != null) {
            if (previous.val > current.val) previous = dummy;
            while (previous.next != null && current.val > previous.next.val) previous = previous.next;

            temp = current.next;
            current.next = previous.next;
            previous.next = current;
            current = temp;
        }

        return dummy.next;
    }
}
