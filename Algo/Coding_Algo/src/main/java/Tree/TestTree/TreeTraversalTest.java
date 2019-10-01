package Tree.TestTree;

 public class TreeTraversalTest {

   // PreOrderTraversal
   void preOrderTraversal(TreeNodeTest node) {
     if(node == null) {
       return;
     }

     System.out.println(node.data);
     preOrderTraversal(node.left);
     preOrderTraversal(node.right);
   }

   // In order traversal
   void inOrderTraversal(TreeNodeTest node) {
     if(node == null) {
       return;
     }

     preOrderTraversal(node.left);
     System.out.println(node.data);
     preOrderTraversal(node.right);
   }

   // Post order traversal
   void postOrderTraversal(TreeNodeTest node) {
     if(node == null) {
       return;
     }

     preOrderTraversal(node.left);
     preOrderTraversal(node.right);
     System.out.println(node.data);
   }



   class TreeNodeTest {
     TreeNodeTest left;
     TreeNodeTest  right;
     int data;
     public TreeNodeTest (int data) {
       this.data = data;
     }
   }


 }





