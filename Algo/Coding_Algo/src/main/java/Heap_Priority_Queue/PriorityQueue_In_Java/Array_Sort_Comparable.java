package Heap_Priority_Queue.PriorityQueue_In_Java;

import java.util.Arrays;

public class Array_Sort_Comparable {

  public static void main(String args[]) {
    IntervalTimeExample intervalOne = new IntervalTimeExample(2,3);
    IntervalTimeExample intervalTwo = new IntervalTimeExample(4,5);
    IntervalTimeExample intervalThree = new IntervalTimeExample(1,2);
    IntervalTimeExample intervalFour = new IntervalTimeExample(6,7);

    IntervalTimeExample [] intervalArray = new IntervalTimeExample[4];
    intervalArray[0] = intervalOne;
    intervalArray[1] = intervalTwo;
    intervalArray[2] = intervalThree;
    intervalArray[3] = intervalFour;

    Arrays.sort(intervalArray);

  }
}


class IntervalTimeExample implements Comparable<IntervalTimeExample> {
  int start;
  int end;

  public IntervalTimeExample(int start, int end) {
    this.start = start;
    this.end = end;

  }

  @Override
  public int compareTo(IntervalTimeExample object) {
    return this.start - object.start;
  }
}