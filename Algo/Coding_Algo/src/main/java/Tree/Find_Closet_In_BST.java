package Tree;

import org.junit.Test;

public class Find_Closet_In_BST {

  public static int findClosestValueInBst(BST tree, int target) {
    return findClosestValueIterativeApproach(tree, target);
  }

  // Time Complexity Avg Case : O(log(n)
  // Space complexity Avg case : O(1)
  // Time COmplexity worst case O(n)
  // Sapce complexity worst case
  public static int findClosestValueIterativeApproach(BST tree, int target) {
    BST curr = tree;
    double closet = Double.MAX_VALUE;

    while(curr != null) {

      if(Math.abs(target- closet) > Math.abs(target - curr.value)) {
        closet = curr.value;
      }

      if( target > curr.value) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }

    }
    return (int) closet;
  }

  @Test
  public void testCloset() {
    BST root = new BST(5);
    root.left = new BST(2);
    root.right = new BST(4);
    root.left.left = new BST(1);
    root.left.right = new BST(3);
    double target = 3.714286;
    int x = closestValue(root, target);
    System.out.println(x);
  }

  public int closestValue(BST root, double target) {
    int closet = root.value;
    BST curr = root;
    int output = 0;
    while (curr != null) {

      if(curr.right != null  && target > curr.right.value) {
        curr = curr.right;
      } else if(curr.left != null){
        curr = curr.left;
      } else {
        curr = null;
      }

      if(curr != null && Math.abs(target - curr.value) < closet) {
        closet = curr.value;
      }

    }
    return closet;
  }
}

 class BST {
  public int value;
  public BST left;
  public BST right;

  public BST(int value) {
    this.value = value;
  }
}


