

public void postOrderTraversal_Iterative(Tree node) {

  Stack<Integer> stackOne = new Stack();
  Stack<Integer> stackTwo = new Stack();
  int data = node.data;
  
  stackOne.push(data);
  
  while(stack.isNotEmpty()) {
  int data = stackOne.pop();
  stackTwo.push(data);
  
  if(stackOne.left != null) {
     stackOne.push(stackOne.data);
  } 
  
  if(stackOne.right != null) {
    stackOne.push(stackOne.data);
  
  }
  
  
  while () {
  
  
  }


}

