package List;

import org.junit.Test;

/**
 * Created by dpandey on 12/20/17.
 */
public class RemoveElementsInTheList {
    //Example
    //Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
    //Return: 1 --> 2 --> 3 --> 4 --> 5


    @Test
    public void testRemoveElements() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        removeElements(listNode, 3);
    }

    public ListNode removeElements(ListNode head, int val) {
        //ListNode dummyNode = new ListNode(-1);
        //dummyNode.next = head;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }


     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

}
