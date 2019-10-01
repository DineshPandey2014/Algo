package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *  https://leetcode.com/problems/two-sum-iii-data-structure-design/
 *
 * 170. Two Sum III - Data structure design
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 Design and implement a TwoSum class. It should support the following operations: add
 and find.
 add(input) – Add the number input to an internal data structure.
 find(value) – Find if there exists any pair of numbers which sum is equal to the value.
 For example,
 add(1); add(3); add(5); find(4)  true; find(7)  false

 */
public class Two_Sum_III {

  private Map<Integer, Integer> map;

  /** Initialize your data structure here. */
  public Two_Sum_III() {
    map = new HashMap<>();
  }
  /** Add the number to an internal data structure.. */
  public void add(int number) {
    int count = map.containsKey(number) ? map.get(number) : 0;
    map.put(number, count + 1);

  }

  /** Find if there exists any pair of numbers which sum is equal to the value. */
  public boolean find(int value) {
    for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
      int key = entrySet.getKey();
      int leftNumber = value - key;
      // To handle duplicate numbers
      if(leftNumber == key) {
        if(entrySet.getValue() >= 2) {
          return true;
        }
      } else if(map.containsKey(leftNumber)) {
        return true;
      }
    }
    return false;
  }
}
