package List;

/**
 * Created by dpandey on 8/26/17.
 *
 * // Linked List you tube video
 *
 * https://www.youtube.com/watch?v=VR363sIAvr4
 *
 *  List is good for Insertion and Deletion not for access the data.
 *
 */


public class MyLinkedList<T> {

    Node<T> head;
    Node<T> tail;


    public void add(T data) {
        Node<T> node = new Node<T>(data, null);

        // If linked list is empty.
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.nextNode = node;
            tail = node;
        }
    }

    public T get(T  inputData) {
        if(head.getElement() == inputData) {
            return head.getElement();
        } else {
            Node<T> currentNode = head.getNextNode();
            while(currentNode.getNextNode() != null ) {
                if(currentNode.getElement() == inputData) {
                    return currentNode.getElement();
                }
            }

            if(currentNode.getElement() == inputData) {
                return currentNode.getElement();
            }
        }
        return null;
    }

    public void remove(T inputData) {
        if(head.getElement() == inputData) {
            head = head.getNextNode();
        } else {
            Node<T> current = head;
            Node<T> next = head.nextNode;

            while(next != null) {
                if(next.getElement().equals(inputData)) {
                    current.setNextNode(next.getNextNode());
                }
                if(next.getNextNode() == null) {
                    tail = current;
                }

                current = next;
                next = next.getNextNode();
            }
        }

    }

    public void displayNode() {
        Node node = head;
        while(node !=null) {
            System.out.println(node.getElement());
            node = node.nextNode;
        }
    }
}



/*
public class MyLinkedList {

    // Keeping the head reference
    Node head;

    // Keeping the tail reference
    Node tail;

    int counter;

    // Adding data in the list. Internal implementation of node is hidden inside this method. For user it is
    // data needs to be added
    public void (int data) {
        // There will be two type of scenario
        // Scenario 1. : Empty linked list.
        // Scenarion 2. : Non empty linked list addNode(10) --> [Node(15) ---> Node(16)]

        // First time when there is no node.
        Node node = new Node(data);
        if (tail == null && head == null) {
            head = node;
            tail = node;
        } else {
            //Adding to new node
            tail.nextNode = node;
            tail = node;
        }
        counter++;
    }

    // Delete data in the linked list. Internally it means delete node which have the input data.
    public void deleteNode(int data) {

    }

    // Find node based on data. Internally it means find node for the inptu data.
    public Node findNode(int data) {
        //Empty linked list. There is no node attached.
        if(head == null) {
            return null;
        }

        if(head.data == data) {
            return head;
        }

        Node node = head;
        while(node.nextNode != null) {
            if(node.data == data) {
                return node;
            }
            node = node.nextNode;
        }
        return null;
    }

    public void insertNodeBetween() {
        displayNode();
    }

    public void displayNode() {
        Node node = head;
        while(node !=null) {
            System.out.println(node.data);
            node = node.nextNode;
        }
    }

    public  int lengthOfList() {
        return counter;
    }

}*/

