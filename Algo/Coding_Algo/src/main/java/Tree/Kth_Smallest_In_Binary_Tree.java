package Tree;

import java.util.ArrayList;
import java.util.List;

public class Kth_Smallest_In_Binary_Tree {

    /**
     *                  20
     *
     *           15              28
     *
     *      10       17       25      30
     *
     *
     *     In order traversal ---> : 10, 15, 17, 20, 25, 28, 30
     *
     *
     *
     */


    public static void main (String args[]) {
        InOrderTreer tree = new InOrderTreer(20);
        tree.leftNode = new InOrderTreer(15);
        tree.rightNode = new InOrderTreer(28);

        tree.leftNode.leftNode = new InOrderTreer(10);
        tree.leftNode.rightNode = new InOrderTreer(17);

        tree.rightNode.leftNode = new InOrderTreer(25);
        tree.rightNode.rightNode = new InOrderTreer(30);
        int k = 7;
        List<Integer> list = new ArrayList<>();

        inOrderTraversal( tree, list);
        System.out.println(list.get(k-1));
//        int k = 4;
//        int x [] = new int[2];
//
//        boolean bol [] = {false};
//
//        x[0] = k;
//         // Second smallest element
//        inOrderTraversal_Kth_Smallest(tree, x, bol);

       // System.out.println(x[1]);
    }

    public static void inOrderTraversal(InOrderTreer node, List<Integer> list) {

        if(node == null) {
            return;
        }

        if(node.leftNode != null) {
            inOrderTraversal(node.leftNode, list);
        }

        list.add(node.data);

        if(node.rightNode != null) {
            inOrderTraversal(node.rightNode, list);
        }

    }


    public static  void inOrderTraversal_Kth_Smallest (InOrderTreer node, int x [], boolean bol []) {

        if(node == null) {
            return;
        }

        if(bol[0] == false) {
            inOrderTraversal_Kth_Smallest(node.leftNode, x, bol);
        }

        int j = x[0];

        if(j != 1 && bol[0] == false) {
           x[0] = --j;
        } else if( j == 1 && bol[0] == false) {
            x[1] = node.data;
            bol[0] = true;

        }
        //System.out.println(node.data);
        if(bol[0] == false) {
            inOrderTraversal_Kth_Smallest(node.rightNode, x, bol);
        }
    }

}


class InOrderTreer {
    InOrderTreer leftNode;
    InOrderTreer rightNode;
    int data;

    InOrderTreer (int data) {
        this.data = data;
    }
}