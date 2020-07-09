package leetcode.YY20.MM06;

import java.awt.*;
import java.util.*;
import java.util.List;

public class DD30_WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));

        board = new char[][]{
                {'a','a'}
        };
        words = new String[]{"aaa"};
        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }

        Map<Character, List<Point>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char current = board[i][j];
                if (!map.containsKey(current)) map.put(current, new ArrayList<>());
                map.get(current).add(new Point(i, j));
            }
        }

        for (String word : words) {
            if (map.containsKey(word.charAt(0))) {
                List<Point> coordinates = map.get(word.charAt(0));
                for (Point coordinate : coordinates) {
                    addIfExists(board, coordinate, 0, word, new HashSet<>(Collections.singletonList(new Point(coordinate.x, coordinate.y))), result);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private static void addIfExists(char[][] board,
                                    Point coordinate,
                                    int charIndex,
                                    String word,
                                    Set<Point> visited,
                                    Set<String> result) {
        if (coordinate.x >= 0
                && coordinate.x < board.length
                && coordinate.y >= 0
                && coordinate.y < board[0].length
                && charIndex < word.length()
                && board[coordinate.x][coordinate.y] == word.charAt(charIndex)) {
            if (charIndex == word.length() - 1) {
                result.add(new StringBuilder(word).reverse().toString());
            }
            else {
                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] direction : directions) {
                    Point newCoordinate = new Point(coordinate.x + direction[0], coordinate.y + direction[1]);
                    if (visited.contains(newCoordinate)) continue;

                    Set<Point> visitedCoordinates = new HashSet<>();
                    visitedCoordinates.addAll(visited);
                    visitedCoordinates.add(newCoordinate);

                    addIfExists(board, newCoordinate, charIndex + 1, word, visitedCoordinates, result);
                }
            }
        }
    }
}
