package June2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day17_SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solve(board);
    }

    public static void solve(char[][] board) {
        if (board.length == 0) return;

        Set<String> excluded = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if (board[i][j] == 'O') findExcluded(i, j, board, excluded);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String coordinate = i + "-" + j;
                if (!excluded.contains(coordinate)) board[i][j] = 'X';
            }
        }

        for (char[] b : board) System.out.println(Arrays.toString(b));
    }

    private static void findExcluded(int i, int j, char[][] board, Set<String> excluded) {
        int rows = board.length;
        int cols = board[0].length;
        String coordinate = i + "-" + j;

        if (i >= 0 && i < rows && j >= 0 && j < cols && board[i][j] == 'O' && !excluded.contains(coordinate)) {
            excluded.add(coordinate);
            findExcluded(i + 1, j, board, excluded);
            findExcluded(i - 1, j, board, excluded);
            findExcluded(i, j + 1, board, excluded);
            findExcluded(i, j - 1, board, excluded);
        }
    }
}
