package DataStructure;

/**
 * Doubly Linked List
 * https://leetcode.com/problems/lfu-cache/discuss/192961/Java-O(1)%3A-DoubleLinkedList-%2B-HashMap
 * <p>
 * https://leetcode.com/problems/lfu-cache/discuss/192865/My-O(1)-Solution-with-2-HashMap-and-DoubleLinkedList
 * <p>
 * # Good video explains how doubly linked code works in Java.
 * https://www.youtube.com/watch?v=jircscEJnWI
 *
 * Operation
 * 1) InsertFirst
 * 2) InsertEnd
 * 3) insertBefore
 * 4) insertEnd
 * 5) remove()
 */

class Node {
  public Node prev;
  public Node next;
  public int data;

  public Node(int data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }
}

public class DoublyLinkedList {
    private Node tail;
    private Node head;
    int length;

  /**
   *  Add node at the begnining of doubly linked list;
   * @param data
   */
  public void insertFirst(int data) {
    Node node = new Node(data);
    if(isEmpty()) {
      tail = node;
    } else {
      head.prev = node;
    }
    node.next = head;
    head = node;
  }

  /**
   *  Add node at the begnining of doubly linked list;
   * @param data
   */
  public void insertLast(int data) {
    Node node = new Node(data);

    if(isEmpty()) {
      head = node;
    } else {
      tail.next = node.prev;
      node.prev = tail;
    }
    tail = node;
  }


  /**
   * Travering head to tail.
   */
  public void displayForward() {
    if(head == null) {
      return;
    }
    Node temp = head;
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }


  /**
   * Travering tail to head.
   */
  public void displayBackward() {
    if(tail == null) {
      return;
    }
    Node temp = tail;
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.prev;
    }
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public static void main(String args[]) {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.insertFirst(2);
    doublyLinkedList.insertFirst(3);
    doublyLinkedList.insertFirst(4);
    doublyLinkedList.displayForward();
    doublyLinkedList.displayBackward();
  }
}
