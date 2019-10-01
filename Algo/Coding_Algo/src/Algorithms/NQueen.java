

// N Queen Problem

static String [][] find_all_arangements(int n) {

	int input [10][10]= {0};
	solveNQueen(input,  0, n);
	
}


boolean solveNQueen(input[][],int i, int n) {
	
	//Base case.
	if(i == n) {
	   // You have successfully place queens in a rows ( o.. n-1)
	   // Print the board.
	   for (int i = 0; i < n; i++) {
	       for(int j = 0; j<n; j++) {
	       	   if(board[i][j] == 1) {
	       	      System.out.print (" Q ");
	       	   } else {
	       	      System.out.print (" - ");
	       	   }
	       }
	       System.out.println();
	   }
	}
	
	// Recursive case
	// Try to place the queen in the current row and call in the remaining part which 
	// will be solve by recursion.
	
	// Moving in the  first row
	for(int j = 0; j<n; j++) {
		
		if(isSafe(input, i, j, n)) {
		   // place the queen assuming i and j is the right postion
		   board[i][j] = 1;
		   
		   bool nextQueen = solveNQueen (board, i+1, n);
		   if(nextQueen) {
		   	return true;
		}
		// Means i and j is not the right position.
		board[i][j] = 0; // Backtrack
	}
	// You have tried all postions in the current row but couldn't place the queen.
	return false;
}

/**
 * Takes the input array of chess board.
   1) Takes the input start of row.
   2) No of rows
   
   i represent row // startindex from 0
   j represent column // start index from 0
   n represent size of board. 
   Max i can go up to n-1
   Max j can go up to  n-1
   
 *
 */
boolean isSafe(int input [][],int i, int j, int n) {
	
	// Can we keep the queen in the column. Column check
	// If you move column back then row will get reduce and row should be greater then or equal to zero
	
	 int x = i;
	 int y = j;
	 
	// Check if queen is attacked in the column
	while(x >=0)  {
	  if(input[x][y] == 1) {
	    return false
	   }
	   x--;
    }
    
    x = i;
    y = j;
    //Check if queen is attacked in the left diagnol
    
    while(int x >=0 && y>=0) {
    	if(input[x][y] == 1) {
	    return false
	   }
	   x--;
	   y--;
    }
    
    x = i;
    y = j;
    while(x>=0 && y < n) {
    	if(input[x][y] == 1) {
	    return false
	   }
	   x--;
	   y++;
    }
    return true;
}