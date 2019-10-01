package Misc.Tree;

/**
 * Created by dpandey on 9/21/17.
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Approach:
 * Using Level order traversal.
 *
 * 1. Here we will use NULL as a marker at every level. So when ever we encounter null, we will increment
 *    hte height by 1.
 * 2. First add root to the queue and NULL as well as it's marker.
 * 3. Extract a node from the queue.
 * 4. Check if it is NULL, It means either we have reached to the end of a level or entire Tree is traversed.
 * 5. So before adding null as marker for the next level, check if queue is empty, which means we have trav­eled all
 *    the lev­els and if not empty then add NULL as marker and increase the height by 1.
 * 6. If Extracted node in Step 6, is NOT NULL add the chil­dren of extracted node to the Queue.
 * 7. Repeat Steps from 5 to 8 until Queue is Empty.
 *
 *  Source: http://algorithms.tutorialhorizon.com/find-the-height-of-a-tree-without-recursion/
 *
 */
public class HeightOfTree_Without_Recursion {

    class Node {
        Node left;
        Node right;
        int data;
        Node (int data) {
            this.data = data;
        }
    }

    public int getHeightOfTreeWithoutRecursionUsing_LevelOrder_Traversal(Node root) {
        Queue<Node> queueNode = new LinkedList<>();
        queueNode.add(root);
        int height = 0;

        // Add null as marker.
        queueNode.add(null);
        Node nodeOne = queueNode.peek();
        while (queueNode.size() >=1 && nodeOne !=null ) {
            Node node  = queueNode.poll();

            if(node == null) {
                if(!queueNode.isEmpty()) {
                    queueNode.add(null);
                }
                height++;
            } else {
                if(node.left != null) {
                    queueNode.add(node.left);
                }

                if(node.right != null) {
                    queueNode.add(node.right);
                }
            }
        }

        return height;
    }

    @Test
    public void testFindHeightOfNode_Without_Recursion() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(8);

        HeightOfTree_Without_Recursion heightOfTree_without_recursion = new HeightOfTree_Without_Recursion();
        int height = heightOfTree_without_recursion.getHeightOfTreeWithoutRecursionUsing_LevelOrder_Traversal(root);
        System.out.println("---height---"+height);

    }
}
