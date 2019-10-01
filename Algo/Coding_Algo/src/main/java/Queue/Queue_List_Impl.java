package Queue;

/**
 * Queue by list implementation.
 *
 *
 * Methods in Queue:

 add()- This method is used to add elements at the tail of queue. More specifically, at the last of
 linkedlist if it is used, or according to the priority in case of priority queue implementation.

 peek()- This method is used to view the head of queue without removing it. It returns Null if the queue is empty.

 element()- This method is similar to peek(). It throws NoSuchElementException when the queue is empty.

 remove()- This method removes and returns the head of the queue. It throws NoSuchElementException when the queue is
 impty.

 poll()- This method removes and returns the head of the queue. It returns null if the queue is empty.
 */
public class Queue_List_Impl {
 Node head;
 Node tail;

 public void add(int data) {
   Node node = new Node(data);
    if(head == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
 }

 // Removing the node from the front
  // Queue is FIFO first in first out.
  // 1,2,3,4,5 ---> Queue
  // 2,3,4,5   ---> After removing the node from queue.

 public int  remove() {
   int data = head.data;
   head = head.next;
   if(head == null) {
     tail = null;
   }
   return data;
 }

 public int peek() {
    return head.data;
 }

 public boolean isEmpty() {
   return head == null;
 }

}


class Node {
  Node next;
  int data;
  Node (int data) {
    this.data = data;
  }
}