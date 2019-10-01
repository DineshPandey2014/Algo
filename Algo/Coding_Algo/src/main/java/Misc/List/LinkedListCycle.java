package Misc.List;

import org.junit.Test;

/**
 * Created by dpandey on 11/2/17.
 */
public class LinkedListCycle {

    @Test
   public void tesLinkedList() {
        ListNode head;
        // [3, 2, 0, -4]
        head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
    }


     class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                   val = x;
                next = null;
            }
         }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;

        // If the list is empty or Head is null means one element [1]
        if(head == null || head.next == null) {
            return false;
        }
        // List of one elements [1] if there is one element and tail is pointing to itself. There is cycle.
        if(head.next !=null && head.next == head) {
            return true;
        }

        //  If the list is having two elements [2,3] and second element is pointing to first elemenet means tail is pointing to
        //     head it means there is cycle.
        if(head.next.next != null && head.next.next == head) {
            return true;
        } else if(head.next.next == null) {
            return false;
        }

        ListNode fast = head.next.next;
        while(slow.next != null) {
            if (slow == fast) {
                return true;
            } else {
                slow = slow.next;
                if(fast.next !=null && fast.next.next != null) {
                    fast = fast.next.next;
                } else {
                    // If ther is no cycle [2,4,3,2] and there is no fast.next.next
                    return false;
                }
            }
        }
        return false;
    }
}
