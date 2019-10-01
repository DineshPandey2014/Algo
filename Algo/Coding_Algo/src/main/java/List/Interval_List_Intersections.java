package List;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * https://www.youtube.com/watch?v=d2sdkUc9OZs
 *
 *
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

 Return the intersection of these two interval lists.

 (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)



 Example 1:



 Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 */

public class Interval_List_Intersections {

  // For intersection of intervals.
  // [x1, y1] ==> Lets say this array is having index i
  // [x2, y2] ==> Lets say this array is having index j.
    /*
      There will be three cases.
      1. There is no intersection : [y1] < [x2] ==> In this case will increment i++;
      2. There is no intersection : [y2] < [x1]==> In this case will increment j++;

      3. There is intersection : x => Math.Max(x1, x2)
                                 y => Math.Min(y1, y2)

         Increment in array based on two condition.
         a) y2 > y1 => i++
         b) y1 >= y2 => j++


    */
  public int[][] intervalIntersection(int[][] A, int[][] B) {

    int len1 = A.length;
    int len2 = B.length;

    List<int []> result = new ArrayList();

    int i = 0; // Index for Array A
    int j = 0; // Index for Array B


    while(i < len1 && j < len2) {
      int x1 = A[i][0];
      int y1 = A[i][1];
      int x2 = B[j][0];
      int y2 = B[j][1];

      if(y1 < x2) {// No intersection
        i++;
      } else if(y2 < x1) {// No intersection
        j++;
      } else { // Intersection
        int x = Math.max(A[i][0], B[j][0]); // For x
        int y = Math.min(A[i][1], B[j][1]);
        int [] input = {x, y};
        result.add(input);

        // Here we are considering when y1 == y2.
        if(y1 >= y2) {
          j++;
        } else {
          i++;
        }
      }
    }


    int n = result.size();

    int output [] [] = result.toArray(new int [n] [2]);

    return output;
  }

}
