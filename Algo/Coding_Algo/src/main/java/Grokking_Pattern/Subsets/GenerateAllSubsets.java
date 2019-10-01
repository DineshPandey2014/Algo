package Grokking_Pattern.Subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/5670249378611200
 *
 * https://leetcode.com/problems/subsets/
 *
 */
public class GenerateAllSubsets {

  @Test
  public void testFindSubset() {
    int [] input = {1, 5, 3};
    List<List<Integer>> output = findSubsets(input);
    for (List<Integer> list :  output) {
      System.out.println(list);
    }
  }
  // Find all subset of [1, 5, 3]
  // Out Put : [[], [1], [5], [1,5], [3], [1,3], [5,3], [1,5,3]]

  public  List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> allSubset = new ArrayList();

    // Add first empty subset
    allSubset.add(new ArrayList());

    for (Integer num : nums) {
     // We we need add this number to each subset
      int count = allSubset.size();
      for(int i = 0; i < count; i++) {
        // Get the deep copy of each existing list.
        // // create a new subset from the existing subset and insert the current element to it
        List<Integer> newSubset = new ArrayList<>(allSubset.get(i));
        newSubset.add(num);
        allSubset.add(newSubset);
      }

    }
    return allSubset;
  }
}
