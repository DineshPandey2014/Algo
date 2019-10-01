package Tree;

import org.junit.Test;

public class Maximum_Path_Sum_Tree {
  int result = Integer.MIN_VALUE;

  @Test
  public void maxPathSum() {
    NodeMaxBST root = new NodeMaxBST(-7);
    root.left = new NodeMaxBST(-5);
    root.right = new NodeMaxBST(-4);

    findMax(root);
    System.out.println("---->> "+ result);
  }

  public int findMax(NodeMaxBST root) {
    if(root == null) {
      return 0;
    }

    int leftMax = findMax(root.left);
    int rightMax = findMax(root.right);

    // From a sub tree we will return node + left or node + right which ever is maximum to upper tree.
    int maxSingle = Math.max(leftMax, rightMax) +  root.val;
    int maxAll = Math.max(maxSingle, leftMax + rightMax + root.val );

    // Hold the max result
    result = Math.max(result, maxAll);

    // What ever we return to above node we will return positive number. If it is negative will return 0
    return maxSingle > 0 ? maxSingle : 0;
  }
}

class NodeMaxBST {
  NodeMaxBST left;
  NodeMaxBST right;
  int val;

  NodeMaxBST(int val) {
    this.val = val;
  }
}