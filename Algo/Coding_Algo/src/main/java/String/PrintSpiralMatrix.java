package String;

public class PrintSpiralMatrix {

    public static void main (String args[]) {
        char x [] [] = {
                {'X', 'Y'},
                {'M', 'B'},
        };

                /*{
                {'X', 'Y', 'A' },
                {'M', 'B', 'C' },
                {'P', 'Q', 'R' }
        };*/
       String str =  printSpirally(x);
       System.out.println(str);
    }

    static String printSpirally(char[][] matrix) {
        int topRow = 0;
        int bottomRow = matrix.length-1;
        int leftColumn = 0;
        int rightColumn = matrix[0].length-1;
        StringBuffer strBuf = new StringBuffer();

        while(topRow <= bottomRow && leftColumn <= rightColumn) {
            // Print top row.
            for (int i = leftColumn; i <= rightColumn; i++ ) {
                strBuf.append(matrix[topRow][i]);
            }
            topRow++;

            //Print Left Column
            for (int i = topRow; i <= bottomRow; i++) {
                strBuf.append(matrix [i][rightColumn]);
            }
            rightColumn--;

            // Bottom row
            if(topRow <= bottomRow) {
                for (int i=rightColumn; i >= leftColumn; i--) {
                    strBuf.append(matrix[bottomRow][i]);
                }
                bottomRow--;
            }

            //Right Column
            if(leftColumn<=rightColumn) {
                for(int i = bottomRow;  i>= topRow; i--) {
                    strBuf.append(matrix[i][leftColumn]);
                }
                leftColumn++;
            }
        }
        return strBuf.toString();
    }
}
