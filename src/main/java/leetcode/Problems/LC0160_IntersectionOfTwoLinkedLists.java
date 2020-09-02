package leetcode.Problems;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC0160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);

        ListNode headB = new ListNode(3);
        headB.next = headA.next.next.next;

        System.out.println(getIntersectionNode(headA, headB).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Set<ListNode> nodes = new HashSet<>();

        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodes.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }
}
