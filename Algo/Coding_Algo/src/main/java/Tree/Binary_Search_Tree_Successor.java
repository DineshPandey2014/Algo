package Tree;

/**
 * # good video
 * https://www.youtube.com/watch?v=jSZ4e3cmh2A
 *
 * https://www.youtube.com/watch?v=5cPbNCrdotA&t=197s
 *
 *
 * https://leetcode.com/problems/inorder-successor-in-bst/discuss/72662/*Java*-5ms-short-code-with-explanations
 *
 * https://www.youtube.com/watch?v=5cPbNCrdotA
 *
 */
public class Binary_Search_Tree_Successor {

  /**
   * To find Successor using iterative method
   * @param root
   * @param p
   * @return
   */

  /**
   *  Three conditions to find a successor
   *
   *  1. The node X has a right SubTree.
   *  2. The node X doesn't have a right subtree. It is right child of the parent
   *  3. The node X
   *
   */
  public TreeNode inorderSuccessor_Iterative_Solution(TreeNode root, TreeNode p) {
    TreeNode successor = null;

    while(root != null) {

      if(root.val > p.val) {
        successor = root;
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return successor;
  }

  /**
   * To find Predessor using iterative method
   * @param root
   * @param p
   * @return
   */
  public TreeNode inorder_Predessor_Iterative_Solution(TreeNode root, TreeNode p) {
    TreeNode predessor = null;

    while(root != null) {
      if(root.val < p.val) {
        predessor = root;
        root = root.right;
      } else {
        root = root.left;
      }
    }
    return predessor;
  }
}
