package April2020;

public class Day5_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 7);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += (prices[i] - prices[i - 1]);
        }

        return profit;
    }
}
