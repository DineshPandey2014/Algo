package Arrays;

import org.junit.Test;

/*

                       3
                   /     \
                 1        5
               /  \      /
              0   2     4
                         \
                         6
 */

/**
 * A Binary tree is balanced. If the height
 */
public class BalancedBinaryTree {

   @Test
   public void testIsBalanced() {
     TreeNodeBalanced tree = new TreeNodeBalanced(3);
     tree.left = new TreeNodeBalanced(1);
     tree.right = new TreeNodeBalanced((5));
     tree.left.left = new TreeNodeBalanced(0);
     tree.left.right = new TreeNodeBalanced(2);
     tree.right.left = new TreeNodeBalanced(4);
     tree.right.left.right = new TreeNodeBalanced(6);

     int output = balancedHeight(tree);

     System.out.println(output);
   }

  public int balancedHeight(TreeNodeBalanced root) {
    if(root == null) {
      return 0;
    }

    int leftTreeHeight = balancedHeight(root.left);
    if(leftTreeHeight == -1) {
      return -1;
    }

    int rightTreeHeight = balancedHeight(root.right);
    if(rightTreeHeight == -1) {
      return -1;
    }

    // To check each node if it is balanced
    if(Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
      return -1;
    }

    // If they are balanced return height of the node.
    return (Math.max(leftTreeHeight, rightTreeHeight) + 1);
  }

}

class TreeNodeBalanced {
      int val;
   TreeNodeBalanced left;
   TreeNodeBalanced right;
   TreeNodeBalanced(int x) { val = x; }
  }