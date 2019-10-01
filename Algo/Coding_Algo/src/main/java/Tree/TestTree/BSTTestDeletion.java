package Tree.TestTree;

class BSTDeletionTree {
  public BSTDeletionTree left;
  public BSTDeletionTree right;
  int value;

  BSTDeletionTree (int data) {
    this.value = data;
  }
}

public class BSTTestDeletion {

  BSTDeletionTree deletionTree(BSTDeletionTree root, int data) {

    if(root.value == data) {
      if(root.left == null) {
         return root.right;
      }

      if(root.right == null) {
        return root.left;
      }
      BSTDeletionTree p = findSuccessor(root);
      root.value = p.value;
      root.right = deletionTree(root, p.value);
      return root;
    }

    if(data < root.right.value) {
      root.left = deletionTree(root.left, data);
    }

    if(data > root.right.value) {
      root.right = deletionTree(root.right, data);
    }

    return root;
  }

  public BSTDeletionTree findSuccessor(BSTDeletionTree node) {
    BSTDeletionTree curr = node.right;

    while(curr != null && curr.left != null) {
      curr = curr.left;
    }
    return curr;
  }

}
