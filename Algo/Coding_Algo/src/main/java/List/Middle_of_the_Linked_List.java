package List;

public class Middle_of_the_Linked_List {

  public static ListMiddleNode slow;
  public static ListMiddleNode fast;

  public static void main(String args[]) {
    // 1,2,3,4,5,6

    ListMiddleNode nodeOne = new ListMiddleNode(1);
    nodeOne.next = new ListMiddleNode(2);
    nodeOne.next.next = new ListMiddleNode(3);
    nodeOne.next.next.next = new ListMiddleNode(4);
    nodeOne.next.next.next.next = new ListMiddleNode(5);
    nodeOne.next.next.next.next.next = new ListMiddleNode(6);
    ListMiddleNode middle = middleNode(nodeOne);

   //System.out.println(middle.val); // 3 Odd number count;
    System.out.println(middle.val); // 4 even number count;

  }

  public static ListMiddleNode middleNode(ListMiddleNode head) {
    slow = head;
    fast = head;
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}

class ListMiddleNode {
  int val;
  ListMiddleNode next;
  ListMiddleNode(int x) {
    val = x; }
}
