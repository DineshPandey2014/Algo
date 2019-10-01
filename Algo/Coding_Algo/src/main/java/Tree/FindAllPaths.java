package Tree;

public class FindAllPaths {

    /**
     *                  1
     *
     *           2             3
     *
     *             5       6      7
     *
     *
     *
     *
     *
     *
     *     In order traversal ---> : 10, 15, 17, 20, 25, 28, 30
     *
     *
     *
     */
    public static void main (String args[]) {
        TreeInOrderAllPaths tree = new TreeInOrderAllPaths(1);
        tree.leftNode = new TreeInOrderAllPaths(2);
        tree.rightNode = new TreeInOrderAllPaths(3);

        tree.leftNode.rightNode = new TreeInOrderAllPaths(5);

        tree.rightNode.leftNode = new TreeInOrderAllPaths(6);
        tree.rightNode.rightNode = new TreeInOrderAllPaths(7);

        String str = String.valueOf(tree.data) + " "; //String.valueOf(tree.data);
        finsAllPathsTwo(tree, str);
    }


    public static void finsAllPathsTwo(TreeInOrderAllPaths root, String str) {


        if(root.leftNode == null && root.rightNode == null) {
            System.out.print(str);
            System.out.println();
            return;
        }

        if(root.leftNode != null) {
            finsAllPathsTwo(root.leftNode, str + root.leftNode.data + " ");
        }

        if(root.rightNode != null) {
            finsAllPathsTwo(root.rightNode, str + root.rightNode.data + " ");
        }

    }

    public static void finsAllPaths(TreeInOrderAllPaths root, String str) {

        if(root.leftNode == null && root.rightNode == null) {
            System.out.print(str);
            System.out.println();
            return;
        }

        if(root == null) {
            return;
        }
        finsAllPaths(root.leftNode, str + root.leftNode.data);
        finsAllPaths(root.rightNode, str + root.rightNode.data);

    }
}

class TreeInOrderAllPaths {
    TreeInOrderAllPaths leftNode;
    TreeInOrderAllPaths rightNode;
    int data;

    TreeInOrderAllPaths (int data) {
        this.data = data;
    }
}