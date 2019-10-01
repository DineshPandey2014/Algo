package Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A queue is a collection of items all of the same type, Where items are
 * added to the tail of the queue and removed from the head of the queue.
 * Queues access stored data in a FIFO manner. A queue is also an abstract data type (AD)
 *
 * Queue us FIFO implementation :-
 *
 * LinkedList ---> Queue Interface ---> Collection interface.
 *
 * operation : enqueue
 *
 * Insert --> add() throws exception if couldn't add
 *        --> offer() Returns value true or false
 *
 * Remove ---> remove() throws exception
 *             poll() Returns head ot null
 *
 * Examine ---> element() throws exception
 *              peek() Returns head or null
 *
 *
 */
public class Queue_Java_Implementation {

  public static void main(String args[]) {
    Queue<Integer> queue = new LinkedList<Integer>();

    System.out.println(queue.peek()); // If there is no element it returns null
    // System.out.println(queue.element()); trows exception java.util.NoSuchElementException

    System.out.println();
    queue.offer(1);
    queue.add(2);
    queue.offer(3);
    queue.add(4);

    System.out.println(queue.peek());
    System.out.println(queue.element());

    System.out.println(queue);
    queue.remove();
    queue.poll();
    queue.remove();
    queue.poll(); // Removinf last element which is 4
    System.out.println(queue);
    System.out.println(queue.poll()); // Return null
    //System.out.println(queue.remove()); // Throws exception


    queue.offer(5);
    queue.add(6);
    queue.offer(7);
    queue.add(8);

    Iterator<Integer> iterator = queue.iterator();

    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println(queue);
  }


}
