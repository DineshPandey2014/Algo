package Misc.List;

import org.junit.Test;

/**
 * Created by dpandey on 11/2/17.
 *
 * #Iterative approach for revwrse linked list.
 * https://www.youtube.com/watch?v=sYcOK51hl-A
 */
public class ReverseOfLinkedList_Iterative {


    @Test
    public void testReverseLinkedList() {
        ListNode head;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode node = reverseList(head);
    }
      // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode current = head; // s1 = head
        ListNode previous = null;
        ListNode next = null;     // s2

        while(current !=null) {
            next = current.next;  // s2 = s3
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
