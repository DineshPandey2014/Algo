package Tree;

// Two aproach

// Given level K. Print all the nodes of the binary tree at given level

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;


/*

           1
         /     \
         2      3
      /   \     /
      4     5  6
 */

/* BFS Approach: Time complexity to print all the the n nodes in Binary Tree is : 2^n

   Time Complexity Average Case: For K level Here we need to travers all the nodes upto K level:
                     2 ^ k-1 ==>
   Worst case: TIme complexity is O(n).

   Space Complextity : if Tree is complete we need. Means half the  nodes are leaves. which n/2
                       O(n)

 */

// Better is DFs clean code
/*
    DFS :
    Time complexity is : 2^k-1
    Space COmplexity is height of Tree : log(n)

 */

public class Print_All_Nodes_For_Input_Level {

  @Test
  public void printAllNode() {
    NodeLevel root = new NodeLevel(1);
    root.left = new NodeLevel(2);
    root.right = new NodeLevel(3);
    root.left.left = new NodeLevel(4);
    root.left.right = new NodeLevel(5);
    root.right.left = new NodeLevel(6);

    printAllNodesAtGivenLevel_BFS(root, 3);
  }


  public void printAllNodesAtGivenLevel_BFS(NodeLevel root, int level) {

    Queue<NodeLevel> queue = new LinkedList<>();
    queue.add(root);
    root.level = 1;

    while(!queue.isEmpty()) {
      NodeLevel node = queue.poll();
      int nextLevel = node.level;

      if(nextLevel == level) {
          System.out.println(node.data);
      }

      // Note level of each right node and left node is same
      ++nextLevel;

      if(node.left != null) {
        node.left.level = nextLevel;
        queue.add(node.left);
      }

      if(node.right != null) {
        node.right.level = nextLevel;
        queue.add(node.right);
      }


    }

  }

  // Here we are passing the level of tree.
  // When we do depth first we will decrement the level. And when we reached at level equal to 1 then we print the node.

  public void printAllNodesAtGivenLevel_DFS(NodeLevel root, int level) {
    if(root == null) {
      return;
    }

    if(level == 1) {
      // print data
    } else {
      // printLevelK(root.left,k-1);
      // printLevel(root.right,k-1);
    }
  }

}

class NodeLevel {
  public int data;
  // Default valle of level is zero. We will start level as 1.
  public int level;
  public NodeLevel left;
  public NodeLevel right;

  NodeLevel (int data) {
    this.data = data;
  }

}
