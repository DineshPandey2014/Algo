package Tree;

public class Binary_Tree_In_Order_Traversal_Recursive_DFS {

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
        TreeInOrder tree = new TreeInOrder(20);
        tree.leftNode = new TreeInOrder(15);
        tree.rightNode = new TreeInOrder(28);

        tree.leftNode.leftNode = new TreeInOrder(10);
        tree.leftNode.rightNode = new TreeInOrder(17);

        tree.rightNode.leftNode = new TreeInOrder(25);
        tree.rightNode.rightNode = new TreeInOrder(30);

        inOrderTraversal(tree);
    }


    public static  void inOrderTraversal (TreeInOrder node) {
        if(node == null) {
            return;
        }
        inOrderTraversal(node.leftNode);
        System.out.println(node.data);
        inOrderTraversal(node.rightNode);
    }



}


class TreeInOrder {
    TreeInOrder leftNode;
    TreeInOrder rightNode;
    int data;

    TreeInOrder (int data) {
        this.data = data;
    }
}