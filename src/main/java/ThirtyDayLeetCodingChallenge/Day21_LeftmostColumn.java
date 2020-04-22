package ThirtyDayLeetCodingChallenge;

import java.util.Arrays;
import java.util.List;

public class Day21_LeftmostColumn {
    public static void main(String[] args) {
        BinaryMatrix bm = new BinaryMatrix(new int[][] {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1}
        });

        System.out.println(leftMostColumnWithOne(bm));

        bm = new BinaryMatrix(new int[][] {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        });

        System.out.println(leftMostColumnWithOne(bm));

        bm = new BinaryMatrix(new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });

        System.out.println(leftMostColumnWithOne(bm));

        bm = new BinaryMatrix(new int[][] {
                {1}
        });

        System.out.println(leftMostColumnWithOne(bm));

        bm = new BinaryMatrix(new int[][] {
                {0, 0},
                {1, 1}
        });

        System.out.println(leftMostColumnWithOne(bm));
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int n = binaryMatrix.dimensions().get(0) - 1;
        int m = binaryMatrix.dimensions().get(1) - 1;
        int i = 0;
        int j = m;
        int index = -1;

        while (i <= n && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                index = j;
                j--;
            }
            else i++;
        }

        return index;
    }

    static class BinaryMatrix {
        private int[][] matrix;

        BinaryMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int get(int x, int y) {
            return matrix[x][y];
        }

        public List<Integer> dimensions() {
            return Arrays.asList(matrix.length, matrix[0].length);
        }
    }
}
