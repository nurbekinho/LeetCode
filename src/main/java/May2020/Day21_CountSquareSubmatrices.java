package May2020;

public class Day21_CountSquareSubmatrices {
    public static void main(String[] args) {
        /*System.out.println(countSquares(new int[][] {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }));

        System.out.println(countSquares(new int[][] {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }));*/

        System.out.println(countSquares(new int[][] {
                {0, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 0}
        }));
        //[[0,1,1,1],[1,1,0,1],[1,1,1,1],[1,0,1,0]]
    }

    public static int countSquares(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    int m = i + 1;
                    int n = j + 1;
                    boolean allOnes = true;

                    while (true) {
                        if (m >= matrix.length || n >= matrix[0].length || matrix[m][n] == 0) break;

                        for (int x = i; x < m; x++) {
                            if (matrix[x][n] == 0) {
                                allOnes = false;
                                break;
                            }
                        }
                        if (!allOnes) break;

                        for (int y = j; y < n; y++) {
                            if (matrix[m][y] == 0) {
                                allOnes = false;
                                break;
                            }
                        }
                        if (!allOnes) break;

                        m++;
                        n++;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
