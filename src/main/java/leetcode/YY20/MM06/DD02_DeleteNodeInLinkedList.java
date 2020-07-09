package leetcode.YY20.MM06;

import leetcode.ListNode;

public class DD02_DeleteNodeInLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        deleteNode(node.next);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

        node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        deleteNode(node.next.next);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
