package Recursion;


/**
 * https://leetcode.com/problems/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.
 */
public class Word_Search {

  /**
   Here it is saying we can visit the characters once in the path. The same letter cell
   may not be used more the once. Means For example if we start at 0 index we have element A
   Path starts from A be : A -> B-->F--> S---> A Not allowed as we are passing A twice.

   Path starts from B again can visit A only once--> Say B --> A-->S
   [
   ['A','B','C','E'],
   ['S','F','C','S'],
   ['A','D','E','E']
   ]

   1. Once we visited a character we will keep the character in the temp variable
   2. Once we visited all four path in the board. We will have four or Condition for DFS
   travel. (i+1, j) bottom,  (i-1,  j) top , (i, j +1) Left ,  (i , j -1) Right
   3) Increment the count once we have match the characters and Check the length of character
   to the given word. If they matched return true this will be the exit condition
   4) IF any character is not matched with the input character return.
   5) Exit Condition when row < 0 || row >=board.length || col < 0 || col >= board[i].length
   || board[i][j] != word.charAt(count);
   return
   6) Four movevement  in OR contion. Once you find one path as true we will not go to other path
   Move Left
   Move Right
   Move Top
   Move bottom

   7) Else we return false
   */
  public boolean exist(char[][] board, String word) {

    // [["A","B","C","E"],
    //   ["S","F","C","S"],
    //  ["A","D","E","E"]]
    // ABCCED
    for(int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if ((board[i][j] == word.charAt(0)) && dfs(i, j, 0, board, word) ) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean dfs(int i, int j, int count, char [][] board, String word) {
    if(count == word.length()) {
      return true;
    }

    if(i < 0 || i >= board.length || j < 0 || j >= board[i].length  || board[i][j] != word.charAt(count)) {

      return false;
    }

    char temp = board[i][j];
    // Here we are setting the character space. So that after we go to all the paths to its
    // Neighbour we are notn suppose to go the cell which is alread visited.
    board[i][j] = ' ';

    boolean result = dfs (i+1, j, count +1 , board, word)
            || dfs (i - 1, j, count + 1, board, word)
            || dfs (i, j+1, count + 1, board, word)
            || dfs (i , j -1, count + 1, board, word);

    // Once we visited all the paths of (i,j) => (i+1, j) , (i-1,j), (i, j+1), (i, j -1)
    // Then we need to put the temp character back to it's position. As we visited all the paths        // i and j.

    board[i][j] = temp;
    return result;

  }
}
