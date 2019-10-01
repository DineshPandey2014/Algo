



public void preOrderTraversal(BinaryTreeBST node) {
   
   Stack<BinaryTreeBST> stack = new Stack();
   
   stack.push(node);
   
   while(!stack.isEmpty()) {
  
   BinaryTreeBST node = stack.pop();
   if(node.right != null) {
   	stack.push(node.right);
   }
   
   if(node.left != null) {
    stack.push(node);
   }
 }

}
// PreOrderTraversal of BST (Binary search tree)

void preOdreTraversal(Tree node) {
  System.out.println (node.data);
  preOdreTraversal(node.left);
  preOdreTraversal(node.right);
}

       35
    /      \
   25        45
  /   \      /  \
  10    26   36  46
  
  // 10, 25, 26, 35, 36, 45, 46


// Iterative
public void InorderTraversal_Iterative(BinaryTreeBST root;) {
  
  if(root == null) {
  	return;
  }
  
  Stack<BinaryTreeBST> stack = new Stack();
  
  while(!stack.isEmpty() || root != null})  {
  
    if(root != null) {
       // Push the Node in Stack
       stack.pus(root);
       root = root.left;
       
    } else {
        // Pop the node from stack and print
        root = stack.pop();
        System.out.println(root.data);
        root = root.right;
    }
  
  
  
  |
}

}