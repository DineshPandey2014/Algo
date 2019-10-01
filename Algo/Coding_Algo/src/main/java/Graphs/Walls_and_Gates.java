package Graphs;

/**
 * https://leetcode.com/problems/walls-and-gates/submissions/
 *
 */
public class Walls_and_Gates {
  public void wallsAndGates(int[][] rooms) {
    // Here First we go to cell which is gate means whose value is 0
    // Then we go to his left and right top and bottom
    // We will have exit conditions for matrix
      /*
       1. Row < 0
       2. Row >= rooms.length // As we started index 0. We will use equal to sign.
       3  Column < 0
       4  Column >= rooms[i].length
       5  rooms[i][j] < count // IF the count of the cell is less then the incoming count then don't update
          as we need minimum length of the room from gate.
       6  if the nearinf cell is having value -1 return. Because that is obstacle
           rooms[i][j] == -1
          */
    int count = 0;
    for(int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        // Go to the cell whose value is 0. Which is gate.
        if(rooms[i][j] == 0) {
          dfs(rooms, i, j, count);
        }
      }
    }

  }

  public void dfs(int[][] rooms, int row, int col, int count) {
    if(row < 0 || row>=rooms.length || col < 0 || col >= rooms[row].length || rooms[row] [col] < count || rooms[row] [col] == -1) {
      return;
    }
    rooms[row] [col] = count;
    dfs(rooms, row+1, col, count+1);
    dfs(rooms, row -1, col, count+1);
    dfs(rooms, row, col +1, count+1);
    dfs(rooms, row, col -1, count+1);
  }
}
