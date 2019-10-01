package Tree;

public class BuildBst_Input_Array {

    /**
     *                  20
     *
     *           15              28
     *
     *      10       17       25      30
     *
     *
     *     In order traversal ---> : 10, 15, 17, 20, 25, 28, 30
     *
     *
     *
     */


    public static void main (String args[]) {
        /*
        TreeInOrder tree = new TreeInOrder(20);
        tree.leftNode = new TreeInOrder(15);
        tree.rightNode = new TreeInOrder(28);

        tree.leftNode.leftNode = new TreeInOrder(10);
        tree.leftNode.rightNode = new TreeInOrder(17);

        tree.rightNode.leftNode = new TreeInOrder(25);
        tree.rightNode.rightNode = new TreeInOrder(30);
        */

        int a [] = {10, 15, 17, 20, 25, 28, 30};

        BSTTreeNode node = buildBST( a, 0, a.length-1);

        System.out.println();

    }

  static   BSTTreeNode buildBST(int a[], int start, int end ) {

        int mid = (start + end)/2;

        if(start > end) {
            return null;
        }

        BSTTreeNode treeNode = new BSTTreeNode(a[mid]);

        treeNode.left_ptr = buildBST( a, start, mid - 1);

        treeNode.right_ptr = buildBST(a, mid+1, end);

        return treeNode;

    }
}

class BSTTreeNode
{
    int val;
    BSTTreeNode left_ptr;
    BSTTreeNode right_ptr;

    BSTTreeNode(int _val)
    {
        val = _val;
        left_ptr = null;
        right_ptr = null;
    }
}