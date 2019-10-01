package Tree.TestTree;

import org.junit.Test;

// Build a BS
public class BuildBstInputArray {

  // int a [] = {10, 15, 17, 20, 25, 28, 30};

 class TreeInputArray  {
   TreeInputArray leftNode;
   TreeInputArray rightNode;
   int data;
   TreeInputArray (int data) {
     this.data = data;

   }
 }

 @Test
 public void testBuildTree() {
   int a [] = {10, 15, 17, 20, 25, 28, 30};
   int startIndex = 0;
   int endIndex = a.length -1;

   TreeInputArray rootNode =  buildTree(a, startIndex, endIndex);

 }

 public  TreeInputArray buildTree(int x[], int startIndex, int endIndex) {
     if(startIndex > endIndex) {
        return null;
     }

    int mid = (startIndex + endIndex)/2;


   TreeInputArray node = new TreeInputArray(x[mid]);
    node.leftNode = buildTree(x, startIndex, mid -1);
    node.rightNode = buildTree(x, mid+1, endIndex);
    return node;
 }


}
