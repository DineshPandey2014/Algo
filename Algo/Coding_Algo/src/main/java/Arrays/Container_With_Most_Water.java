package Arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * https://www.youtube.com/watch?v=L2O11Qh-Lgw
 *
 * Container With Most Water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.



 The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 In this case, the max area of water (blue section) the container can contain is 49.

 Example:

 Input: [1,8,6,2,5,4,8,3,7]
 Output: 49
 */

import org.junit.Test;

/**
 * Brute force algorithm. Taking two for loops. One outer loop and one inner loop.
 * Take every combination and find the area to see if it is max or not.
 *
 * O(n2)  Two loops solution.
 *
 */
public class Container_With_Most_Water {
  // https://www.youtube.com/watch?v=L2O11Qh-Lgw

  // Two pointer aproach.
  // Here we are not sorting the array.
  // To maximize the area take the minimum length of the two pointer
  // Find the area = minimum length which is height * difference between the index which is length in x         axis
  // Here we need to increase the area. Once we find the greate length we need to move the other side
  // of pointer which is greate then this pointer and then compare the area. If it greater then the previous swap the area.

  @Test
  public void testMaxArea() {
    int [] input = {1,8,6,2,5,4,8,3,7};
    int result = maxArea(input);
  }

  public int maxArea(int[] height) {
    // Left pointer start with 0 index
    int leftPointer = 0;

    // Right pointer start with max length -1 means last index.
    int rightPointer = height.length -1;

    // intitalize the area with minimum value. Will compare the area later. If Found greater then the         // previous area swap with the new one.
    int maxArea = Integer.MIN_VALUE;

    while(leftPointer < rightPointer) {
      int minHeight = Math.min(height[leftPointer], height[rightPointer]);

      int currentArea = minHeight * (rightPointer - leftPointer);

      if(currentArea > maxArea) {
        maxArea =  currentArea;
      }

      if(height[leftPointer] > height[rightPointer]) {
        rightPointer--;
      } else {
        leftPointer++;

      }

    }
    return maxArea;
  }
}
