package Misc.Tree;

import org.junit.Test;

/**
 * Created by dpandey on 9/21/17.
 */
public class HeightOfTree {

    class Node {
        int data;
        Node right;
        Node left;
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Get the height of left subtree.
     * Get the height of right subtree.
     * Take the Max(leftHeight, rightHeight) and add 1 for the root and return.
     *
     * Here it means the height of leave node is 1.
     *
     * Time Complexity is O(1)
     *
     * @return
     */
    int getTreeHeight(Node root) {

        if(root == null) {
            return 0;
        }
         // If we are assuming that height of a leave node is 0
        if(root.left == null && root.right == null) {
            return 0;
        }
        //return (1+ Math.max(getTreeHeight(root.left),getTreeHeight(root.right)));

        int heightLeftTree =  getTreeHeight(root.left);
        int heightRightTree = + getTreeHeight(root.right);

        return 1 + Math.max(heightLeftTree, heightRightTree);

    }

    @Test
    public void  testHeight() {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);

        root.left.left = new Node(20);
        root.left.right = new Node(25);

        root.left.left.left = new Node(30);
        root.left.right.left = new Node(35);

        root.left.right.left.left = new Node(40);
        root.left.right.left.left.right = new Node(45);

        root.left.right.left.left.right.left = new Node(50);
        System.out.println(getTreeHeight(root));
    }

}
