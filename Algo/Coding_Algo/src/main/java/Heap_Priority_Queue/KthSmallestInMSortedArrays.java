package Heap_Priority_Queue;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=6bvnZzwiKzs
 *
 */
class KthSmallestInMSortedArrays {

  public static int findKthSmallest(List<Integer[]> lists, int k) {
    PriorityQueue<Node> queue = new PriorityQueue<Node>();

    for(int i = 0; i < lists.size(); i++) {
      queue.add(new Node(i, 0, lists.get(i)[0])); // Added first element of each array index of i. First element
    }

    int count = 1;
    int element = -1;
    while(!queue.isEmpty()) {
      Node node  = queue.poll();
      if(count == k) {
        element = node.value;
        break;
      }
      count++;
      int nextIndex = node.elementIndex + 1;

      if (nextIndex < lists.get(node.arrayIndex).length) {
        queue.add(new Node (node.arrayIndex, nextIndex, lists.get(node.arrayIndex)[nextIndex]));
      }

    }
    return element;
  }

  public static void main(String[] args) {
    Integer[] l1 = new Integer[] { 2, 6, 8 };
    Integer[] l2 = new Integer[] { 3, 6, 7 };
    Integer[] l3 = new Integer[] { 1, 3, 4 };
    List<Integer[]> lists = new ArrayList<Integer[]>();
    lists.add(l1);
    lists.add(l2);
    lists.add(l3);
    int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
    System.out.print("Kth smallest number is: " + result);
  }
}

class Node implements Comparable <Node> {
  public int arrayIndex;
  public int elementIndex;
  public int value;
  public Node(int arrayIndex, int elementIndex, int value) {
    this.arrayIndex = arrayIndex;
    this.elementIndex = elementIndex;
    this.value = value;
  }

  @Override
  public int compareTo(Node node) {
    return this.value - node.value;
  }
}
