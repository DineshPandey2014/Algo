package Arrays;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/interval-list-intersections/
class Interval_List_Intersection {
  /*
  Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

  Return the intersection of these two interval lists.

  Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
  Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
  Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.


  (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
  The intersection of two closed intervals is a set of real numbers that is either empty,
  or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

  Here we are taking two pointer approach i and j. It's given interval are disjoint and sorted order.
  1. First we compare two interval and find the intersection. To find the intersection between two
  interval we need to do (k1, k2), (i1, i2)
  a. We need to find the max of start
  b  We need to find the min of end
  This will give the overlap interval of two
  Say (k1, i2)

  2. Once we get the overlap interval. We need to increment the counter to to that Array whose
  end is mathing the min end of the overlap interval.

  3. Add this overlap interval to list.

  4. Convert the list to array.
  */
  public static Interval[] intervalIntersection(Interval[] A, Interval [] B) {

    if(A == null || B == null || A.length == 0 || B.length == 0) {
      return new Interval [] {};
    }

    int i = 0; // index of A interval
    int j = 0; // index of B interval

    List<Interval> list = new ArrayList();

    while(i < A.length && j < B.length) {
      Interval a = A[i];
      Interval b = B[j];

      int maxStart = Math.max(a.start, b.start);
      int minEnd = Math.min(a.end, b.end);

      // Added Overlap interval
      if(maxStart <= minEnd) {
        Interval overlap = new Interval(maxStart, minEnd);
        list.add(overlap);
      }

      if(a.end == minEnd) {
        i++;
      }

      if(b.end == minEnd) {
        j++;
      }
    }
    return list.toArray(new Interval[list.size()]);
  }


  // Input: A = [[0,2],[5,10],[13,23],[2425]], B = [[1,5],[8,12],[15,24],[25,26]]
  // Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]


   public static void main(String args[])  {
    Interval a1 = new Interval(0, 2);
    Interval a2 = new Interval(5, 10);
    Interval a3 = new Interval(13, 23);
    Interval a4 = new Interval(24, 25);

    Interval a [] = {a1, a2, a3, a4};

    Interval b1 = new Interval(1, 5);
    Interval b2 = new Interval(8, 12);
    Interval b3 = new Interval(15, 24);
    Interval b4 = new Interval(25, 26);

    Interval b [] = {b1, b2, b3, b4};

    Interval x [] =intervalIntersection(a, b);
    System.out.println(x.length);
   // output : Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
  }
}



class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
}
