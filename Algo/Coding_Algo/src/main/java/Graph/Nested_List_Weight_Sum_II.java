package Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 *
 *
 * https://www.youtube.com/watch?v=De1JkWVET2U&t=245s
 *
 *
 */



/*
   https://leetcode.com/problems/nested-list-weight-sum-ii/
 */

/* Algo

    [2,5,[3,[4,8]], 9, [5,6]]

   1. Take two variable as weighted and unweighted
   2. Here weighted graph will


 */
public class Nested_List_Weight_Sum_II {
/* This is correct solution

  public int depthSumInverse(List<NestedInteger> nestedList) {

   // unweighted will hold the sum of each level
    int unweighted = 0;

     // Here weight is defined from the the bottom up.i i.e leaf level integers have weight
   // 1 and the root level integers have the largest level
    inr weighted = 0;

    // nestedList will check if the list is empty
    while (!nestedList.isEmpty()) {

      // List to hold for next level
      List<NestedInteger> nextLevel = new ArrayList<>();
      for (NestedInteger ni : nestedList) {

        if (ni.isInteger()) {
          // unweighted will hold the sum of each level
          // Here weight is defined from the the bottom up.i i.e leaf level integers have weight
          // 1 and the root level integers have the largest level
          unweighted += ni.getInteger();
        }
        else {
          // Here we add all the list to the next level
          nextLevel.addAll(ni.getList());
        }
      }
      // We are moving from top to bottom. Adding weight. So root will have max weight
      // After every level we are adding unweighted to weighted.
      weighted += unweighted;
      nestedList = nextLevel;
    }
    return weighted;
*/

}


//class NestedInteger {
//
//    boolean isInteger() {
//      return true;
//    }
//
//    int getInteger() {
//      return 1;
//    }
//  }
//}
