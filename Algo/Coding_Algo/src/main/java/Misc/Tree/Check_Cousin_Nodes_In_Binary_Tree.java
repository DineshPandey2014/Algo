package Misc.Tree;

import org.junit.Test;

/**
 * Created by dpandey on 9/22/17.
 *
 * Cousin nodes in binary tree.
 *
 * Two nodes are said to be cousins of each other. If they are at same level of the Binary Tree and have
 * different parents.
 *
 *         6
 *       /    \
 *      3      5
 *      / \   /  \
 *     7  8   1  3
 *
 *     Say two nodes 7 and 1 are Cousins. Result is true
 *     Say two nodes 3 and 5 are not Cousins they in same level and having same parents.
 *     Say two nodes 7 and 5 are not Cousins they are not in same level but they have different parents.
 */
public class Check_Cousin_Nodes_In_Binary_Tree {

   class Node {
       Node left;
       Node right;
       int data;
       Node(int data) {
           this.data = data;
       }
    }

    @Test
    public void testCousinNode() {

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);

        root.left.left = new Node(7);
        root.left.right = new Node(8);

        root.right.left = new Node(1);
        root.right.right = new Node(3);

        Node node1, node2;
        // 7
        node1 = root.left.left;



    }


}
