package Tree;

//https://www.youtube.com/watch?v=hmWhJyz5kqc
public class Minimum_Depth_Binary_Tree {

  public static void main(String args[]) {
    TreeNodeBinaryTree node = new TreeNodeBinaryTree(2);
    node.left = new TreeNodeBinaryTree(1);
    minDepth(node);
  }

  // Recursive approach
  // Bottom Approach
  // POST ORDER traversal
  // LEFT-RIGHT-NODE

  /**
   *  1. For minimum depth of a tree. When for a leaf node both left is null and right is null then we return 0. Which
   *  is minimum
   *
   *  2. When for a given node when one of the node say left or right is not null. Then we simply add right + left + 1
   *     we will not find the Math.min(right, left) + 1;
   *
   *
   */
  public static int minDepth(TreeNodeBinaryTree root) {
        if(root == null) {
            return 0;
        }

        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        return (leftMinDepth == 0 || rightMinDepth == 0) ? leftMinDepth + rightMinDepth + 1 : Math.min(leftMinDepth, rightMinDepth) +1;
    }


    public int minDepth(TreeNode root) {
      if(root == null) {
        return 0;
      }

      if(root.left == null && root.right == null) {
        return 1;
      }
      // For Internal node if suppose left is null and right is not null
      // In this case we assigned MAX value to right or MAX value to left.
      int left = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
      int right = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

      return Math.min(left, right) + 1;
    }
}


class TreeNodeBinaryTree {
  int val;
  TreeNodeBinaryTree left;
  TreeNodeBinaryTree right;
  TreeNodeBinaryTree(int x) {
    val = x;
  }

}