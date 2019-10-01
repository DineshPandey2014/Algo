package Tree.TestTree;

import java.util.LinkedList;
import java.util.Queue;

class BstSearchNode {
  BstSearchNode leftNode;
  BstSearchNode rightNode;
  int data;

  BstSearchNode (int data) {
    this.data = data;
  }
}
// Time complexity O(n) worst case

public class BinarySearchTreeUsingIterative {

  public BstSearchNode findElementIterative(BstSearchNode node, int val) {
    Queue<BstSearchNode> queue = new LinkedList();
    queue.add(node);

    while(!queue.isEmpty()) {
      BstSearchNode curr = queue.poll();

      if(curr.data == val) {
        return curr;
      }

      if( val < curr.leftNode.data ) {
        queue.add(curr.leftNode);
      }

      if(val > curr.rightNode.data) {
        queue.add(curr.rightNode);
      }

    }

     throw new IllegalArgumentException("not found");
  }
}
