package leetcode.YY20.MM04;

public class DD08_MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printListNode(middleNode(head));

        head.next.next.next.next.next = new ListNode(6);
        printListNode(middleNode(head));
    }

    public static ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        for (int i = 0; i < size / 2; i++) head = head.next;

        return head;
    }

    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " - ");
            head = head.next;
        }

        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
