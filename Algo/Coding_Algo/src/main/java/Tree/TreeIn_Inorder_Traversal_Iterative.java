package Tree;

import java.util.Stack;

// https://www.youtube.com/watch?v=uMTrIjP_0Gw
// Iterative In order traversal
public class TreeIn_Inorder_Traversal_Iterative {

    // LNR
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
        TreeInOrderIterative tree = new TreeInOrderIterative(20);
        tree.leftNode = new TreeInOrderIterative(15);
        tree.rightNode = new TreeInOrderIterative(28);

        tree.leftNode.leftNode = new TreeInOrderIterative(10);
        tree.leftNode.rightNode = new TreeInOrderIterative(17);

        tree.rightNode.leftNode = new TreeInOrderIterative(25);
        tree.rightNode.rightNode = new TreeInOrderIterative(30);

        IterativeInorderTraversal_Method_Two(tree);

    }

    static void IterativeInorderTraversal_Method_Two(TreeInOrderIterative root) {
        Stack<TreeInOrderIterative> stack = new Stack<>();
        pushLeftNodeToStack(root, stack);

        while(!stack.isEmpty()) {
            TreeInOrderIterative node = stack.pop();
            System.out.println(node.data);
            pushLeftNodeToStack(node.rightNode, stack);

        }
    }

    public static void pushLeftNodeToStack(TreeInOrderIterative root, Stack stack) {
        while(root != null) {
            stack.push(root);
            root = root.leftNode;
        }
    }

    static void IterativeInorderTraversal_Method_One(TreeInOrderIterative root) {

        if(root == null) {
            return;
        }

        Stack<TreeInOrderIterative> stack = new Stack();

        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                // Push to stack untill root is not null.
                stack.push(root);
                root = root.leftNode;
            } else {
                // Pop from stack when root is null.
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.rightNode;
            }
        }
    }
}


class TreeInOrderIterative {
    TreeInOrderIterative leftNode;
    TreeInOrderIterative rightNode;
    int data;

    TreeInOrderIterative (int data) {
        this.data = data;
    }
}