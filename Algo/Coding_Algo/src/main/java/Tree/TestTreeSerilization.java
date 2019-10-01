package Tree;

public class TestTreeSerilization {

  public static void main (String args[]) {
    //[1,2,3,null,null,4,5]

    TreeNodeSeriliaze bstNode = new TreeNodeSeriliaze(1);
    bstNode.left = new TreeNodeSeriliaze(2);
    bstNode.right = new TreeNodeSeriliaze(3);
    bstNode.right.left = new TreeNodeSeriliaze(4);
    bstNode.right.right = new TreeNodeSeriliaze(5);
    String serialize = serialize(bstNode);
  }

  public static String rserialize(TreeNodeSeriliaze root, String str) {
    // Recursive serialization.
    if (root == null) {
      str += "null,";
    } else {
      str += str.valueOf(root.val) + ",";
      str = rserialize(root.left, str);
      str = rserialize(root.right, str);
    }
    return str;
  }

  // Encodes a tree to a single string.
  public static String serialize(TreeNodeSeriliaze root) {
    return rserialize(root, "");
  }
}

class TreeNodeSeriliaze {
  int val;
  TreeNodeSeriliaze left;
  TreeNodeSeriliaze right;

  TreeNodeSeriliaze(int x) {
    val = x;
  }
}