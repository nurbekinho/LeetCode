package leetcode.YY20.MM04;

public class DD27_MaximalSquare {
    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));

        System.out.println(maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));

        System.out.println(maximalSquare(new char[][]{
                {'1'}
        }));
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length <= 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int length = 1;
                    boolean zeroExists = false;

                    while (length + i < rows && length + j < cols && !zeroExists) {
                        for (int k = j; k <= length + j; k++) {
                            if (matrix[i + length][k] == '0') {
                                zeroExists = true;
                                break;
                            }
                        }

                        for (int k = i; k <= length + i; k++) {
                            if (matrix[k][j + length] == '0') {
                                zeroExists = true;
                                break;
                            }
                        }

                        if (!zeroExists) length++;
                    }

                    max = Math.max(max, length);
                }
            }
        }

        return (int) Math.pow(max, 2);
    }
}
