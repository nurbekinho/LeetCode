package leetcode.YY20.MM07;

import java.util.HashSet;
import java.util.Set;

public class DD21_WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0) && exist(i, j,0, board, word, visited)) return true;
        return false;
    }

    private static boolean exist(int i, int j, int index, char[][] board, String word, Set<String> visited) {
        if (index == word.length()) return true;

        String current = i + "-" + j;
        if (i >= board.length|| i<0 || j<0 || j>= board[0].length || visited.contains(current) || word.charAt(index) != board[i][j]) return false;

        visited.add(current);
        if(exist(i+1, j, index+1, board, word, visited)||
                exist(i-1, j, index+1, board, word, visited)||
                exist(i, j+1, index+1, board, word, visited)||
                exist(i, j-1, index+1, board, word, visited))
            return true;

        visited.remove(current);

        return false;
    }
}
