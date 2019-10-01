package Heap_Priority_Queue.PriorityQueue_In_Java;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency_PQ {

  @Test
  public void testFrequencySort() {
    String str = frequencySort("AABBBBCCD");
    System.out.println(str); // BBBBAACCD OR BBBBCCAAD

  }

  public String frequencySort(String s) {

    Map<Character, Integer> map = new HashMap();
    for(int  i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(!map.containsKey(c)) {
        map.put(c, 1);
      } else {
        map.put(c, map.get(c) + 1) ;
      }
    }

    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue(new MapComparator());
    pq.addAll(map.entrySet());

    StringBuffer strbuf = new StringBuffer();

    while(!pq.isEmpty()) {
      Map.Entry<Character, Integer> entry = pq.poll(); // We get the highest frequency object out
      for(int j = 0; j < entry.getValue(); j++) {
        strbuf.append(entry.getKey()); // Apending the character based on the map frequency value.
      }
    }

    return strbuf.toString();

  }

  static class MapComparator implements Comparator <Map.Entry<Character, Integer>> {
    // Here we are doing mapTwo minus mapOne to get in decreasing order.
    @Override
    public int compare(Map.Entry<Character,Integer> mapOne , Map.Entry<Character,Integer> mapTwo) {
      return mapTwo.getValue() - mapOne.getValue();
    }
  }

}
