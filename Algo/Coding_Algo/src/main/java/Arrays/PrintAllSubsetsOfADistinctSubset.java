package Arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Good explaination
 *
 * https://www.algoexpert.io/questions/Powerset
 *
 * Given a set S, generate all distinct subsets of it. Find distinct power set of set S.
 * A power set of any set S is the set of all subsets. Including the empty set and S itself.
 *
 * To find Power Set we have two approaches.
 *
 * 1. Iterative
 * 2. Recursion
 *
 * Time Complexity : For n elements
 *
 * 1. Total subset we have 2^n . As each elements will have two options. Either we include it and not include it.
 *    Now example : {1,2,3} ---> {[], [1], [2], [1,2], [3], [1,3] [2,3], [1,2,3]} ---> 2 * 2 * 2 --> 8
 *                          ---> Now in each subset we have atleast 0 element or max 3 elements average we have n/2 elements
 *                          ---> Total time Complexit --> O(2^n * n/2) ---> O( n 2^n)
 *
 *
 * 2.
 */
public class PrintAllSubsetsOfADistinctSubset {

  @Test
  public void testSubsets() {
    int [] x = {1,2,3};
    List<List<Integer>> powerSetOutPut =  findAllSubsetUsingIterativeApproach(x);
    System.out.println(powerSetOutPut);
  }

  // Iterative solution.
  // {1,2,3}
    /*
        [],
        [1], // One is added to the list zero of the eariler empty set
        [2] , // Two is added to the empty list first and becomes set as [2], and then 2 is added to the set of [1] and become [1,2]
        [1,2],
        [3],
        [1,3],
        [2,3],[1,2,3]

    */
   // Right solution to understand
  public List<List<Integer>> findAllSubsetUsingIterativeApproach(int[] nums) {
    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> list = new ArrayList<>();
    list.add(subset); // Added empty set

    for (Integer element : nums) {
      int lengthOfSubsetList = list.size();
      for (int i = 0; i < lengthOfSubsetList; i++) {
        // Deep copy of the output list. To add the new element to the list as the new subset.
        List<Integer> currentSubset = new ArrayList<>(list.get(i));
        currentSubset.add(element);
        list.add(currentSubset);
      }
    }
    return list;
  }

  // str : Stores input string
// curr : Stores current subset
// index : Index in current subset, curr
  static void powerSet(char [] input, int i, char output [], int k) {
      if(i == input.length) {
        for (int j = 0; j < k; j++) {
          System.out.println(input[j]);
        }
        System.out.println("printed");
        return;
      }
      powerSet(input, i + 1, output, k);
    output[k] = input[i];
    powerSet(input, i + 1, output, k+1);
  }

  // Driver code
  public static void main(String[] args)
  {
    String str = "abc";
     char [] input = str.toCharArray();
     char output [] = new char[input.length];
    powerSet(input, 0, output, 0);

  }

}
