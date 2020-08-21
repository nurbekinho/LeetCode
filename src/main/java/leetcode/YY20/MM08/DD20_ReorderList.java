package leetcode.YY20.MM08;

import leetcode.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DD20_ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);
        ListNode.printElements(head);
    }

    public static void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();
        int count = 0;
        while (head != null) {
            count += 1;
            queue.add(head);
            stack.add(head);
            head = head.next;
        }

        if (count != 0) {
            head = queue.poll();
            ListNode temp = head;
            int i = 2;
            while (i <= count) {
                if (i % 2 != 0) temp.next = queue.poll();
                else temp.next = stack.pop();

                temp = temp.next;
                i++;
            }

            temp.next = null;
        }
    }
}
