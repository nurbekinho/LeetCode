package leetcode.YY20.MM09;

import java.util.*;

public class DD27_EvaluateDivision {
    public static void main(String[] args) {

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.computeIfAbsent(a, x -> new HashMap<>()).put(b, values[i]);
            graph.computeIfAbsent(b, x -> new HashMap<>()).put(a, 1.0 / values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) result[i] = dfs(graph, new HashSet<>(), queries.get(i).get(0), queries.get(i).get(1));

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String start, String end) {
        if (!graph.containsKey(start) || visited.contains(start)) return -1.0;
        if (start.equals(end)) return 1.0;

        visited.add(start);
        Map<String, Double> map = graph.get(start);
        for (String key : map.keySet()) {
            double result = dfs(graph, visited, key, end);
            if (result != -1) return result * map.get(key);
        }

        return -1;
    }
}