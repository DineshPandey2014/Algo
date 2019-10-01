package Heap_Priority_Queue.PriorityQueue_In_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_Example {
  public static void main(String args[]) {
    TimeIntervalOne intervalOne = new TimeIntervalOne(2, 3);
    TimeIntervalOne intervalTwo = new TimeIntervalOne(4, 5);
    TimeIntervalOne intervalThree = new TimeIntervalOne(1, 2);
    TimeIntervalOne intervalFour = new TimeIntervalOne(6, 7);

    List<TimeIntervalOne> list = new ArrayList<>();
    list.add(intervalOne);
    list.add(intervalTwo);
    list.add(intervalThree);
    list.add(intervalFour);

    Collections.sort(list, new IntervalTimeComparator());
  }


  static class TimeIntervalOne {
    int start;
    int end;

    public TimeIntervalOne(int start, int end) {
      this.start = start;
      this.end = end;

    }
  }

  static class IntervalTimeComparator implements Comparator<TimeIntervalOne> {
    @Override
    public int compare(TimeIntervalOne obj1, TimeIntervalOne obj2) {
      return obj1.start - obj2.start;
    }
  }


}

