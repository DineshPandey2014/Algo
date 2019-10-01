package Tree;

import org.junit.Test;

/**
 * Created by dpandey on 9/22/17.
 *
 * Given a binary search tree and a key return a node which has data as this key or return null.
 * If no node has data as key.
 *
 * Time complexity for searching in balanced binary tree.
 *
 * 1. Time complexity in Balanced Binary Search Tree O(logn)
 *
 * 2. Searching in Binary Tree is O(n). You have to traverse each and every node.
 *
 * Test Cases:
 * 1) null Tree.
 * 2) Tree with one node and key is that node
 * 3) Tree with many node and key does not exist.
 * 4) Tree with many nodes and key does not exist.
 *
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/BSTSearch.java
 *
 */
public class Search_In_Binary_Search_Tree {

   class  Node {
       Node left;
       Node right;
       int data;

       Node(int data) {
           this.data = data;
       }
   }

    Node findNode(Node root, int  key) {
        if(root == null) {
            return null;
        }

        if(root.data == key) {
           return root;
        } else if(root.data > key) {
            return findNode(root.left, key);
        } else {
            return findNode(root.right, key);
        }
    }

    @Test
    public  void main() {
        Search_In_Binary_Search_Tree bst = new Search_In_Binary_Search_Tree();
        Node root = new Node(10);
        root.left = new Node(-10);
        root.right = new Node(20);
        root.left.left = new Node(-1);
        root.left.right = new Node(0);
        root.right.left = new Node(15);
        root.right.right = new Node(21);

        Node node  = bst.findNode(root, 0);
        System.out.println("Node Data "+ node.data);

        Node nodeOne  = bst.findNode(root, 20);
        System.out.println("Node Data "+ nodeOne.data);
    }

}
