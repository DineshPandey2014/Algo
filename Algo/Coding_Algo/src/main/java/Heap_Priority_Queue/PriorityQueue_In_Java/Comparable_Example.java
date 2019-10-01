package Heap_Priority_Queue.PriorityQueue_In_Java;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparable_Example {

  public static void main(String args[]) {

    IntervalTimeEx intervalOne = new IntervalTimeEx(2,3);
    IntervalTimeEx intervalTwo = new IntervalTimeEx(4,5);
    IntervalTimeEx intervalThree = new IntervalTimeEx(1,2);
    IntervalTimeEx intervalFour = new IntervalTimeEx(6,7);

    List<IntervalTimeEx> list =  new ArrayList<>();
    list.add(intervalOne);
    list.add(intervalTwo);
    list.add(intervalThree);

    Collections.sort(list);

  }

}


class IntervalTimeEx implements Comparable<IntervalTimeEx> {
  int start;
  int end;
  public IntervalTimeEx(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public int compareTo(IntervalTimeEx obj1) {
    return this.start - obj1.start;
  }
}
