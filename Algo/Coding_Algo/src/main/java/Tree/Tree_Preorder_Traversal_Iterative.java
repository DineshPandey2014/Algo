package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree_Preorder_Traversal_Iterative {

    /**
     *                  20
     *
     *           15              28
     *
     *      10       17       25      30
     *
     *
     *     Pre order traversal ---> : 20,15,10,17,28,25,30
     *
     *
     *
     */
    static Stack<TreePreOrderIterative> stack = new Stack();
    static List<Integer> list = new ArrayList();

    public static void main (String args[]) {
        TreePreOrderIterative tree = new TreePreOrderIterative(20);
        tree.leftNode = new TreePreOrderIterative(15);
        tree.rightNode = new TreePreOrderIterative(28);

        tree.leftNode.leftNode = new TreePreOrderIterative(10);
        tree.leftNode.rightNode = new TreePreOrderIterative(17);

        tree.rightNode.leftNode = new TreePreOrderIterative(25);
        tree.rightNode.rightNode = new TreePreOrderIterative(30);

        //preOrderTraversal(tree);
        List<Integer> list =preorderTraversal(tree);
    }

    public static void preOrderTraversal(TreePreOrderIterative root) {

        Stack<TreePreOrderIterative> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreePreOrderIterative node = stack.pop();
            System.out.println(node.data);

            if(node.rightNode != null) {
                stack.push(node.rightNode);
            }

            if(node.leftNode != null) {
                stack.push(node.leftNode);
            }

        }

    }

    public static List<Integer> preorderTraversal(TreePreOrderIterative root) {
        if(root ==  null) {
            return new ArrayList();
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreePreOrderIterative node = stack.pop();

            list.add(node.data);

            if(node.rightNode != null) {
                stack.push(node.rightNode);
            }

            if(node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }
        return list;

    }

}


class TreePreOrderIterative {
    TreePreOrderIterative leftNode;
    TreePreOrderIterative rightNode;
    int data;

    TreePreOrderIterative (int data) {
        this.data = data;
    }
}