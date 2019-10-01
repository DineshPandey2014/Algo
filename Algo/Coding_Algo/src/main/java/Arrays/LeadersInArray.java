package Arrays;

import org.junit.Test;

import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/tracks/PC-W2-A/?batchId=131#collapse1
 *
 * Use Stack to print of elements in the array from left to right.
 *
 * O(n) time complexity best case
 * O(n2) time complexity worst case
 *
 * Approach. Run a loop from left side.
 * Hold max value last value as max in the variable
 *
 *
 */
public class LeadersInArray {


  @Test
  public void testArrayInput() {
    //int x[] = {5,3,20,15,18,8,3};
    int x[] = {5,3,20,15,18,25,3};
    Stack<Integer> stack = printLeaderInTheArray(x);

    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }

  }

  public Stack printLeaderInTheArray(int x[]) {
    // Leaders are those numbers whose left side numbers are smaller
    // 8 --->3
    // 18 --> 8
   // int x[] = {5,3,20,15,18,8,3};

    Stack<Integer> stack = new Stack();

    int max = x[x.length-1];
    stack.push(max);

    for (int i = x.length-2; i >= 0; i--) {
      if(x[i] > max) {
        stack.push(x[i]);
        max = x[i];
      } else {
        break;
      }
    }
    return stack;
  }

}
