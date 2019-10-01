package Arrays;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

 * Given array with units from 0 ,1,2,3 ...n
 *
 * Using Two Array Solution
 * For each index find max on its left side and max on right side.
 *
 * Hold All left side max in the left array
 * Hold All all right side max in the right Array
 *
 * WaterStored at array index i ---> Min(lefSideMax[i], rightSide[i] - array[i]
 *
 * Best Case : Time Complexity is O(N)
 * Need extra space: 2 O(N) to hold left max and right max.
 * Auxillary space can be optimized to O(1)
 *
 *
 *
 *
 */
public class Trapping_Rain_Water_Array {

//  public int RainTrappingArea (int x[]) {
//
//
//  }
}
