package Arrays;

/*

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to
default code definition to get new method signature.
*/

import org.junit.Test;

import java.util.*;

public class Merge_Interval {

  @Test

  public void testIntervalMerge() {
    int  [] [] x = {{1,4},{0,2},{3,5}};
    //int  [] [] x = {{1,4},{5,16}};

    int  output [] [] = merge(x);

    for(int i = 0; i < output.length; i++) {
      int[] y  = output[i];
      System.out.println(y[0]);
      System.out.println(y[1]);

    }


  }

  public int[][] merge(int[][] intervals) {

    if(intervals == null || intervals.length == 1 ||intervals.length == 0 ) {
      return intervals;
    }

        /* Corner cases

        1. When we have same intervals multiple times.
        ex => [1,2] [1,2] [1,2] => After merging two intervals we need to keep a single intervals
        // Here we will use Set<Intervals> which will contains unique intervals.

        */

    Interval intervalsInput [] = new Interval[intervals.length];

    for (int i = 0; i <intervals.length; i++) {
      Interval intervalsTemp = new Interval (intervals[i][0], intervals[i][1]);
      intervalsInput[i] = intervalsTemp;
    }

    // Sort the intervals
    Arrays.sort(intervalsInput);

    Interval startInterval = intervalsInput[0];

    // Taking the set to store the unique object of Interval
    Set<Interval> result = new HashSet<>();

    for (int i = 1; i < intervalsInput.length; i++) {
      Interval interval = intervalsInput[i];


      if(startInterval.end >=interval.start) {
        //As we are merging the previous interval which is here startInterval. So first remove that
        // from set and then add merge interval to Set.
        result.remove(startInterval);

        // Here we will Create the merge interval.
        // start will be the of startInterval which is minimum
        // End will be the max of two interval
        Interval mergeInterval = new Interval(startInterval.start, Math.max(startInterval.end, interval.end));
        // Here we assign mergeInterval to startInterval
        startInterval = mergeInterval;
        // Add the mergeInterval to result.
        result.add(mergeInterval);
      } else {
        // When there is no overlapping.
        // We need to add both interval start interval and interval
        if(!result.contains(startInterval)) {
          result.add(startInterval);
        }
        // We need to add both interval  interval
        if(!result.contains(interval)) {
          result.add(interval);
        }
        // Again we need to assign interval to startInterval for futherCOmparison
        startInterval = interval;
      }

    }

    int [] [] returnResult = new int [result.size()][2];

    int count = 0;

    for (Interval mergeInterval : result) {
      returnResult[count][0] = mergeInterval.start;
      returnResult[count][1] = mergeInterval.end;
      count++;
    }

    return returnResult;
  }

  static  class Interval implements Comparable<Interval> {
    int start;
    int end;
    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Interval intervalOne) {
      return this.start - intervalOne.start;
    }
  }

}
