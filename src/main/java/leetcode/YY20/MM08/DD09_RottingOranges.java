package leetcode.YY20.MM08;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DD09_RottingOranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        }));

        System.out.println(orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 0, 1}
        }));

        System.out.println(orangesRotting(new int[][]{
                {0, 2}
        }));

        System.out.println(orangesRotting(new int[][]{
                {0}
        }));

        System.out.println(orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 2}
        }));

        System.out.println(orangesRotting(new int[][]{
                {1},
                {2}
        }));
    }

    public static int orangesRotting(int[][] grid) {
        List<Point> rotterns = new ArrayList<>();
        int empties = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) rotterns.add(new Point(i, j));
                if (grid[i][j] == 0) empties++;
            }
        }

        if (empties == grid.length * grid[0].length) return 0;

        if (rotterns.size() > 0) {
            int minutes = -1;
            while (true) {
                List<Point> neighbours = new ArrayList<>();
                for (Point rotten : rotterns) {
                    int i = rotten.x;
                    int j = rotten.y;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        neighbours.add(new Point(i - 1, j));
                        grid[i - 1][j] = 2;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        neighbours.add(new Point(i, j - 1));
                        grid[i][j - 1] = 2;
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        neighbours.add(new Point(i + 1, j));
                        grid[i + 1][j] = 2;
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        neighbours.add(new Point(i, j + 1));
                        grid[i][j + 1] = 2;
                    }
                }

                rotterns.clear();
                rotterns.addAll(neighbours);

                int freshOranges = 0;
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == 1) freshOranges++;
                    }
                }

                minutes++;

                if (neighbours.size() > 0) continue;
                if (freshOranges == 0) return minutes;
                else break;
            }
        }

        return -1;
    }
}
