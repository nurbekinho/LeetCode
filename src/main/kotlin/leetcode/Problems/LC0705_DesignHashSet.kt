package leetcode.Problems

fun main() {
    var obj = MyHashSet()
    obj.add(1)
    println(obj)
    obj.remove(2)
    println(obj)
    var param3 = obj.contains(3)
    println(param3)
}

class MyHashSet() {
    var data: MutableSet<Int> = mutableSetOf()

    fun add(key: Int) {
        data.add(key)
    }

    fun remove(key: Int) {
        data.remove(key)
    }

    /** Returns true if this set contains the specified element */
    fun contains(key: Int) = data.contains(key)
}