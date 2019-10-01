package Tree;

import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
 *
 * https://leetcode.com/problems/path-sum/submissions/
 */
public class Path_Sum_In_Binary_Tree {


  boolean hasPathToSum(TreeNode root, int sum) {
    if(root == null) {
      return false;
    }
    // This is imporatnt here that we need to subtract the sum from the root value.
    // There can be coner case where sum - root.val = 0, When there is only one node.

    sum = sum - root.val;

    // To have a path in the tree it's important that node left child and right child should be null
    // And then we should compare sum with 0.
    if(root.left == null && root.right == null) {
      return sum == 0;
    }

    return hasPathToSum(root.left, sum) || hasPathToSum(root.right, sum);
  }

  /**
   *                  1
   *
   *           2             3
   *
   *             5       6      7
   *
   */
    @Test
    public void testTreeORder() {
      Tree_Path tree = new Tree_Path(1);
    tree.leftNode = new Tree_Path(2);
    tree.rightNode = new Tree_Path(3);

    tree.leftNode.rightNode = new Tree_Path(5);

    tree.rightNode.leftNode = new Tree_Path(6);
    tree.rightNode.rightNode = new Tree_Path(7);

    String str = String.valueOf(tree.val) + " "; //String.valueOf(tree.data);
      Stack<Integer> stack = new Stack<>();

     hasPath_And_Print_Path(tree, 10, stack);

     while(!stack.isEmpty()) {
       System.out.println(stack.pop());
     }
  }

  // To find the path for which we have the sum
  boolean hasPath_And_Print_Path(Tree_Path root, int sum, Stack<Integer> stack) {
    if(root == null) {
      return false;
    }
    sum = sum - root.val;

    if(root.leftNode == null && root.rightNode == null) {
      if(sum == 0) {
        stack.add(root.val);
        return true;
      } else {
        return false;
      }
    }

    if(hasPath_And_Print_Path(root.leftNode, sum, stack)) {
      stack.add(root.val);
      return true;
    }

    if(hasPath_And_Print_Path(root.rightNode, sum, stack)) {
      stack.add(root.val);
      return true;
    }
    return false;
  }

}


class Tree_Path {
  int val;
  Tree_Path leftNode;
  Tree_Path rightNode;

  public  Tree_Path(int val) {
    this.val = val;
  }
}