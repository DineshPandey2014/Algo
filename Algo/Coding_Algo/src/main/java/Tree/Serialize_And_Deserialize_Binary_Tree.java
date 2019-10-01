package Tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://www.youtube.com/watch?v=plddsldeckc&t=618s
 *
 *
 * Leet Code : 297
 * Complexity : Hard
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * https://www.youtube.com/watch?v=jwzo6IsMAFQ&t=159s
 *
 * 297. Serialize and Deserialize Binary Tree
 *
 */

   /*
   You may serialize the following tree: Preorder traversal : Root--->LEFT--->RIGHT

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

    */
public class Serialize_And_Deserialize_Binary_Tree {

  @Test
  public  void testSerialize_Deserialize () {
      //[1,2,3,null,null,4,5]

    TreeNodeBSTSerialize bstNode = new TreeNodeBSTSerialize(1);
    bstNode.left = new TreeNodeBSTSerialize(2);
    bstNode.right = new TreeNodeBSTSerialize(3);
    bstNode.right.left = new TreeNodeBSTSerialize(4);
    bstNode.right.right = new TreeNodeBSTSerialize(5);

    String serialize = serialize(bstNode);
    TreeNodeBSTSerialize deSerializeBST = deserialize(serialize);
  }


  public String serialize(TreeNodeBSTSerialize root) {
    StringBuilder str = new StringBuilder();
    serializeHelper(root, str);
    return str.toString();
  }

  // Pre order traversal of Tree (Node, Left, Right)
  public void serializeHelper(TreeNodeBSTSerialize root, StringBuilder strBuilder) {
    if(root == null  ) {
      strBuilder.append("null").append(",");
    } else {
      strBuilder.append(root.val).append(",");
      serializeHelper(root.left, strBuilder);
      serializeHelper(root.right, strBuilder);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNodeBSTSerialize deserialize(String data) {
    String array [] = data.split(",");
    Queue<String> queue = new LinkedList();
    queue.addAll(Arrays.asList(array));
    return deserializeHelper(queue);
  }

  public TreeNodeBSTSerialize deserializeHelper(Queue<String> queue) {
    String str = queue.poll();
    if(str.equals("null")) {
      return null;
    } else {
      TreeNodeBSTSerialize node = new TreeNodeBSTSerialize(Integer.parseInt(str));
      node.left = deserializeHelper(queue);
      node.right = deserializeHelper(queue);
      return node;
    }
  }


}


class TreeNodeBSTSerialize {
  int val;
  TreeNodeBSTSerialize left;
  TreeNodeBSTSerialize right;

  TreeNodeBSTSerialize(int val) {
    this.val = val;
  }
}


/*
   This is recursive solution
   1. Here we are keeping index of array in integer and then increment the number.
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root == null) {
      return null;
    }

    StringBuffer strBuff = new StringBuffer();
    serializeHelper(root, strBuff);
    return strBuff.toString();
  }

  // Its a binary tree we will trqverse tree as PRE ORDER TRAVERSAL
  public void serializeHelper(TreeNode root, StringBuffer strBuf ) {
    if(root == null) {
      strBuf.append("null" + ";");
    } else {
      strBuf.append(root.val);
      strBuf.append(";");
      serializeHelper(root.left,strBuf);
      serializeHelper(root.right,strBuf );
    }
  }

  // Split the String based on delimiter.
  // Will get String Array
  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String input [] = data.split(";");
    int x [] =  {0};
    return deserializeHelper(input, x);

  }

  TreeNode  deserializeHelper(String input [], int i []) {
    int counter = i[0];
    String str = input[counter];

    if(str.equals("null")) {
      return null;
    } else {

      TreeNode node = new TreeNode(Integer.parseInt(str));
      i[0]++;
      node.left = deserializeHelper(input, i);
      i[0]++;
      node.right = deserializeHelper(input, i);
      return node;
    }
  }
*/

