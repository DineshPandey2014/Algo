package Tree;


/**
 * Comparing two trees same means Structuratially and value wise.
 *
 * https://leetcode.com/problems/same-tree/submissions/
 *
 * DFS Search
 *
 * Time  omplexity : We are traversing both tree together. Putting the nodes on stack to their height
 *                 " 2(Ologn) ==> O(logn)
 *  Let's say we have two three of height h1 and h2.
 *  We will put in the stack min of the (h1 and h2)  to stack. And then we know two tree are not same
 *
 *
 *  These two trees are not structurally same. But they are equal in order traversal.
 *       2
 *    /       \
 *   1        3
 *
 *
 *
 *            3
 *           /
 *        2
 *      /
 *    1
 *
 * Below algorithm will return  false.
 *
 */
public class Compare_Two_Tree_Are_Same {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return compareTwoTrees(p, q);
  }

  // DFS Traversal
  public boolean compareTwoTrees(TreeNode p, TreeNode q) {

    if(p == null && q == null) {
      return true;
    }


    if(p == null && q != null) {
      return false;
    }

    if(p != null && q == null) {
      return false;
    }

    if(p.val != q.val) {
      return false;
    }



    return compareTwoTrees(p.left, q.left) && compareTwoTrees(p.right, q.right);
  }
}
