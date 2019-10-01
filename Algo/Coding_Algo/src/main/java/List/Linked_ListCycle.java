package List;

/**
 * https://www.youtube.com/watch?v=-YiQZi3mLq0&t=26s
 */
public class Linked_ListCycle {

  public boolean hasCycle(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next !=null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }

    return false;

  }

}
