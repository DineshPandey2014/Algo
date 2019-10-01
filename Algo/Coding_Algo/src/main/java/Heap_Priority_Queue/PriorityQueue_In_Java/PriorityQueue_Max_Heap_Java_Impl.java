package Heap_Priority_Queue.PriorityQueue_In_Java;

import java.util.Collections;
import java.util.PriorityQueue;

// Java program to demonstrate working of PriorityQueue
// as a Max Heap
public class PriorityQueue_Max_Heap_Java_Impl {
  public static void main(String args[]) {
    /**
     * Default implementation of Priority queue is Min Heap
     *
     * To implement Max Heap for Priority Queue is
     */

    // Creating empty priority queue
    PriorityQueue<Integer> pQueueMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // Adding items to the pQueue using add()
    pQueueMaxHeap.add(10);
    pQueueMaxHeap.add(30);
    pQueueMaxHeap.add(20);
    pQueueMaxHeap.add(400);

    while(!pQueueMaxHeap.isEmpty()) {
      System.out.println(pQueueMaxHeap.poll());
    }

    System.out.println();
    System.out.println();
    System.out.println();

    /**
     * Default implementation of Priority queue is Min Heap
     *
     * To implement Min Heap for Priority Queue is
     */

    // Creating empty priority queue
    PriorityQueue<Integer> pQueueMinHeap = new PriorityQueue<>();
    // Adding items to the pQueue using add()
    pQueueMinHeap.add(10);
    pQueueMinHeap.add(30);
    pQueueMinHeap.add(20);
    pQueueMinHeap.add(400);

    while(!pQueueMinHeap.isEmpty()) {
      System.out.println(pQueueMinHeap.poll());
    }
  }


}
