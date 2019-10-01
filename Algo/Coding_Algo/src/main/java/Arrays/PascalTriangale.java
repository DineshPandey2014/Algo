package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangale {

  public static void main (String args[]) {

    List<Integer> list = getRow(0);
    System.out.println(list);
  }


  public static List<Integer> getRow(int rowIndex) {
    if(rowIndex == 0) {
      List<Integer> previous = new ArrayList();
      previous.add(1);
      return previous;

    }
    List<Integer> previous  = new ArrayList();
    if(rowIndex >= 1) {
      previous.add(1);
      previous.add(1);

    }

    if(rowIndex == 1) {
      return previous;
    }
    // 1, 1
    // 1,2,1
    // 1,3,3,1
    for (int i = 2; i <= rowIndex; i++) {
      List<Integer> next = new ArrayList();
      next.add(1);
      for(int j = 1; j < i;j++) {
        next.add(previous.get(j) + previous.get(j-1));
      }
      next.add(1);
      previous = next;
    }

    return previous;
  }

}
