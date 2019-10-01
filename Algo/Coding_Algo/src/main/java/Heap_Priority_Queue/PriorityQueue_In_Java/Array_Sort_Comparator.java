package Heap_Priority_Queue.PriorityQueue_In_Java;

import java.util.Arrays;
import java.util.Comparator;

public class Array_Sort_Comparator {

  public static void main(String args[]) {

    IntervalTimeArraySort intervalOne = new IntervalTimeArraySort(2,3);
    IntervalTimeArraySort intervalTwo = new IntervalTimeArraySort(4,5);
    IntervalTimeArraySort intervalThree = new IntervalTimeArraySort(1,2);
    IntervalTimeArraySort intervalFour = new IntervalTimeArraySort(6,7);

    IntervalTimeArraySort [] intervalArray = new IntervalTimeArraySort[4];
    intervalArray[0] = intervalOne;
    intervalArray[1] = intervalTwo;
    intervalArray[2] = intervalThree;
    intervalArray[3] = intervalFour;

    Arrays.sort(intervalArray, new IntervalComparator());

  }
}


class IntervalTimeArraySort {
  int start;
  int end;

  public IntervalTimeArraySort(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

class IntervalComparator implements Comparator<IntervalTimeArraySort> {
  @Override
  public int compare(IntervalTimeArraySort obj1, IntervalTimeArraySort obj2) {
    return obj1.start -obj2.start;
  }
}