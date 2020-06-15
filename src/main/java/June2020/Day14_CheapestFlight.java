package June2020;

import java.util.Arrays;

public class Day14_CheapestFlight {
    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        System.out.println(findCheapestPrice(3, flights, 0, 2, 1));

        flights = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        System.out.println(findCheapestPrice(3, flights, 0, 2, 0));
    }

    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] costs = new int[n];

        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        for (int i = 0; i <= K; i++) {
            int[] tempCost = Arrays.copyOf(costs, costs.length);
            //System.out.println("tempCost 1:" + Arrays.toString(tempCost));

            for (int[] edge : flights) {
                if (costs[edge[0]] == Integer.MAX_VALUE) continue;

                int start = edge[0];
                int end = edge[1];
                int cost = edge[2];

                tempCost[end] = Math.min(tempCost[end], costs[start] + cost);
            }

            //System.out.println("tempCost 2:" + Arrays.toString(tempCost));

            costs = tempCost;
        }

        //System.out.println(Arrays.toString(costs));

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
