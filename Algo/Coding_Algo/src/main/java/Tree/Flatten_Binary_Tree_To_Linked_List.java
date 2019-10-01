package Tree;

import java.util.Stack;

/**
 * Inplace algo
 * https://www.youtube.com/watch?v=13LiuUg0gW8
 *
 * https://www.youtube.com/watch?v=IZtFqpMyFLQ
 *
 *              1
 *            /  \
 *           2     5
 *          / \    \
 *         3   4    6
 *
 *         Preorder Traversal (Node/Left/Right) ---> 1, 2, 3, 4,5,6
 */
public class Flatten_Binary_Tree_To_Linked_List {


  public static void main (String args[]) {
    BSTNode node = new BSTNode(1);
    node.left = new BSTNode(2);
    node.right = new BSTNode(5);
    node.left.left = new BSTNode(3);
    node.left.right = new BSTNode(4);
    node.right.right = new BSTNode(6);
    //flattenIterative(node);
    flattenRecursive(node);
  }

  static BSTNode prev = null;
  public static void flattenRecursive(BSTNode root) {
    if (root == null) {
      return;
    }

    flattenRecursive(root.right);
    flattenRecursive(root.left);
    root.right = prev;
    root.left = null;
    prev = root;

  }
  // Iterative solution for preorder traversal for binary tree.

  /**
   *  Leet Code 114
   *
   * https://www.youtube.com/watch?v=vssbwPkarPQ
   *
   * Time complexity and space complexity
   *
   * Time compelxity : O(n) --> We need to process each node. Means traverse each node.
   * Space complexity : O(n) --> Stack size can go up to O(N)
   *
   * @param root
   */
  public static void flattenIterative(BSTNode root) {
    if (root == null) {
      return;
    }

    Stack<BSTNode> stack = new Stack();
    stack.push(root);

    while(!stack.isEmpty()) {
      BSTNode node = stack.pop();

      if(node.right != null) {
        stack.push(node.right);
      }

      if(node.left != null) {
        stack.push(node.left);
      }
      if(!stack.isEmpty()) {
        node.right = stack.peek();
      }
      node.left = null;
    }

  }
}

class BSTNode {
  BSTNode left;
  BSTNode right;
  int data;

  public BSTNode(int data) {
    this.data = data;
  }
}