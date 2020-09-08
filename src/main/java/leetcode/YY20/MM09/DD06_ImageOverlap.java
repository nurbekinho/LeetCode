package leetcode.YY20.MM09;

public class DD06_ImageOverlap {
    public static void main(String[] args) {

    }

    public static int largestOverlap(int[][] A, int[][] B) {
        int result = 0;
        for (int row = -A.length + 1; row < A.length; row++) {
            for (int col = -A[0].length + 1; col < A[0].length; col++) {
                result = Math.max(result, overlappingOnes(A, B, row, col));
            }
        }

        return result;
    }

    public static int overlappingOnes(int[][] A, int[][] B, int rOffset, int cOffset) {
        int overlaps = 0;
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if ((r + rOffset < 0 || r + rOffset >= A.length) || (c + cOffset < 0 || c + cOffset >= A.length) || (A[r][c] + B[r + rOffset][c + cOffset] != 2))
                    continue;
                overlaps++;
            }
        }

        return overlaps;
    }
}
