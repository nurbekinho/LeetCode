package leetcode.YY20.MM10;

import leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DD13_SortList {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode current = head;
        while (current != null) {
            queue.add(current);
            current = current.next;
        }

        ListNode result = queue.poll();
        current = result;
        while (!queue.isEmpty() || current != null) {
            current.next = queue.poll();
            current = current.next;
        }

        return result;
    }
}