package Recursion;

import org.junit.Test;

public class PrintLinkedListElement_InForward_And_Reverse_Order {

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
   // Reverse order
    print_In_Reverse_Order_Using_Recursion(head);
    // Forward order
    print_In_Forward_Order_Using_Recursion(head);
  }

  // Input 3,2,1
  public void print_In_Forward_Order_Using_Recursion(ListNode currentPointer) {
    if(currentPointer == null) {
      return;
    }
    //Output 3,2,1
    System.out.println(currentPointer.data);
    print_In_Reverse_Order_Using_Recursion(currentPointer.next);

  }


  // Input 3,2,1
  public void print_In_Reverse_Order_Using_Recursion(ListNode currentPointer) {
    if(currentPointer == null) {
      return;
    }
    print_In_Reverse_Order_Using_Recursion(currentPointer.next);
    //Output 1,2,3
    System.out.println(currentPointer.data);
  }

  public void insert(ListNode node) {
    if(head == null || tail == null) {
      head = node;
      tail = node;
    }
    tail.next = node;
    tail = node;
  }

}

class ListNodePrint {
  ListNodePrint next;
  int data;
  ListNodePrint (int data) {
    this.data = data;
  }
}
