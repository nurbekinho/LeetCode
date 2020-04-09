fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    printListNode(middleNode(head))

    head.next!!.next!!.next!!.next!!.next = ListNode(6)
    printListNode(middleNode(head))
}

fun middleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
    }

    return slow
}

fun printListNode(head: ListNode?) {
    var head: ListNode? = head
    while (head != null) {
        print("${head.value} - ")
        head = head.next
    }
    println()
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}
