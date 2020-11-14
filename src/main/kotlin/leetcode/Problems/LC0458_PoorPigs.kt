import kotlin.math.ceil
import kotlin.math.ln

fun main() {

}

fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
    return ceil(ln(buckets.toDouble()) / ln(minutesToTest / minutesToDie + 1.toDouble())).toInt()
}