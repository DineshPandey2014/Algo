package Tree;

public class Binary_Search_Tree_Insertion_Of_Node {

  public static void main (String args[]) {

    TreeNodeBSTInsert node = new TreeNodeBSTInsert(4);
    node.left = new TreeNodeBSTInsert(2);
    node.right = new TreeNodeBSTInsert(7);
    node.left.left = new TreeNodeBSTInsert(1);
    node.left.right= new TreeNodeBSTInsert(3);

    TreeNodeBSTInsert root = insertIntoBST(node, 5);

  }

  // Recursive
  public static TreeNodeBSTInsert insertIntoBST(TreeNodeBSTInsert root, int val) {
    if(root == null) {
      return new TreeNodeBSTInsert(val);
    }

    if(val < root.val) {
      if(root.left == null) {
        root.left = new  TreeNodeBSTInsert(val);
      }
      root.left = insertIntoBST(root.left, val);
    } else if(val > root.val) {
      if(root.right == null) {
        root.right = new  TreeNodeBSTInsert(val);
      }
      root.right = insertIntoBST(root.right, val);
    }
    return root;
  }
}

 class TreeNodeBSTInsert {
  public int val;
  public TreeNodeBSTInsert left;
  public TreeNodeBSTInsert right;
   public TreeNodeBSTInsert(int x) { val = x; }
}