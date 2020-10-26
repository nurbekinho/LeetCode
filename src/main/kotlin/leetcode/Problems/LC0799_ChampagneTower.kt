import kotlin.math.min

fun main() {

}

fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
    val matrix = Array(101) { DoubleArray(101) }
    matrix[0][0] = poured.toDouble()
    for (r in 0..query_row) {
        for (c in 0..r) {
            val result = (matrix[r][c] - 1) / 2.0
            if (result > 0) {
                matrix[r + 1][c] += result
                matrix[r + 1][c + 1] += result
            }
        }
    }

    return min(1.0, matrix[query_row][query_glass])
}

/*
double[][] grid = new double[101][101];

grid[0][0] = poured;

for (int r = 0; r <= query_row; r++) {
    for (int c = 0; c <= r; c++) {
        double res = (grid[r][c] - 1.0) / 2.0;

        if (res > 0) {
            grid[r + 1][c] += res;
            grid[r + 1][c + 1] += res;
        }
    }
}

return Math.min(1, grid[query_row][query_glass]);
 */