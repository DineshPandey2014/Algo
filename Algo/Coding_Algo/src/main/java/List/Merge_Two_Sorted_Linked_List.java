package List;

import java.util.List;

/**
 * Created by dpandey on 11/8/17.
 */
public class Merge_Two_Sorted_Linked_List {
    class ListNode {
        ListNode next;
        int data;
        ListNode(int data) {
            this.data = data;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        if(l1 == null && l2 == null) {
            throw new IllegalArgumentException("Both list are null");
        }
        ListNode head;
        if(l1.data < l2.data) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }


    public ListNode mergeTwoListsLeetCodeSolutionSolved(ListNode l1, ListNode l2) {

        ListNode p = l1;
        ListNode q = l2;
        // Dummy Node Having some dummy data.
        ListNode s = new ListNode(-1);

        // This will point to dummy node head.
        ListNode r = s;

        // In last will return r.next;

        while(p != null && q != null) {
            int valueP = p.data;
            int valueQ = q.data;

            if(valueP < valueQ) {
                s.next= p;
                p = p.next;
            } else {
                s.next = q;
                q = q.next;
            }
            s = s.next;
        }

        // Exactly one p or q is not null at this point. So we connext s.next to which is not null list
        s.next =  p == null ? q : p;
        return r.next;
    }
}
