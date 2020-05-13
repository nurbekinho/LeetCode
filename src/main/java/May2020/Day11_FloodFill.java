package May2020;

import java.util.Arrays;

public class Day11_FloodFill {
    public static void main(String[] args) {
        int[][] result = floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        for (int[] r : result) System.out.println(Arrays.toString(r));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int currentColor = image[sr][sc];

        changeColor(image, visited, currentColor, sr, sc, newColor);

        return image;
    }

    private static void changeColor(int[][] image, boolean[][] visited, int currentColor, int i, int j, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || visited[i][j] || image[i][j] != currentColor) return;

        visited[i][j] = true;
        image[i][j] = newColor;

        changeColor(image, visited, currentColor, i + 1, j, newColor);
        changeColor(image, visited, currentColor, i - 1, j, newColor);
        changeColor(image, visited, currentColor, i, j + 1, newColor);
        changeColor(image, visited, currentColor, i, j - 1, newColor);
    }
}
