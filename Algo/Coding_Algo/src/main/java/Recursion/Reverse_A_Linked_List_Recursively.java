package Recursion;

import org.junit.Test;

/**
 * # Recursive linked list.
 * https://www.youtube.com/watch?v=KYH83T4q6Vs
 */
public class Reverse_A_Linked_List_Recursively {

  ListNode head;
  ListNode tail;

  @Test
  public void testReverseLinkedList() {
    ListNode listNodeOne = new ListNode(3);
    insert(listNodeOne);

    ListNode listNodeTwo = new ListNode(2);
    insert(listNodeTwo);

    ListNode listNodeThree = new ListNode(1);
    insert(listNodeThree);
    //list.next = new ListNode(2);
    //list.next.next = new ListNode(1);

    ListNode node = reverseLinkedList_Iterative_Approach(head);
  }

  public  ListNode reverseLinkedList_Iterative_Approach(ListNode head) {
    ListNode current = head;
    ListNode prev = null;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  /*
  public  ListNode reverseLinkedList_Recursive_Approach(ListNode head) {

  }*/

  public void insert(ListNode node) {
    if(head == null || tail == null) {
      head = node;
      tail = node;
    }
    tail.next = node;
    tail = node;
  }

}

class ListNode {
  ListNode next;
  int data;
  ListNode (int data) {
    this.data = data;
  }

}