package July2020;

public class Day7_IslandPerimeter {
    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][] {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        }));
    }

    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] matrix = new int[n + 2][m + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                matrix[i][j] = grid[i - 1][j - 1];
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int current = matrix[i][j];
                if (current == 1) {
                    perimeter += 4;
                    if (matrix[i + 1][j] == 1) perimeter--;
                    if (matrix[i - 1][j] == 1) perimeter--;
                    if (matrix[i][j + 1] == 1) perimeter--;
                    if (matrix[i][j - 1] == 1) perimeter--;
                }
            }
        }

        return perimeter;
    }
}
