

static void finsAllPaths(Node root) {
	Stirng str =root.data;
	finsAllPaths(root, str);

}


public void finsAllPaths(Node root, String str) {
  if(root.left == null) {
  	System.out.print(str)
  	return;
  }
  
  if(root.right == null) {
  	System.out.print(str)
  	return;
  }
  
   finsAllPaths(root.left, str + root.data);
   finsAllPaths(root.right, str + root.data);
}