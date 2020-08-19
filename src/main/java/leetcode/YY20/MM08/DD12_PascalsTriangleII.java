package leetcode.YY20.MM08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DD12_PascalsTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(10));
    }

    public static List<Integer> getRow(int rowIndex) {
        int[][] matrix = new int[34][81];
        matrix[0][40] = 1;
        for (int i = 1; i <= 33; i++) {
            for (int j = 1; j <= 79; j++) {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j + 1];
            }
        }

        return Arrays.stream(matrix[rowIndex]).filter(e -> e != 0).boxed().collect(Collectors.toList());
    }
}
