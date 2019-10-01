package Heap_Priority_Queue;

import org.junit.Test;

import java.util.*;

/**
 *
 * https://www.youtube.com/watch?v=HlBG2O8ydhw
 *
 *
 * Here we are fetcching top K frequent Strings.
 *
 * If K =1 , All the elemnts till count is 1
 * Input: a[] = {2, 3, 1};
 * OutPut : [1,2,3]
 *
 * if K = 2  ---> All the elements till count is 2
 * Input: a[] = {2,2,2, 3,3, 1}; --> 2--->3, 3-->2, 1-->1
 * OutPut : [
 *
 *
 */
public class Top_K_Frequent_String {

  @Test
  public void topKFrequentString() {
     int [] out = {2, 2, 2, 3, 3, 1, 1};

    List<Integer> list = topKFrequent(out, 2);
  }

  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> result = new ArrayList();

    Map<Integer, Integer> map = new HashMap();

    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], 1);
      } else {
        int count = map.get(nums[i]) + 1;
        map.put(nums[i], count);
      }
    }

    // Now we have a map. We need to sort the map based on Value. Using Ccomparator.
    // colletion.soort()

    List<Map.Entry> list = new ArrayList(map.entrySet());

    Comparator comp = new Comparator() {
      public int compare(Object o1, Object o2) {

        Integer valueOne = (Integer) ((Map.Entry) o1).getValue();
        Integer valueTwo = (Integer) ((Map.Entry) o2).getValue();

        if (valueOne > valueTwo) {
          return -1;
        } else if (valueOne < valueTwo) {
          return 1;
        } else {
          return 0;
        }
      }
    };

    Collections.sort(list, comp);

    //List<Integer> c = new ArrayList();

    for (Map.Entry entry : list) {
      Integer valueFreq = (Integer) entry.getValue();
      result.add((Integer) entry.getKey());
      if(result.size() == k) {
        break;
      }
    }


    return result;
  }
}