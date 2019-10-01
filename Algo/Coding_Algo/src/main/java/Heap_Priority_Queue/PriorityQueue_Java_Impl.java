package Heap_Priority_Queue;

import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=1mm1I40cniQ
 *
 * Priority Queue : A priority queue is a collection of items
 * all of the same type. It enables efficent insertion of elements
 * and efficent removal of the minimum element. Removal is based on natural order or
 * by a Comparator. A priority queue is also an abstract data type.
 *
 *
 * add(E e) : boolean Inserts the specified elements into the priority queue
 * offer(E e) : Inserts the specified element into this priority queue.
 *
 * clear()  : void Removes all of the elements from the priority queue
 * contains(: boolean (Object) Returns true if the queue contains the specified element.
 *
 * peek() Reterives, but does not remove the head of thie queue or returns null if the queue is empty.
 *
 * poll() Reterives and removes the head of this queue or return null if this queue is empty.
 *
 * remove(Object o) Removes a single instances of the specified element from this queue., If it is not present.
 *                  Removes the element which is not necessairy having highest priority.
 *
 * size() : Returns the number of elements in this collection.
 *
 * int size() Returns the number of elements in this collecion.
 *
 *
 */
public class PriorityQueue_Java_Impl {

  public static void main (String [] args) {

    PriorityQueue<String> priorityQueue = new PriorityQueue<String> ();

    priorityQueue.add("B");
    priorityQueue.add("C");
    priorityQueue.add("F");
    priorityQueue.add("A");
    priorityQueue.add("L");
    priorityQueue.add("E");
    priorityQueue.add("J");

    //Stored as lexigraphically order
    System.out.println(priorityQueue); // Arranged as default min heap as BinaryTree

    System.out.println("Head : "+ priorityQueue.peek());
    System.out.println("Head : "+ priorityQueue.element());

    while(!priorityQueue.isEmpty()) {
      System.out.println(priorityQueue);
      System.out.println("Removed :" + priorityQueue.remove());
      System.out.println(priorityQueue);
    }

  }

}
