package List;

import org.junit.Test;

class NodeList {
  int val;
  NodeList next;
  NodeList(int x) { val = x; }
}

public class Remove_Nth_Node_From_End_of_List {

   @Test
   public void testGraphRemovalNodeFromBack() {
     NodeList node = new NodeList(10);
     removeNthFromEndOnePAss(node, 1);
   }

  /**
   * One pass solution using two pointer.
   * Slow Pointer and Fast Pointer.
   *
   * We need to move fast pointer by n+1 index in the list
   */

  public NodeList removeNthFromEndOnePAss(NodeList head, int n) {
    NodeList dummy = new NodeList(0);
    dummy.next =head;
    // Corner case when we have to remove the first node
    if(head == null) {
      return null;
    }

    NodeList slow = dummy;
    NodeList fast = dummy;

    // Move fast pointer to n+1 index in list.
    // Advances first pointer so that gap between first and second is n nodes apart.
    for (int i = 1; i <= n+1;i++) {
      fast = fast.next;
    }

    // Move first to the end maintaining the gap
    while(fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;

    return dummy.next;

  }

  /**
   *  This is two pass solution
   *
   *  To handle the corner case where we have only once node in the list and head is pointing to the
   *  list. We want to delete this node. In this case if we do
   *
   *  head.next = head.next.next // It will throw null pointer exception.
   *
   *  To handle this case, Take dummy node of the list initalize with any element.
   *
   *  NodeList dummyNode = new NodeList(0);
   *  // list.next will point to head
   *  currHead.next = currHead.next.next; // which is head.next.next assign null
   *
   *  And then return
   *
   *  dummy.next;
   *
   *  Now to delete we will do
   *  dummyNode.next =
   *
   * @param head
   * @param n
   * @return
   */
  public NodeList removeNthFromEnd(NodeList head, int n) {
    NodeList dummy = new NodeList(0);
    dummy.next = head;

    if(head == null) {
      return head;
    }

    int countTotalNodes = 0;
    NodeList curr = head;

    while(curr != null) {
      countTotalNodes++;
      curr = curr.next;
    }

    int previousNodePostion = countTotalNodes - n;
    NodeList currHead = dummy;

    while (previousNodePostion > 0) {
      previousNodePostion --;
      currHead = currHead.next;
    }
    currHead.next =currHead.next.next;
    return dummy.next;

  }
}
