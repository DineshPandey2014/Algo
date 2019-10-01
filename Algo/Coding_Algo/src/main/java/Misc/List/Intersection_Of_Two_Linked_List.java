package Misc.List;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dpandey on 11/24/17.
 *
 *  https://www.youtube.com/watch?v=fHvCIZMKDLo
 *
 *  https://www.youtube.com/watch?v=gE0GopCq378
 *
 */
public class Intersection_Of_Two_Linked_List {


    /*
     * Time complexity is O(m + n)
     *
     *  Space COmplexity : O(n) Here we using the space for hash set.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<Integer> listData = new HashSet<>();

        if(headA == null || headB == null) {
            return null;
        }

        while (headA != null) {
            listData.add(headA.val);
            headA = headA.next;
        }

        while(headB != null) {
            if (listData.contains(headB.val)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }



    /*
    * Time Complexity :  O(m+n)
    * Space Complexity : O(1) . No extra space used
    *
    */
    public ListNode getIntersectionNode_Better_Space_COmplexity(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) {
            return null;
        }


        int lengthOfList_A = getListLength(headA);
        int lengthOfList_B = getListLength(headB);

        int diff = Math.abs(lengthOfList_A - lengthOfList_B);

        if(lengthOfList_A > lengthOfList_B) {
            headA = moveListHead(headA, diff);
        }

        if(lengthOfList_B > lengthOfList_A) {
            headB = moveListHead(headB, diff);
        }

        while(headA !=null && headB !=null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    ListNode moveListHead(ListNode listNode, int diff) {
        int i = 1;
        while(i <= diff) {
            listNode = listNode.next;
            i++;
        }
        return listNode;
    }

    int getListLength(ListNode list) {
        int counter = 0;
        while(list != null) {
            counter++;
            list = list.next;
        }
        return counter;
    }
}
