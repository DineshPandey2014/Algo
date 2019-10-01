package String;

public class PrintMatrixInSpiralOrder {

    public static void main(String args[]) {

        char x[][] = {
                {'X', 'Y', 'A'},
                {'M' ,'B', 'C'},
                {'P', 'Q' ,'R'}};
        String outPut = printSpirally(x);
    }


    static String printSpirally(char[][] matrix) {
        StringBuffer str = new StringBuffer();
        int topR = 0;
        int bottomR = matrix.length - 1;
        int leftColumn = 0;
        int rightColumn = matrix.length - 1;
        int dir = 0;
        while (topR <= bottomR && leftColumn <= rightColumn) {
            if (dir == 0) {
                for (int i = leftColumn; leftColumn <= rightColumn; i++) {
                    str.append(matrix[topR][i]);
                    dir = 1;
                    leftColumn++;
                }
                topR++;
            } else if (dir == 1) {
                for (int i = topR; topR <= bottomR; topR++) {
                    str.append(matrix[i][topR]);
                    dir = 2;
                }
                topR--;
            } else if (dir == 2) {
                for (int i = rightColumn; rightColumn <= leftColumn; topR++) {
                    str.append(matrix[bottomR][i]);
                    bottomR--;
                    dir = 3;
                }
            } else if (dir == 3) {
                for (int i = bottomR; bottomR <= topR; topR++) {
                    str.append(matrix[i][leftColumn]);
                    leftColumn++;
                    dir = 0;
                }

            }

        }
        return str.toString();
    }

}