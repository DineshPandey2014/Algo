package Tree;

class TreeNodeBST {
  private TreeNodeBST left;
  private TreeNodeBST rigth;
  private int data;
  TreeNodeBST (int data) {
    this.data = data;
  }

}

public class SearchBST_Recursive {
  private TreeNode node;

  public static  void main(String args[]) {

  }


  // Recursive Two solution
  public TreeNode searchBSTRecursive_Recursive_Two(TreeNode root, int val) {
    if(root == null || root.val == val) {
      return root;
    }

    if(val < root.val) {
      return searchBSTRecursive_Recursive_Two(root.left, val);
    }

    return searchBSTRecursive_Recursive_Two(root.right, val);
  }


  // Recursive One solution
  public TreeNode searchBSTRecursive_Recursive_One(TreeNode root, int val) {
    if(root == null) {
      return null;
    }

    if(root.val == val) {
      return root;
    }

    if(val < root.val) {
      node = searchBSTRecursive_Recursive_One(root.left, val);
    } else {
      node = searchBSTRecursive_Recursive_One(root.right, val);
    }
    return node;
  }

  // Iterative
  public TreeNode searchBSTIterative(TreeNode root, int val) {
    TreeNode curr = root;
    while(curr != null && curr.val != val) {
      if(val < root.val) {
        curr = curr.left;
      } else if(val > root.val) {
        curr = curr.right;
      }
    }

    return curr;
  }

}
