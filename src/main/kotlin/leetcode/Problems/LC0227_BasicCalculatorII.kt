fun main() {
    println(calculate("3+ 22*2-2*6/3"))
}

fun calculate(s: String): Int {
    val trimmed = s.replace(" ", "")
    val operations = trimmed.replace("[(0-9)]".toRegex(), "")
    val numbers = trimmed.split("[+\\-*/]".toRegex())
    println(operations + numbers)
    return 1
}

fun getResult(s: String): Int {
    val nums = s.split("[*/]".toRegex())
    val pd = s.replace("[(0-9)]".toRegex(), "")
    if (nums.size <= 1) return s.toInt()
    val result = nums[0]
    println("$nums $pd")
    return 1
}