package leetcode.Problems;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC0141_LinkedListCycle {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) return true;

            nodes.add(head);
            head = head.next;
        }

        return false;
    }
}
