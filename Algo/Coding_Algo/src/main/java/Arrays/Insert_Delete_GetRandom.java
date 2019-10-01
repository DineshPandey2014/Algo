package Arrays;

import org.junit.Test;

import java.util.*;

/*
https://leetcode.com/problems/insert-delete-getrandom-o1/submissions/

          1. First check to map if the values exist. If exist return true else returns false
          2. First find the index of the value from map. by map.get(val) say i is the index.
          3. Then check this index i should not be the last index
          4. Else swap the element of last index with this index i
          5. Remove the element from list. By using the index. list.remove(list.size());
          6.Remove the element from map. By map.remove(val
          7. IF index is less then the last element
            Get the last value hold in variable say lastOne.
            int lastone = nums.get(nums.size() - 1 );
          8. UPdate the i index of array
              nums.set(i, lastone);
          9. Update the map with new index map(lastone, i)

          10. Remove from map map.remove();
          11. Remove the last element from list
              nums.remove(nums.size() -1)
          12. Return true.
       */

public class Insert_Delete_GetRandom {
  Map<Integer, Integer> map;
  List<Integer> nums;
  java.util.Random random;

  public Insert_Delete_GetRandom() {
    map = new HashMap<>(); // It will map with Value to Index of ArrayList
    nums = new ArrayList(); // It will contains the values
    random = new Random();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if(map.containsKey(val)) {
      return false;
    }

    nums.add(val); // First add to the ArrayList
    map.put(val, nums.size() -1); // Get the index of the ArrayList by using the size of the list.
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if(!map.containsKey(val)) {
      return false;
    }

    int loc = map.get(val); // Location or Array index of the value which need to remove.

    if(loc < nums.size()-1) {

      // Get the last index value of array
      int lastOne = nums.get(nums.size() - 1);
      nums.set(loc, lastOne);  // Update the list index loc with the last array index value
      // Now we will remove the last value from array list based on index
      map.put(lastOne, loc);
    }
    nums.remove(nums.size() - 1);
    // Now remove the val whose index is loc from map
    map.remove(val);

    return true;
  }


  /** Get a random element from the set. */
  public int getRandom() {
    return nums.get(random.nextInt(nums.size()));
  }

  @Test
  public void testNumber() {
    Insert_Delete_GetRandom randomizedSet = new Insert_Delete_GetRandom();

    randomizedSet.insert(11);
    randomizedSet.insert(12);
    randomizedSet.insert(13);
    boolean result = randomizedSet.remove(10);
    System.out.println(result);
  }
}
