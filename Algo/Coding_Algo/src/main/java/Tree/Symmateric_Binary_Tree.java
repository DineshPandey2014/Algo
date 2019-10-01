package Tree;

/**
 * https://www.youtube.com/watch?v=8t4KCaDB108&t=262s
 *
 *
 */
public class Symmateric_Binary_Tree {

  public boolean isSymmetricTree(TreeNode nodeOne, TreeNode nodeTwo) {
    if(nodeOne == null && nodeTwo == null) {
      return true;
    }

    if(nodeOne == null || nodeTwo == null) {
      return false;
    }
    return (nodeOne.val == nodeTwo.val) &&isSymmetricTree(nodeOne.left, nodeTwo.right) && isSymmetricTree(nodeOne.right, nodeTwo.left);

  }
    /*
    public boolean isSymmetricTree(TreeNode nodeOne, TreeNode nodeTwo) {
        if(nodeOne == null && nodeTwo == null) {
            return true;
        }

        if(nodeOne == null || nodeTwo == null) {
            return false;
        }

          // For every level we check if the root left value is equal to right value.
        if(nodeOne.val != nodeTwo.val) {
            return false;
        }

        return isSymmetricTree(nodeOne.left, nodeTwo.right) && isSymmetricTree(nodeOne.right, nodeTwo.left);

    }*/
}
