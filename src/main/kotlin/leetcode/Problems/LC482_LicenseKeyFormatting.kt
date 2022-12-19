fun main() {
    println(licenseKeyFormatting("5F3Z-2e-9-w", 4))
    println(licenseKeyFormatting("2-5g-3-J", 2))
    println(licenseKeyFormatting("2-4A0r7-4k", 4))
    println(licenseKeyFormatting("2-4A0r7-4k",3))
}

fun licenseKeyFormatting(s: String, k: Int): String {
    val merged = s.split("-").joinToString("").toUpperCase()
    val result = StringBuilder()
    var start = 0
    var end = if (merged.length % k != 0) merged.length % k else k
    while (end <= merged.length) {
        result.append(if (start == 0) "" else "-").append(merged.substring(start, end))
        start = end
        end += k
    }

    return result.toString()
}