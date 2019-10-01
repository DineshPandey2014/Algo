package List;

import org.junit.Test;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=9zDe18pAku8&t=2s
 *
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class Reconstruct_Itinerary {

  @Test
  public void testfindItinerary() {
    String[][] input = {
            {"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}
    };

    String[][] inputTwo = {
            {"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}
    };

    String[][] inputThree = {
            {"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}
            // JFK , KUL, NRT,
    };


//    List<String> result = findItinerary(input);
//    for (String str : result) {
//      System.out.println(str);
//    }

    List<String> result = findItinerary(inputThree);
    for (String str : result) {
      System.out.println(str);
    }

  }


  public List<String> findItinerary(String[][] tickets) {
    //Input [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
    //OutPut Here we need to OutPut as JFK -->MUC--->JHR--->SFO--->SJC

    Map<String, PriorityQueue<String>> map = new HashMap<>();

    for (int i = 0; i < tickets.length; i++) {
      String[] path = tickets[i];
      if (!map.containsKey(path[0])) {
        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add(path[1]);
        map.put(path[0], pq);
      } else {
        PriorityQueue<String> pq = map.get(path[0]);
        pq.add(path[1]);
        map.put(path[0], pq);
      }
    }

    List<String> list = new ArrayList<>();
    visit("JFK", map, list);
    return list;

  }

  // Given The itinerary must begin from "JFK"
  public void visit(String airport, Map<String, PriorityQueue<String>> map, List<String> list) {
    if (airport != null) {
      list.add(airport);
    }
    if (map.containsKey(airport)) {
      PriorityQueue<String> mapAirPortPQ = map.get(airport);
      String nextAirport = mapAirPortPQ.poll();
      visit(nextAirport, map, list);

    }
  }
}


