package Tree;

import org.junit.Test;

public class TestSerialize {


  @Test

  public void testSerializeCode() {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(3);
    node.right.left = new TreeNode(4);
    node.right.right = new TreeNode(5);

    String serializeResult = serialize(node);
    System.out.println("serializeResult" + serializeResult);

    TreeNode result = deserialize(serializeResult);
  }

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
}

