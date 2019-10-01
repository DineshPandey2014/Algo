package Heap_Priority_Queue;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class
Kth_Largest_Element_IN_Array {

  public static void main(String args[]) {

    int nums []  = { 3,2,1,5,6,4};
    int k =2;
    // Answer 5
    System.out.println(findKthLargest(nums, k));
  }

  /*
     Algorithm:
     1. At any point of time we will keep K elements in the Priority Queue.
     2. Then we will if the incoming elements is greater then the top elements of Priority Queue
     3. Pop the top from the priority queue.
     4. Add the incoming elemnents to the queue.
     5. Keep doing this and iterate the array.
     6. At last we will have only two elements in the PriorityQueue. Which is min heap.
     7. Last we will get the kth element at the top in the priority queue.
    */
  public static int findKthLargest(int[] nums, int k) {
    // Default Priority Queue implementation

    PriorityQueue<Integer> pq = new PriorityQueue();

    for (int i = 0; i < nums.length; i++) {
      if(pq.size() < k) {
        // Add only kelements to queue
        pq.add(nums[i]);
      } else {
        // Check if coming elements is greater then the top elements of PriorityQueue. Peek the elements of PQ
        if(pq.peek() < nums[i]) {
          pq.poll();
          pq.add(nums[i]);
        }
      }
    }
    // Kth largest element in Min Heap will be top elements
    return pq.peek();
  }

  @Test
  public void testToFindKthLargestElement_Using_Max_Heap() {
      int [] input = {3,2,1,5,6,4};
      int k =2;
     int maxElement =  findKthLargestElementUsing_Max_Heap_PriorityQueue(input, k);
     System.out.println(maxElement);
  }
  /**
   * Using Max Heap as Priority Queue
   *
   */
  public int findKthLargestElementUsing_Max_Heap_PriorityQueue(int[] nums, int k) {
    PriorityQueue<Integer> pQueue = new PriorityQueue(Collections.reverseOrder());
    for(int i = 0; i < nums.length; i++) {
      pQueue.add(nums[i]);
    }

    int count = 1;
    while(!pQueue.isEmpty()) {
      int x = pQueue.poll();
      if(count == k) {
        return x;
      }
      count ++;
    }
    return Integer.MAX_VALUE;
  }


}
