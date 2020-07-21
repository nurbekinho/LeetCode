package leetcode.YY20.MM07;

import leetcode.ListNode;

public class DD20_RemoveLinkedListElements {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) head = removeElements(head.next, val);
        else head.next = removeElements(head.next, val);

        return head;
    }
}
