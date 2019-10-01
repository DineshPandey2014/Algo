package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
  public static void main (String args [])  {
  List<Integer> list = new ArrayList<>();
  list.add(1);
  list.add(2);
  list.add(2);
  int result = getMinimumUniqueSum(list);
  System.out.println(result);
  }

  public static int getMinimumUniqueSum(List<Integer> arr) {

    Collections.sort(arr);
    int sum = arr.get(0);
    int prev = arr.get(0);
    for(int i = 1; i < arr.size(); i++) {
      if(arr.get(i) == prev) {
        arr.set(i, arr.get(i) + 1);
        sum = sum + arr.get(i);
        prev = arr.get(i);
      } else {
        sum = sum + arr.get(i);
        prev = arr.get(i);
      }

    }
    return sum;
  }
}

