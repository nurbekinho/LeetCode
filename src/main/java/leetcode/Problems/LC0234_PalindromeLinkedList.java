package leetcode.Problems;

import leetcode.ListNode;

import java.util.Stack;

public class LC0234_PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(isPalindrome(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));

        head = new ListNode(-129);
        head.next = new ListNode(-129);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode copy = head;
        while (copy != null) {
            stack.push(copy.val);
            copy = copy.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) return false;
            head = head.next;
        }

        return true;
    }
}
