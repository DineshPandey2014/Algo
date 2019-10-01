package Stack;

/**
 * List implementation of Stack
 */
public class TestStackImpl {

  public static void main(String args[]) {
    TestStack stack = new TestStack();
    int x = stack.pop();
    System.out.println(x);
    //System.out.println(stack.size());
    int y = stack.pop();
    System.out.println(y);
    System.out.println(stack.size());
  }
}

class TestStack {
  Node head;
  int counter = 0;

  // Pop first element
  public int  pop() {
    if(!isEmpty()) {
      int data = head.data;
      head = head.next;
      counter--;
      return data;
    }
    throw new IllegalArgumentException("Stack is not initalized");
  }

  public void push(int data) {
    Node node = new Node(data);
    counter++;

    if(head == null) {
      head = node;
    } else {
      node.next = head;
      head = node;
    }

  }

  public int size() {
    return counter;
  }

  public boolean isEmpty() {
    return size() == 0;
  }
}

class NodeTest {
  Node next;
  int data;
  NodeTest(int data) {
    this.data = data;
  }
}
