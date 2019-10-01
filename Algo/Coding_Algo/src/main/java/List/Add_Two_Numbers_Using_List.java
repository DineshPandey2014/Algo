package List;

import java.util.List;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * Created by dpandey on 11/7/17.
 */
public class Add_Two_Numbers_Using_List {
    /*
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);

        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0;

        while(p!=null || q!=null) {
            // Might be the case if p reached to null but q is not reached to null. In that
            // case we need to put the value as 0
         int x = (p != null) ? p.data :0;
         int y = (q != null) ? p.data : 0;
         int sum = carry + x + y; // Example max digit is 9 + 9 = 18 --- >    Write 8 and carry 1
         carry = sum/10;
         curr.next = new ListNode(sum%10);
         curr = curr.next;
         if(p!=null) {
             p = p.next;
         }
            if(q!=null) {
                q = q.next;
            }

        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    class  ListNode  {
        ListNode next;
        int data;
        ListNode(int data) {
            this.data = data;
        }
    }
}
