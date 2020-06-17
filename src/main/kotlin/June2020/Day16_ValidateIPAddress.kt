fun main() {
    println(validIPAddress("172.16.254.1"))
    println(validIPAddress("172.16.254.01"))
    println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"))
    println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"))
    println(validIPAddress("2001:0db8:85a3::8A2E:0370:7334"))
    println(validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"))
    println(validIPAddress("j001:0db8:85a3:0000:0000:8a2e:0370:7334"))
    println(validIPAddress("2001:db8:85a3:0::8a2E:0370:7334"))
    println(validIPAddress("256.256.256.256"))
}

fun validIPAddress(IP: String): String {
    return when {
        IP.isIPV4() -> "IPv4"
        IP.isIPV6() -> "IPv6"
        else -> "Neither"
    }
}

fun String.isIPV4() : Boolean {
    val numbers = this.split(".")
    if (numbers.size == 4) {
        for (number in numbers) {
            val n = try { Integer.parseInt(number) } catch (e: Exception) { return false }
            if (number[0] !in "0123456789") return false
            else if (number.length > 1 && number[0] == '0') return false
            else if (n !in 0..255) return false
        }

        return true
    }

    return false
}

fun String.isIPV6() : Boolean {
    val valid = "0123456789abcdefABCDEF"
    val numbers = this.split(":")
    if (numbers.size in 2..8) {
        for (number in numbers) {
            if (number.length in 1..4) return false
            for (i in number) {
                if (!valid.contains(i)) return false
            }
        }

        return true
    }

    return false
}
