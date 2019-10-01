package List;

import org.junit.Test;

import java.util.HashSet;

/**
 * Created by dpandey on 12/20/17.
 */

/*
 * Given an unsorted linked list, write a function to remove all the duplicates.
 *
 * e.g --> dedup(1 --> 2 --> 3 -->2--->1) = 1 -->2-->3
 *
 */
public class Remove_Duplicate_Unsorted_List {

    @Test
    public void  testDeDupe() {
        LinkedList list = new LinkedList(1);
        list.next = new LinkedList(2);
        list.next.next = new LinkedList(3);
        list.next.next.next = new LinkedList(2);
        list.next.next.next.next = new LinkedList(1);

        LinkedList node = deDupe(list);
    }

    public LinkedList deDupe(LinkedList head) {
        HashSet<Integer> hasSet = new HashSet<Integer>();
        LinkedList curr = head;
        LinkedList previous = null;
        while (curr != null) {
            if(hasSet.contains(curr.val)) {
               previous.next = curr.next;
            } else {
                hasSet.add(curr.val);
                previous = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}

class LinkedList {
    public int val;
    public LinkedList next;
    LinkedList(int x) {
        val = x;
    }
}