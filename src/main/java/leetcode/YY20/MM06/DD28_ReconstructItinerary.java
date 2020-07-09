package leetcode.YY20.MM06;

import java.util.*;

public class DD28_ReconstructItinerary {
    public static void main(String[] args) {
        DD28_ReconstructItinerary problem = new DD28_ReconstructItinerary();
        //[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(problem.findItinerary(tickets));

        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        tickets.clear();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));
        System.out.println(problem.findItinerary(tickets));
    }

    LinkedList<String> result;
    Map<String, PriorityQueue<String>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList<>();
        map = new HashMap<>();

        for(List<String> ticket : tickets)
        {
            String from = ticket.get(0);
            String destination = ticket.get(1);

            if (!map.containsKey(from)) map.put(from, new PriorityQueue<>());
            map.get(from).add(destination);
        }

        findItineraryRecursively("JFK");

        return result;
    }

    private void findItineraryRecursively(String from) {
        PriorityQueue<String> destinations = map.get(from);

        while (destinations != null && !destinations.isEmpty()) findItineraryRecursively(destinations.poll());

        result.addFirst(from);
    }
}
