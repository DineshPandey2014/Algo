package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Binary_Search_List_Java_Implementation {
  public static void main(String[] args)
  {
    List al = new ArrayList();
    al.add(1);
    al.add(2);
    al.add(3);
    al.add(10);
    al.add(20);

    // 10 is present at index 3.
    int index = Collections.binarySearch(al, 10);
    System.out.println(index);

    // 13 is not present. 13 would have been inserted
    // at position 4. So the function returns (-4-1)
    // which is -5.
    index = Collections.binarySearch(al, 21);
    System.out.println(index);
  }
}
