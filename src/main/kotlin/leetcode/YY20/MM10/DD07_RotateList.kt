fun main() {

}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null) return head

    var size = 1
    var temp = head
    while (temp!!.next != null) {
        size++
        temp = temp!!.next
    }

    temp!!.next = head
    val r = k % size

    for (i in 0 until size - r) {
        temp = temp!!.next
    }

    val newHead = temp!!.next;
    temp!!.next = null;

    return newHead;
}