package DeQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Maximum_In_Sliding_Window_Using_Dequeue {

  public static void main(String args[]) {

    int x [] = {10, 2,4, 4,5,6,8,19,4,5}; // {10,2,4}, (2,4,4), (4,4,5), (4,5,6), (5,6,8) (6,8,19), (19,4,5)

                                      // Max in group of 3 --> 10,4,4,6,8,19,19
    int k = 3;
   int y [] =  max_in_sliding_window(x, 3);
  }

  static int[] max_in_sliding_window(int[] a, int k) {
    if (a == null || k <= 0) {
      return new int[0];
    }

    int n = a.length;

    // Total number of elements in the sliding window of index one starting window size is K
    // Lengtho of given array - K (Size of window) + 1
    // Stores maximum array value
    int[] indexesArray = new int[n-k+1];
    int counter = 0;

    //Store index
    Deque<Integer> q = new ArrayDeque<>();

    for (int i = 0; i < a.length; i++) {

      // peek()
      //Retrieves, but does not remove, the head of the queue represented by this deque, or returns null

      // if this deque is empty remove numbers out of range k
      // Check if index in the dequeue is less then
      while (!q.isEmpty() && q.peek() < i - k + 1) {
        q.poll();
      }

      //Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.

      // remove smaller numbers in k range as they are useless
      while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
        //Retrieves and removes the last element of this deque, or returns null if this deque is empty.
        q.pollLast();
      }

      //Inserts the specified element into the queue represented by this deque (in other words, at the tail of this
      // deque) if it is possible to do so immediately without violating capacity restrictions, returning true
      // upon success and false if no space is currently available.

      // q contains index... r contains content
      q.offer(i);
      if (i >= k - 1) {
          indexesArray[counter++] = a[q.peek()];
      }
    }
    return indexesArray;
  }
}
