package Cache;

/**
 * Doubly Linked List
 * https://leetcode.com/problems/lfu-cache/discuss/192961/Java-O(1)%3A-DoubleLinkedList-%2B-HashMap
 * <p>
 * https://leetcode.com/problems/lfu-cache/discuss/192865/My-O(1)-Solution-with-2-HashMap-and-DoubleLinkedList
 * <p>
 * # Good video explains how doubly linked code works in Java.
 * https://www.youtube.com/watch?v=jircscEJnWI
 */

 class Node {
  Node previous;
  Node next;
  int data;

  Node(int data) {
    this.data = data;
    this.previous = null;
    this.next = null;
  }
}

public class DoublyLinkedList {
  private Node head;
  private Node tail;
  private int length;

  public void insertingBefore(int data) {
    Node node = new Node(data);

    if (tail == null) {
       tail = node;
    } else {
     head.previous = node;
    }
    node.previous = head;
    head = node;
    length++;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public void displayForward() {

  }

  public void displayForwar() {
    if(head == null) {
        return;
    }

    Node temp = head;
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

 public static void main (String args[]) {
   DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
   doublyLinkedList.insertingBefore(4);
   doublyLinkedList.insertingBefore(5);
 }

}
