package Tree;

import org.junit.Test;

public class CountTotalNumberOfNodes_In_BST {

  @Test
  public void testCountNode() {
    CountBSTNode node = new CountBSTNode(5);
    node.leftNode = new CountBSTNode(3);
    node.rightNode = new CountBSTNode(7);
    node.rightNode.leftNode = new CountBSTNode(8);
    int count = countNode(node);
    System.out.println(count);
  }


  public int countNode(CountBSTNode node) {
    if(node.leftNode == null && node.rightNode == null) {
      return 1;
    }

    int leftCount = 0;
    if(node.leftNode  != null) {
      leftCount = countNode(node.leftNode);
    }

    int rightCount = 0;
    if(node.rightNode  != null) {
      rightCount = countNode(node.rightNode);
    }

    return leftCount + rightCount + 1;
  }

}

class CountBSTNode {
  public int data;
  public CountBSTNode leftNode;
  public CountBSTNode rightNode;
   public  CountBSTNode (int data) {
      this.data = data;
    }


}