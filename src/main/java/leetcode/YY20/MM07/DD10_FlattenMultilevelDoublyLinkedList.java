package leetcode.YY20.MM07;

import leetcode.Node;

public class DD10_FlattenMultilevelDoublyLinkedList {
    public static void main(String[] args) {

    }

    public static Node flatten(Node head) {
        Node current = head;
        while (current != null) {
            if(current.child == null) {
                current = current.next;
                continue;
            }

            Node child = current.child;
            while (child.next != null) child = child.next;

            child.next = current.next;
            if (current.next != null) current.next.prev = child;

            current.next = current.child;
            current.next.prev = current;
            current.child = null;
        }

        return head;
    }
}
