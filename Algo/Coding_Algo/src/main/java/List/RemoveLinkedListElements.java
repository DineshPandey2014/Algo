package List;

import org.junit.Test;

/**
 * Created by dpandey on 12/20/17.
 */
public class RemoveLinkedListElements {

    @Test
    public void testRemoveElements() {
        //[1,6]
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
       /* node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);*/
        removeElements(node, 1);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode previous = null;
        ListNode start = head;
        previous = head;

        if(head.next == null && head.val == val) {
            head = null;
            return head;
        }

        if(head.next == null && head.val != val){
            return head;
        }


        while(head.next != null) {
            if(head.val == val) {
                previous.next = head.next;
                head = previous.next;

            } else {
                previous = head;
                head = head.next;
            }

        }

        if(head.next == null) {
            previous.next = null;
        }

        return start;
    }

}


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }