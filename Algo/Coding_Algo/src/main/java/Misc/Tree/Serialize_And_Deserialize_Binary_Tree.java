package Misc.Tree;

import org.junit.Test;

import javax.swing.tree.TreeNode;

/**
 * Created by dpandey on 11/6/17.
 *
 * https://www.youtube.com/watch?v=jwzo6IsMAFQ
 *
 */
public class Serialize_And_Deserialize_Binary_Tree {

    //StringBuffer strBuf = new StringBuffer();

    @Test
    public void testSerialize() {
        // 7,3,5,null,null,8
        /*
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.left.left = null;
        root.left.left.right = null;
        System.out.println("----root--"+serialize(root));
        */

        /*
        // -1,0,1
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        //System.out.println("----root--"+serialize(root));
        String str = serialize(root);
        TreeNode node = deserialize(str.split(","));
        System.out.println(node);
        */

        // [1,2]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println("----root--"+serialize(root));
        String str = serialize(root);
        str = "1,2";
        TreeNode node = deserialize(str.split(","));

    }

    StringBuffer strBuf = new StringBuffer();
    public String serialize(TreeNode root) {
        if(root == null) {
            strBuf.append("X"); // Denote null
            strBuf.append(",");
            return null;
        }

        int val = root.val;
        strBuf.append(val);
        strBuf.append(",");
        serialize(root.left);
        serialize(root.right);
        return strBuf.toString();
    }

    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data[]) {
        if(data !=null && data.length > 0) {
            if(data[index].equalsIgnoreCase("X")) {
                index = index+1;
                return null;
            }

            TreeNode node  = new TreeNode(Integer.parseInt(data[index]));
            index = index + 1;
            node.left = deserialize(data);
            node.right = deserialize(data);
            return node;

        }
        return null;
    }

    /*
    public String serialize(TreeNode root) {

        if(root == null) {
            strBuf.append("X");
            return null;
        }

        int val = root.val;
        strBuf.append(val);
        serialize(root.left);
        serialize(root.right);
        return strBuf.toString();
    }
    */


     public class TreeNode {
              int val;
              TreeNode left;
              TreeNode right;
           TreeNode(int x) { val = x; }
        }

}



/* Leet Code Performance Issues

public class Codec {
    StringBuilder strBuf = new StringBuilder();
    public String serialize(TreeNode root) {
        if(root == null) {
            strBuf.append("X"); // Denote null
            strBuf.append(",");
            return null;
        }

        int val = root.val;
        strBuf.append(val);
        strBuf.append(",");
        serialize(root.left);
        serialize(root.right);
        return strBuf.toString();
    }

    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String dataone) {

        if(dataone !=null && dataone.length() > 0) {
           String data  [] = dataone.split(",");
            if(data[index].equalsIgnoreCase("X")) {
                index = index+1;
                return null;
            }

            TreeNode node  = new TreeNode(Integer.parseInt(data[index]));
            index = index + 1;
            node.left = deserialize(dataone);
            node.right = deserialize(dataone);
            return node;

        }
        return null;
    }
}

 */