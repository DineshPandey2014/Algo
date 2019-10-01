package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class MergeTwoBST {

    public static void main(String args[]) {

        //4 # 80 50 18 6 5 # # 13 # # 32 28 23 22 # # 25 # # # 41 # # 66 53 52 # # 58 # # # 84 82 # # #

        //69 18 12 # 16 # # 66 53 30 27 # # 37 # # 62 58 # # # # 95 73 # # #

        //Node one  = new Node(72);
       // Node two  = new Node(62);

        //mergeTrees(one, two);
        String dataOne = "4 # 80 50 18 6 5 # # 13 # # 32 28 23 22 # # 25 # # # 41 # # 66 53 52 # # 58 # # # 84 82 # # # ";
        String dataTwo = "69 18 12 # 16 # # 66 53 30 27 # # 37 # # 62 58 # # # # 95 73 # # #";
        Node nodeOne = createTree(dataOne);
        Node nodeTwo = createTree(dataTwo);
       Node node = mergeTrees(nodeOne, nodeTwo);
       System.out.println(node);
    }

    static Node createTree(String data) {
        if (data == null || data.length() == 0) return null;
        StringTokenizer st = new StringTokenizer(data, " ");
        return deserialize(st);
    }

    static Node deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens())
            return null;
        String s = st.nextToken();
        if (s.equals("#"))
            return null;
        Node root = new Node(Integer.valueOf(s));
        root.left = deserialize(st);
        root.right = deserialize(st);

        return root;
    }

    static Node mergeTrees(Node n1, Node n2) {
        List<Integer> listOne = new ArrayList<>();
        inOrderTraversal(n1, listOne);


        List<Integer> listTwo = new ArrayList<>();
        inOrderTraversal(n2, listTwo);

        List<Integer> listThree = new ArrayList<>();

        mergeTwoList(listOne, listTwo, listThree);

        int end_list = listThree.size() -1;
        return buildBST(listThree, 0, end_list);

    }


    public static void mergeTwoList(List<Integer> listOne, List<Integer> listTwo, List<Integer> listThree) {
        int l1 = listOne.size();
        int l2 = listTwo.size();
        int i = 0;
        int j = 0;

        while(i < l1 && j < l2) {
            int valOne = listOne.get(i);
            int valTwo = listTwo.get(j);

            if(valOne <= valTwo) {
                listThree.add(listOne.get(i));
                i++;
            } else {
                listThree.add(listTwo.get(j));
                j++;
            }
        }

        while( i < l1 ) {
            int valOne = listOne.get(i);
            listThree.add(listOne.get(i));
            i++;
        }

        while(j < l2) {
            int valTwo = listTwo.get(j);
            listThree.add(listTwo.get(j));
            j++;
        }

    }

    public static void inOrderTraversal(Node n1, List<Integer> list) {
        if(n1 == null) {
            return;
        }

        inOrderTraversal(n1.left,list);
        list.add(n1.val);
        inOrderTraversal(n1.right,list);

    }

    public static Node buildBST(List<Integer> list, int start, int end) {
        int mid = (start + end)/2;
        if(start > end) {
            return null;
        }


        Node node = new Node(list.get(mid));

        node.left = buildBST(list, start, mid-1);
        node.right = buildBST(list, mid + 1, end);
        return node;
    }


}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int value) {
        this.val = value;
    }
}

/*
public class MergeTwoBST {

    public static void main (String args[]) {

        List<Integer> listOne = new ArrayList<>();
        listOne.add(2);
        listOne.add(5);
        listOne.add(8);
        listOne.add(12);


        List<Integer> listTwo = new ArrayList<>();
        listTwo.add(2);
        listTwo.add(4);
        listTwo.add(9);
        listTwo.add(22);

        List<Integer> listThree = new ArrayList<>();

        mergeTwoList(listOne, listTwo, listThree);
    }

    public static void mergeTwoList(List<Integer> listOne, List<Integer> listTwo, List<Integer> listThree) {

        int l1 = listOne.size();
        int l2 = listTwo.size();
        int i = 0;
        int j = 0;

        while(i < l1 && j < l2) {
            if(listOne.get(i) <= listTwo.get(j)) {
                listThree.add(listOne.get(i));
                i++;
            } else {
                listThree.add(listTwo.get(j));
                j++;
            }
        }

        while( i < l1 ) {
            listThree.add(listOne.get(i));
            i++;
        }

        while(j < l2) {
            listThree.add(listTwo.get(j));
            j++;
        }

    }

    public void inOrderTraversal(Node n1, List<Integer> list) {
        if(n1 == null) {
            return;
        }

        inOrderTraversal(n1.left,list);
        list.add(n1.val);
        inOrderTraversal(n1.right,list);

    }

}
*/
