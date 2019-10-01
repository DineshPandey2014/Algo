package List;

import org.junit.Test;

/**
 * Created by dpandey on 12/20/17.
 */
public class RemoveDuplicateSortedElementsInTheList {

    /*
     Given a sorted linked list, delete all duplicates such that each element appear only once.
    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.

     */

    @Test
    public void testDeleteDuplicate() {
        ListNode node  = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        ListNode nodeOne = deleteDuplicates(node);
        System.out.println(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr != null && curr.next !=null) {
            if(curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }


  public class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

}
