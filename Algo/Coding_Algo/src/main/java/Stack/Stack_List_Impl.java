package Stack;

import org.junit.jupiter.api.Test;

/*
 * List implementation of Stack.
 * Stack is LIFO (Last In First Out Implementation)
 * https://www.youtube.com/watch?v=wjI1WNcIntg
 *
 */

 class StackListImpl {

  public Node top;

  // Pushes
  public void push(int data) {
    Node node = new Node(data);
    // If top is not null
    if(top !=null) {
      node.next = top;
      top = node;
    } else {
      // This is the case when top is null. Then top will point to node.
      top = node;
    }
  }

  // Pop the first element. And removes the element from Stack
  public int pop() throws NullPointerException{
       int data = top.data;
      top = top.next;
      System.out.println(data);
      return data;
  }

  // Check is Stack is empty
  public boolean isEmpty() {
    if(top == null) {
      return true;
    }
    return false;
  }

  // Gives you top element
  public int peek() {
    return top.data;
  }
}

class Node {
  Node next;
  int data;
  public Node(int data) {
    this.data = data;
  }
}