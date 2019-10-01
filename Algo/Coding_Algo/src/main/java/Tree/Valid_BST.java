package Tree;

public class Valid_BST {

    public static void main (String args[]) {

        //          4
      //       2        6
        //  1     3   5    7

        BFSTTree bfsTree = new BFSTTree(4);
        bfsTree.left = new BFSTTree(2);
        bfsTree.right = new BFSTTree(6);
        bfsTree.left.left = new BFSTTree(1);
        bfsTree.left.right = new BFSTTree(3);
        bfsTree.right.left = new BFSTTree(5);
        bfsTree.right.right = new BFSTTree(7);

        // Define a range of all possible integer values.
        // This will not work if the node have MAX_Integer Value. In that case we can take long MAX
        System.out.println("My tree is BST :- "+ isValidBST(bfsTree, Integer.MIN_VALUE, Integer.MAX_VALUE));


        }

    /**
     *  Key of our algorithm is to keep track of the resonable range of current focus node. Each node we need to pass the
     *  max and min range.
     *
     *  This algorithm runs in O(n) time, where n is the number of nodes of the binary tree
     *  Time Complexity : As we are going to touch all the nodes. Time Complexity will be O(n)
     *  Space COmplexity: Space complexity will be height of tree: O(log n)
     *
     */
    public static boolean isValidBST(BFSTTree tree, int min, int max) {

        // When  we reach to the leave node. Which is BST we will return true;
        if(tree == null) {
            return true;
        }

        if(tree.val > min && tree.val < max) {
            return isValidBST(tree.left, min, tree.val) && isValidBST(tree.right, tree.val, max);
        }
          else {
            return false;
        }

    }


}


class BFSTTree {

    int val;
    BFSTTree left;
    BFSTTree right;

    BFSTTree (int val) {
        this.val = val;
    }
}


// This is good solution if the tree bst contains Max Integer Number.
//    public boolean isValidBST(TreeNode root) {
//        Long min = Long.MIN_VALUE;
//        Long max = Long.MAX_VALUE;
//        return isBST(root, min, max);
//    }
//
//    boolean isBST(TreeNode root, long min, long max) {
//        if(root == null) {
//            return true;
//        }
//
//        if(root.val <= min || root.val >= max) {
//            return false;
//        }
//
//        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
//    }