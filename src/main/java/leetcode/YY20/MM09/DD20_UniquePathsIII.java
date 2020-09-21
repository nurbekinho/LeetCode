package leetcode.YY20.MM09;

public class DD20_UniquePathsIII {
    public static void main(String[] args) {

    }

    public int uniquePathsIII(int[][] grid) {
        int empties = 0;
        int startX = 0;
        int startY = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) ++empties;
                else if(grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        return dfs(grid, startX, startY, empties);
    }

    private int dfs(int[][] grid, int x, int y, int empties) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) return 0;
        if (grid[x][y] == 2) return empties == -1 ? 1 : 0;

        grid[x][y] = -1;
        empties--;
        int total = dfs(grid, x + 1, y, empties) + dfs(grid, x, y + 1, empties) + dfs(grid, x - 1, y, empties) + dfs(grid, x, y - 1, empties);
        grid[x][y] = 0;

        return total;
    }
}
