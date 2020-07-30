package leetcode.YY20.MM07;

public class DD29_BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int temp = 0;
        int sell = 0;
        int buy = -1 * prices[0];

        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, temp - prices[i]);
            temp = Math.max(temp, sell);
            sell = buy + prices[i];
        }

        return Math.max(temp, sell);
    }
}
