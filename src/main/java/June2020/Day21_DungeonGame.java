package June2020;

public class Day21_DungeonGame {
    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int health;
                if (i + 1 == n && j + 1 == m) {
                    health = Math.max(1 - dungeon[i][j], 1);
                } else if (i + 1 == n) {
                    health = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                } else if (j + 1 == m) {
                    health = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                } else {
                    int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                    int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                    health = Math.min(right, down);
                }

                dp[i][j] = health;
            }
        }

        return dp[0][0];
    }
}
