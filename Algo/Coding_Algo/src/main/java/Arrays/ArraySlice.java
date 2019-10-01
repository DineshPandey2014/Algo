package Arrays;

import java.util.Arrays;

public class ArraySlice {

  public static void main (String args[]) {

    int x [] = {22,33,44,55,66,88};

    int y [] = Arrays.copyOfRange(x, 0, 3);

   for(Integer z : y) {
     System.out.println(z);
   }

  }
}
