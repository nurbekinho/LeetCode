import kotlin.math.max

fun main() {
    println(compareVersion("0.1", "1.1"))
    println(compareVersion("1.0.1", "1"))
    println(compareVersion("7.5.2.4", "7.5.3"))
    println(compareVersion("1.01", "1.001"))
    println(compareVersion("1.0", "1.0.0"))
}

fun compareVersion(version1: String, version2: String): Int {
    val v1 = version1.split(".")
    val v2 = version2.split(".")
    for (i in 0 until max(v1.size, v2.size)) {
        val val1 = try { v1[i].toInt() } catch (e: Exception) { 0 }
        val val2 = try { v2[i].toInt() } catch (e: Exception) { 0 }
        if (val1 > val2) return 1
        if (val1 < val2) return -1
    }

    return 0
}