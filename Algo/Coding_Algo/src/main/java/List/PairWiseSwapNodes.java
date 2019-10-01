package List;
/*
public class PairWiseSwapNodes {

  public static void main (String args[]) {
    LinkedList linkedList = new LinkedList();
    linkedList.add(5);
    linkedList.add(4);
    linkedList.add(3);
    linkedList.add(6);
    linkedList.add(7);
    linkedList.add(8);
    linkedList.reteriveData();

   Node node = linkedList.reverseInGroup(head, 2);
   System.out.println(node);
  }

}

class LinkedList {
  Node head;

  public void add(int  data) {
    Node node = new Node(data);
    if(head == null) {
      head = node;
    } else {
      Node temp = head;
      head = node;
      node.next = temp;
    }
  }

  public void reteriveData() {
    while(head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }

  public  Node reverseInGroup(int k) {
    Node prev = null;
    Node next = null;
    Node node = head;
    int i = 0;

    while(node != null && i < k) {
      next = node.next;
      node.next = prev;
      prev = node;
      node = next;
      i++;
    }

    if(next != null) {
      head.next = reverseInGroup(, k);
    }

    return prev;
  }
}

class Node {
  Node next;
  int data;
  public Node (int data) {
    this.data = data;
  }
}*/