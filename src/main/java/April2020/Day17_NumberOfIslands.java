package April2020;

import java.util.HashSet;
import java.util.Set;

public class Day17_NumberOfIslands {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray()
        }));

        System.out.println(numIslands(new char[][]{
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
        }));

        System.out.println(numIslands(new char[][]{
                "111".toCharArray(),
                "010".toCharArray(),
                "111".toCharArray()
        }));
    }

    public static int numIslands(char[][] grid) {
        if (grid.length <= 0) return 0;

        int[][] earth = new int[grid.length + 2][grid[0].length + 2];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                earth[i + 1][j + 1] = Integer.parseInt(Character.toString(grid[i][j]));
            }
        }

        int count = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 1; i < earth.length - 1; i++) {
            for (int j = 1; j < earth[i].length - 1; j++) {
                if (visited.contains(i + "_" + j)) continue;

                if (earth[i][j] == 1) {
                    count++;
                    findEdges(i, j, earth, visited);
                }
            }
        }

        return count;
    }

    private static void findEdges(int i, int j, int[][] earth, Set<String> visited) {
        String coordinate = i + "_" + j;
        if (earth[i][j] == 0 || visited.contains(coordinate)) return;

        visited.add(coordinate);
        if (earth[i + 1][j] == 1) findEdges(i + 1, j, earth, visited);
        if (earth[i - 1][j] == 1) findEdges(i - 1, j, earth, visited);
        if (earth[i][j + 1] == 1) findEdges(i, j + 1, earth, visited);
        if (earth[i][j - 1] == 1) findEdges(i, j - 1, earth, visited);
    }
}
