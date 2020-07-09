package leetcode.YY20.MM05;

public class DD16_OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = oddEvenList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenTemp = even;

        while (odd.next != null && odd.next.next != null) {
            odd.next = evenTemp.next;
            odd = odd.next;
            evenTemp.next = odd.next;
            evenTemp = evenTemp.next;
        }

        odd.next = even;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
