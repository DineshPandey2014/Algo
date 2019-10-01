package Arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/meeting-rooms/
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * Example 1:

 Input: [[0,30],[5,10],[15,20]]
 Output: false
 Example 2:

 Input: [[7,10],[2,4]]
 Output: true
 */
public class MeetingRoom_One {

  @Test
  public void testCanAttendMeeting() {
    IntervalMeetingOne [] interval = {new IntervalMeetingOne(1,10), new IntervalMeetingOne(2,4)};
    boolean result = canAttendMeeting(interval);
    System.out.println(result);
  }

  public boolean canAttendMeeting(IntervalMeetingOne[] intervals) {
    Arrays.sort(intervals, new IntervalMeetingOne());

    for (int i = 1; i <intervals.length; i++ ) {
        if(intervals[i].start < intervals[i-1].end) {
          return false;
        }
    }
    return true;
  }

}

class IntervalMeetingOne implements Comparator<IntervalMeetingOne> {
  int start;
  int end;

  IntervalMeetingOne() {
    this.start = start;
    this.end = end;
  }

  IntervalMeetingOne(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public int compare(IntervalMeetingOne one, IntervalMeetingOne two) {
    return one.start - two.start;
  }
}
