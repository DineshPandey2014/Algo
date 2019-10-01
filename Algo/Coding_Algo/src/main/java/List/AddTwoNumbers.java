package List;

class ListNodeNumbers {
       int val;
  ListNodeNumbers next;
  ListNodeNumbers(int x) { val = x; }
 }

public class AddTwoNumbers {

  public static void main(String args[]) {
    AddTwoNumbers listAddition = new AddTwoNumbers();
    // [1, 8]
    // [0]

   ListNode nodeOne = new ListNode(5);
    nodeOne.next = new ListNode(8);
    ListNode nodeTwo = new ListNode(5);
    listAddition.addTwoNumbers(nodeOne, nodeTwo);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode tail = null;
    int sum = 0;

    while(l1 != null || l2 != null || sum !=0) {
      if(l1 != null) {
        sum = sum + l1.val;
        l1 = l1.next;
      }

      if(l2 != null) {
        sum = sum + l2.val;
        l2 = l2.next;
      }

      if(head == null) {
        head = new ListNode(sum%10);
        tail = head;
      } else {
        ListNode node = new ListNode(sum%10);;
        tail.next = node;
        tail = node;
      }
      sum = sum/10;
    }
    return head;
  }
}
