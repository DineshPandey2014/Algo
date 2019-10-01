package Misc.List;

import org.junit.Test;

import java.util.HashSet;

/**
 * Created by dpandey on 9/14/17.
 *
 * https://www.youtube.com/watch?v=SmnUqWmWvz0&index=39&list=PLNmW52ef0uwsjnM06LweaYEZr-wjPKBnj
 */
public class CycleInList {

    class Node {
        int data;
        Node nextNode;

        Node(int data) {
            this.data = data;
        }
    }

    class MyLinkedListOne {
        Node head;
        Node tail;

      public void addNode(Node node) {
           if(head == null) {
               head = node;
               tail = node;
           } else {
               tail.nextNode = node;
               tail = node;
           }
       }
    }


    @Test
   public void testCyclic () {
        MyLinkedListOne myList = new MyLinkedListOne();

        Node nodeOne = new Node(4);
        myList.addNode(nodeOne);

        Node nodeTwo = new Node(5);
        myList.addNode(nodeTwo);

        Node nodeThree = new Node(6);
        myList.addNode(nodeThree);

        Node nodeFour = new Node(7);
        myList.addNode(nodeFour);

        Node nodeFive = nodeTwo;
        myList.addNode(nodeFive);

       // boolean  isCyclic = isCyclicUsingHashSet(myList.head);
       // System.out.println("----isCyclic---"+isCyclic);

        boolean isCyclicUsingTwoPointer = usingFastSlowPointer(myList.head);
        System.out.println("----isCyclicUsingTwoPointer---"+isCyclicUsingTwoPointer);

    }

    /**
     * Testing cyclic using HashSet.
     *
     * @param node
     * @return
     */
    boolean isCyclicUsingHashSet(Node node) {
        HashSet<Node> hashSet = new HashSet<>();
        while(node !=null) {
            if(hashSet.contains(node)) {
                return true;
            } else {
                hashSet.add(node);
            }
            node = node.nextNode;
        }
        return false;
    }

    /*
     * Test if list is having cyclic or not.
     * Here we are using two pointer one is slow and other is fast.
     * Slow will move one step.
     * Fast will move two step.
     */
     boolean usingFastSlowPointer(Node node) {
         Node slow = node;
         Node fast = node.nextNode;

         while(node !=null ) {
             if(slow == fast) {
                return true;
             }
             slow = slow.nextNode;
             fast = fast.nextNode.nextNode;
         }
         return false;
     }
}
