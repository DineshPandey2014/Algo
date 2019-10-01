package Arrays;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Interval;

import java.util.*;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * Given an array of meeting time intervals consisting of start
 * and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

 Example 1:

 Input: [[0, 30],[5, 10],[15, 20]]
 Output: 2
 Example 2:

 Input: [[7,10],[2,4]]
 Output: 1

 # Explaination
 https://www.youtube.com/watch?v=118Ie3nPCdc&t=317s

 # Explaination
 https://www.youtube.com/watch?v=118Ie3nPCdc&t=317s
 */
public class MeetingRoom_Two {

  public int minMeetingRooms(IntervalMeeting[] intervals) {
    if(intervals == null || intervals.length == 0) {
      return 0;
    }
    // Sort the array based on start time.
    Arrays.sort(intervals, new MeetingRoomComparator());

    // Take the Priority Queue to hold the end time of the meetings.
    // This will tell you the number rooms needed
    // Here it will give the next room available. After the end time
    PriorityQueue<Integer> pq = new PriorityQueue();
    // Need one room initally
    pq.add(intervals[0].end);

    // Iterate all the interval from index 1 to length-1 of the interval
    for (int i = 1; i <intervals.length; i++) {
      // If in coming meeting start time is greater then last minimum end time. It  means
      // We can use the same room.And then we are merging the interval means update the end time
      // of this room and add to Priority Queue
      if(intervals[i].start >=pq.peek()) {
        pq.poll();
      }
      pq.add(intervals[i].end);

    }
    return pq.size();
  }
}

// Sort all the meetings based on start time
class MeetingRoomComparator implements Comparator<IntervalMeeting> {
  @Override
  // Sorting is based on start time. So we take a difference between start time.
  public int compare(IntervalMeeting objectOne, IntervalMeeting ObjectTwo) {
    return objectOne.start - ObjectTwo.start;
  }
}



 class IntervalMeeting {
     int start;
     int end;
   IntervalMeeting() { start = 0; end = 0; }
   IntervalMeeting(int s, int e) { start = s; end = e; }
  }
