package List;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by dpandey on 11/15/17.
 *
 * https://www.youtube.com/watch?v=L7AXUSE3bTY
 *
 * https://www.youtube.com/watch?v=zLcNwcR6yO4
 *
 */
public class Merge_K_Sorted_List {
  // Merge K sorted list having
  // Keeping minimum hap size of K
  // N elements.
  // Time complexity --> There are K list each lisrt contains N elements.
  // Time Complexity --> .  N (K log k)
  //
  public ListNodeMSL mergeKLists(ListNodeMSL[] lists) {
    if(lists == null || lists.length == 0) {
      return null;
    }
    int size = lists.length; // Minimum heap size say k
    PriorityQueue<ListNodeMSL> heap = new PriorityQueue(size, new ListNodeComparator());

    for(int i = 0; i < size; i++) {
      // Holding the references of each node in the list
      if(lists[i] != null) {
        // Here we are adding the reference of the list which is pointing to first Node;
        heap.offer(lists[i]);
      }
    }

    ListNodeMSL dummy = new ListNodeMSL(-1);
    ListNodeMSL curr = dummy;

    while(!heap.isEmpty()) {
      ListNodeMSL n = heap.poll();
      curr.next = n;
      curr = n;
      if(n.next != null) {
        heap.offer(n.next);
      }
    }
    return dummy.next;
  }

  public class ListNodeComparator implements Comparator<ListNodeMSL> {
    @Override
    public int compare(ListNodeMSL o1, ListNodeMSL o2) {
      assert o1 != null && o2 != null;
      return o1.val - o2.val;
    }
  }
}

class ListNodeMSL {
      int val;
  ListNodeMSL next;
  ListNodeMSL(int x) { val = x; }
  }