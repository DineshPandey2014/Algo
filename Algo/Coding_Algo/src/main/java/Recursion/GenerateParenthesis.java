package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=pD2VNU2x8w8&t=27s
 */

public class GenerateParenthesis {

    public static void main(String args[]) {

        String pair = "";
        List<String> list = new ArrayList();
        int n = 2;
        findAllBraces(n, 0, 0, list, pair);

        for(String str : list) {
            System.out.println("---output--"+ str);
        }
    }


    public static void findAllBraces(int n, int leftBraceCount, int rightBraceCount, List<String> list, String pair) {

        if (leftBraceCount == n && n ==rightBraceCount) {
            list.add(pair);
            return;
        }

        if (leftBraceCount < n) {
            findAllBraces(n, leftBraceCount + 1, rightBraceCount, list, pair + "(");
        }

        if (rightBraceCount < n && rightBraceCount < leftBraceCount) {
            findAllBraces(n, leftBraceCount, rightBraceCount + 1, list, pair + ")");
        }
    }

}