package Tree;

import java.util.Stack;

public class Post_Order_Traversal_Using_Iterative {


     // LEFT, RIGHT, NODE
    /**
     *                        1
     *              -10                  11
     *            2      5          11         16
     *                      3
     *
     *       2-> 3-->5 ---> -10 ---> 11 --> 16 --> 11---> 1
     *
     *
     *
     */
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-10);
        root.right = new TreeNode(11);

//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(5);
//        root.left.right.right = new TreeNode(3);
//        root.right.left = new TreeNode(11);
//        root.right.right = new TreeNode(16);

        treeTraversalPostOrder(root);

    }

    /**
     * Note: As we are using two stack. So in first stack we push as Node, LEFT,Right
     * .When we pop from first Stack to Second stack order will be ---> Right, LEFT, NODE.
     * .And again we pop as out put. IT will will come in POST ordefr that will ---> NODE,LEFT,RIGHT
     *
     */

    /**
     *                         1
     *             -10                  11
     *                  5          11         16
     *                      3
     *
     *        3-->5 ---> -10 ---> 11 --> 16 --> 11---> 1
     *
     *
     *
     */
    // Iterative function to perform post-order traversal of the tree
    public static void postorderIterative(TreeNode root)
    {
        // create an empty stack and push root node
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        // create another stack to store post-order traversal
        Stack<Integer> out = new Stack();

        // run till stack is not empty
        while (!stack.empty())
        {
            // we pop a node from the stack and push the data to output stack
            TreeNode curr = stack.pop();
            out.push(curr.val);

            if (curr.right != null) {
                stack.push(curr.right);
            }

            // push left and right child of popped node to the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }


        }

        // print post-order traversal
        while (!out.empty()) {
            System.out.print(out.pop() + " ");
        }
    }

    public static void treeTraversalPostOrder(TreeNode node) {
        if(node == null) {
            return;
        }
         Stack<TreeNode> stackOne = new Stack();
         Stack<TreeNode> stackTwo = new Stack();

        stackOne.push(node);
        while(!stackOne.isEmpty()) {
            TreeNode popedNode = stackOne.pop();
            stackTwo.push(popedNode);

            if(popedNode.left != null) {
                stackOne.push(popedNode.left);
            }

            if(popedNode.right != null) {
                stackOne.push(popedNode.right);
            }
        }

        while(!stackTwo.isEmpty()) {
            System.out.print( " " + stackTwo.pop().val);
        }
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

   public  TreeNode(int val) {
        this.val = val;
    }


}
