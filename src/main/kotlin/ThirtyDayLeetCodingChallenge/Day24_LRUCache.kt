fun main() {
    val cache = LRUCache(2 /* capacity */)

    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1)) // returns 1
    cache.put(3, 3) // evicts key 2
    println(cache.get(2)) // returns -1 (not found)
    cache.put(4, 4) // evicts key 1
    println(cache.get(1)) // returns -1 (not found)
    println(cache.get(3)) // returns 3
    println(cache.get(4)) // returns 4

}

class LRUCache(private val capacity: Int) {
    private val map = LinkedHashMap<Int, Int>()

    fun get(key: Int): Int {
        return if (map.containsKey(key)) {
            val value = map[key]
            map.remove(key).also { map[key] = value!! }
            value!!
        } else -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) map.remove(key)
        else if (map.size >= capacity) map.remove(map.keys.first())
        map[key] = value
    }
}
