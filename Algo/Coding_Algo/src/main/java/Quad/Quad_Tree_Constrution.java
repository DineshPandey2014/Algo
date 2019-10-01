package Quad;

import org.junit.Test;

/*
  https://candysonya.github.io/2018/09/22/Construct-Quad-Tree/



 */
public class Quad_Tree_Constrution {

  @Test
  public void testQuadTree () {
    // Grid of 2 by 2

    int grid [] [] = {
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 0, 0, 1}
    };

   /* int grid [] [] = {
            {0,0},
            {0,0}};
   */
    QuadNode node = construct(grid);
  }

  public QuadNode construct(int[][] grid) {
    return helper(grid, 0, 0, grid.length);
  }

  private QuadNode helper(int[][] grid, int x, int y, int len) {
    // For leave condition
    if(len == 1) return new QuadNode(grid[x][y] == 1, true,
            null, null, null, null);

    QuadNode nodeTL = helper(grid, x, y, len/2);
    QuadNode nodeTR = helper(grid, x, y+len/2, len/2);
    QuadNode nodeBL = helper(grid, x+len/2, y, len/2);
    QuadNode nodeBR = helper(grid, x+len/2, y+len/2, len/2);

    // Merge all child nodes
    if(nodeTL.isLeaf && nodeTR.isLeaf && nodeBL.isLeaf && nodeBR.isLeaf) {

      if(nodeTL.val && nodeTR.val && nodeBL.val && nodeBR.val) {
        return new QuadNode(true, true, null, null, null, null);
      }

      if(!nodeTL.val && !nodeTR.val && !nodeBL.val && !nodeBR.val) {
        return new QuadNode(false, true, null, null, null, null);
      }
    }

    // Combining all nodes
    return new QuadNode(true, false, nodeTL, nodeTR, nodeBL, nodeBR);
  }
}

class QuadNode {
  public boolean val;
  public boolean isLeaf;
  public QuadNode topLeft;
  public QuadNode topRight;
  public QuadNode bottomLeft;
  public QuadNode bottomRight;

  public QuadNode() {}

  public QuadNode(boolean _val,boolean _isLeaf,QuadNode _topLeft,QuadNode _topRight,QuadNode _bottomLeft,QuadNode _bottomRight) {
    val = _val;
    isLeaf = _isLeaf;
    topLeft = _topLeft;
    topRight = _topRight;
    bottomLeft = _bottomLeft;
    bottomRight = _bottomRight;
  }
}
