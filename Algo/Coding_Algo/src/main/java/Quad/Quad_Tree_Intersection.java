package Quad;


/**
 * https://leetcode.com/problems/quad-tree-intersection/submissions/
 *
   A quadtree is a tree to represent 2D plane/space.
 A quad tree is a tree data in which each internal node has exactly four children. TopLeft, TopRight, BottomLeft,
 BottomRight. Quad tree are often used to parition a two-dimensional space. By recursive subdividing it into
 four quadrants or regions.

 We want to store True/False information in our quad Tree. The quad tree is used to represent a N * N boolean grid.
 For each node, it will be subdivided into four children nodes until the values in the region it represents are all
 the same. Each node has another two boolean attributes. isLeaf and val.

 isLeaf : is true if and only if the node is a leaf node.
 The val attribute for a leaf node contains the value of the region it represents.

 For example below are teo quad trees A and B.

 A:
 |-------------------------|
 |           |     T       |
 |   T       |             |
 --------------------------
 |          |             |
 |   F      |      F      |
 |          |             |
 -------------------------
 TopLeft : T
 TopRight " T
 Bottom LEft: F
 BottomRight " F


 B:

 |-------------------------|
 |           |      |      |
 |   T       |      |      |
 --------------------------
 |          |             |
 |   F      |      F      |
 |          |             |
 -------------------------

 */
public class Quad_Tree_Intersection {


  public Node intersect(Node q1, Node q2) {
    return findQuadTreeIntersection( q1,  q2, new Node());

  }

  public Node findQuadTreeIntersection(Node q1, Node q2, Node result) {
    // Here we are checking if the node q1 is leaf. Having True value
    if (q1.isLeaf) {
      // Here we are checking the value of Node is true. For intersection of Two nodes.
      // If one node is true. then OR condition with other node makes it true. Will return the node itself.
      //  Other wise will return the other node.
      if(q1.val) { // True
        return q1;
      } else {
        return q2;
      }
    }

    if (q2.isLeaf) {
      if(q2.val) {
        return q2;
      } else {
        return q1;
      }
    }

    // Now the control comes here. Means Node q1 is not a leaf and q2 is not a leaf.
    // We need to recursive called intersect for all four qudrant.

    result.topLeft = intersect(q1.topLeft, q2.topLeft);
    result.topRight = intersect(q1.topRight, q2.topRight);
    result.bottomLeft = intersect(q1.bottomLeft, q2.bottomLeft);
    result.bottomRight = intersect(q1.bottomRight, q2.bottomRight);

    if (result.topLeft.isLeaf && result.topRight.isLeaf
            && result.bottomLeft.isLeaf && result.bottomRight.isLeaf
            && result.topLeft.val == result.topRight.val
            && result.topRight.val == result.bottomLeft.val
            && result.bottomLeft.val == result.bottomRight.val) {

      // Intersection will happend when you at leaf quadrant which don't have child.
      // Here we are doing intersection of four qudrant to one quadrant
      // Here will check if all are leaves "True" and all node value is "true"
      result.isLeaf = true;
      result.val = true;
    } else {
      // If any node of intersection having value as false
      result.isLeaf = false;
      result.val = false;
    }

    return result;
  }
}

class Node {

 public Node topLeft;
 public Node topRight;
 public Node bottomLeft;
 public Node bottomRight;

 // If the node is leaf that quadrant is the lowest one. All quadrant will be null
 // (topLeft, topRight, bottomLeft, bottomRight)
 public boolean isLeaf;

 // Node value we are representing as True or False or (0 or 1)
 public boolean val;

 public Node() {

 }

 public Node(Node topLeft, Node topRight, Node bottomLeft, Node bottomRight, boolean isLeaf, boolean val) {
   this.topLeft = topLeft;
   this.topRight = topRight;
   this.bottomLeft = bottomLeft;
   this.bottomRight = bottomRight;
   this.isLeaf = isLeaf;
   this.val = val;
 }

}


/*
public class Quad_Tree {
  public Node intersect(Node q1, Node q2) {
    if (q1.isLeaf) {
      return q1.val ? q1 : q2;
    }
    if (q2.isLeaf) {
      return q2.val ? q2 : q1;
    }

    q1.topLeft = intersect(q1.topLeft, q2.topLeft);
    q1.topRight = intersect(q1.topRight, q2.topRight);
    q1.bottomLeft = intersect(q1.bottomLeft, q2.bottomLeft);
    q1.bottomRight = intersect(q1.bottomRight, q2.bottomRight);

    if (q1.topLeft.isLeaf && q1.topRight.isLeaf
            && q1.bottomLeft.isLeaf && q1.bottomRight.isLeaf
            && q1.topLeft.val == q1.topRight.val
            && q1.topRight.val == q1.bottomLeft.val
            && q1.bottomLeft.val == q1.bottomRight.val) {
      q1.isLeaf = true;
      q1.val = q1.topLeft.val;
    }
    return q1;
  }
}


class Node {
  public boolean val;
  public boolean isLeaf;
  public Node topLeft;
  public Node topRight;
  public Node bottomLeft;
  public Node bottomRight;

  public Node() {}

  public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
    val = _val;
    isLeaf = _isLeaf;
    topLeft = _topLeft;
    topRight = _topRight;
    bottomLeft = _bottomLeft;
    bottomRight = _bottomRight;
  }
};*/
