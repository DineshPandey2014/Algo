package Tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dpandey on 9/15/17.
 *
 */
public class Traverse_Binary_Tree_Line_By_Line_Using_One_Queue {

    class Node {
        Node leftNode;
        Node rightNode;
        int data;
        Node(int data) {
            this.data = data;
        }
    }

    class MyTree {
        Node root;
        public void treeTraversalLineByLine(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queueParent = new LinkedList<>();
            Queue<Node> queueChild = new LinkedList<>();

            queueParent.add(root);

            while(queueParent.size() > 0) {
             Node tempNode = queueParent.poll();
                queueChild.add(tempNode.leftNode);
                queueChild.add(tempNode.rightNode);

                while(queueChild.size() > 0) {

                }

            }


        }
    }
    @Test
    public void testTraverseTreeLineByLine_Using_OneQueue() {

    }



}
