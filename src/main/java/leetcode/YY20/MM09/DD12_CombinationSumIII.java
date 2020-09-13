package leetcode.YY20.MM09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DD12_CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(4, 17));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        addCombinations(1, n, k, new LinkedList<>(), result);
        return result;
    }

    private static void addCombinations(int start, int n, int k, LinkedList<Integer> list, List<List<Integer>> result) {
        if (n == 0 && list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            list.add(i);
            addCombinations(i + 1, n - i, k, list, result);
            list.removeLast();
        }
    }
}
