package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree_Level_Order_Traversal {
  static Queue<TreeLevelOrder> queue = new LinkedList();

  /**
   *                  20
   *
   *           15              28
   *
   *      10       17       25      30
   *
   *
   *     Level order traversal --> 20, 15, 28, 10, 17, 25, 30
   *
   */

  public static void main(String args[]) {

    TreeLevelOrder root = new TreeLevelOrder(20);
    root.left = new TreeLevelOrder(15);
    root.right = new TreeLevelOrder(28);
    root.left.left = new TreeLevelOrder(10);
    root.left.right = new TreeLevelOrder(17);
    root.right.left = new TreeLevelOrder(25);
    root.right.right = new TreeLevelOrder(30);

    List<Integer> output = levelOrder(root);

    // Level order traversal 20, 15, 28, 10, 17, 25, 30
    for (Integer x: output) {
      System.out.print(x);
      System.out.print( " ");
    }
  }


  public static List<Integer> levelOrder(TreeLevelOrder root) {
    if(root == null) {
      return new LinkedList();
    }
    queue.add(root);
    List<Integer> list = new ArrayList();

    while(!queue.isEmpty()) {
      TreeLevelOrder node = queue.poll();
      list.add(node.val);
      if(node.left != null) {
        queue.add(node.left);
      }
      if(node.right != null) {
        queue.add(node.right);
      }
    }
      return list;
  }

}

class TreeLevelOrder {
  int val;
  TreeLevelOrder left;
  TreeLevelOrder right;

  public  TreeLevelOrder(int val) {
    this.val = val;
  }
}