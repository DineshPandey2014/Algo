package Graph;


import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.youtube.com/watch?v=RgrCL-wU110&t=109s
 *
 */
public class Decode_Ways_DFS_Solution {

  @Test
  public void testDecodeIntegerString() {
    int count = numDecoding("22");
    System.out.println(count);
  }

  public int numDecoding (String s) {

    if(s == null || s.length() == 0) {
      return 0;
    }
    return bfsDecode(s);
  }


  /**
   * Time limit exceeded because of recursion.
   * @param s
   * @param pos
   * @return
   */
  private int dfsDecode (String s, int pos) {
    // Example if the number is 102 By taking onge digit ---> 1--->0 Now we have no mapping for zero. So we return as
    // So for 102 we have only one solution of two digits 102---> 10 >>>2 --> [] ---> (J, B)

    if(pos < s.length() && s.charAt(pos) == '0') {
        return 0;
    }

    // 10 --> 2 --->[] this is one of the way count as 1
    if(pos == s.length()) {
      return 1;
    }

    // If we have not reach end we have two option
    // Moved by one digit
    int nWayOneDigit = dfsDecode(s, pos + 1);

    int val = 0;

    if(pos + 1 < s.length()) {
      val = Integer.parseInt(s.substring(pos, pos+2));
    }
    int nWayTwoDigit = 0;

    if(val >=10 && val <=26) {
      nWayTwoDigit = dfsDecode(s, pos + 2);
    }

    return nWayOneDigit + nWayTwoDigit;
  }

  private int bfsDecode (String s) {
      int nWays = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    while(!queue.isEmpty()) {
      int pos = queue.poll();
      if(pos == s.length()) {
        nWays++;
        continue;
      }

      if(s.charAt(pos) == '0') {
        continue;
      }
      queue.offer(pos+1);
      int val = 0;
      if(pos+1 < s.length()) {
        val = Integer.parseInt(s.substring(pos, pos+2));
      }

      if(val >=10 && val <=26) {
        queue.offer(pos+2);
      }


    }

    return nWays;
  }

 @Test
 public void sumOfTwoNumber () {
    int [] input = {};
   boolean isSum = sum(input, 17);
   System.out.println(isSum);
  }


  public boolean sum(int input[], int target) {
      if(input == null || input.length == 0) {
        return false;
      }
    Arrays.sort(input);

    int leftPointer = 0;
    int rightPointer = input.length-1;

    while(leftPointer < rightPointer) {
      int temp = input[leftPointer] + input[rightPointer];

      if(temp == target) {
        return true;
      } else if(temp < target) {
        leftPointer++;
      } else {
        rightPointer--;
      }

    }
    return false;

  }
}
