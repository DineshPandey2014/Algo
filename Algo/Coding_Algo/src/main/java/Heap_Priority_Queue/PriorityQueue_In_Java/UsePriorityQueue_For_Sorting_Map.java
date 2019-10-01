package Heap_Priority_Queue.PriorityQueue_In_Java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class UsePriorityQueue_For_Sorting_Map {

  public static void main(String args[]) {
    sortMap();
  }


  public static void sortMap() {
    Map<Character, Integer> map = new HashMap<>();
    // String str = "AAABBBCCDDD";

    map.put('A', 2);
    map.put('B', 3);
    map.put('D', 1);
    map.put('C', 1);

    // Sorting Map Using Priority Queue

    Comparator comp = new Comparator<Map.Entry<Character, Integer>>() {
      @Override
      public int compare(Map.Entry<Character, Integer> mapOne, Map.Entry<Character, Integer> mapTwo) {
        return mapTwo.getValue() - mapOne.getValue();
      }
    };

    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(comp);
    pq.addAll(map.entrySet());

    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }

  }

}
