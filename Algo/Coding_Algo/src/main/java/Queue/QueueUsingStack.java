package Queue;

import java.util.Stack;

public class QueueUsingStack {

  public static void main(String args[]) {
    ImplementQueueUsingTwoStack implementQueueUsingTwoStack = new ImplementQueueUsingTwoStack();
    implementQueueUsingTwoStack.push(1);
    implementQueueUsingTwoStack.push(2);
    System.out.println("Peek operation: "+ implementQueueUsingTwoStack.peek());
    System.out.println("POP : "+  implementQueueUsingTwoStack.pop());
    implementQueueUsingTwoStack.push(3);
    implementQueueUsingTwoStack.push(4);
    System.out.println("POP : "+  implementQueueUsingTwoStack.pop());
    System.out.println("POP : "+  implementQueueUsingTwoStack.pop());
    implementQueueUsingTwoStack.push(5);
    implementQueueUsingTwoStack.push(6);
    System.out.println("Is Empty  " + implementQueueUsingTwoStack.empty());
  }
}


class ImplementQueueUsingTwoStack {

  Stack<Integer> stackEnQueue;
  Stack<Integer> stackDeQueue;

  /** Initialize your data structure here. */
  public ImplementQueueUsingTwoStack() {
    stackEnQueue = new Stack();
    stackDeQueue = new Stack();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    stackEnQueue.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if(empty()) {
      return Integer.MAX_VALUE;
    }
      // Push to stackDeQueue stack only when stackDeQueue is having zero size.
      // First pop from rest of the element.
    if(stackDeQueue.size() == 0) {
      while(stackEnQueue.size() != 0) {
        stackDeQueue.push(stackEnQueue.pop());
      }
    }
    return stackDeQueue.pop();
  }

  /** Get the front element. */
  public int peek() {
    if(empty()) {
      return Integer.MAX_VALUE;
    }

    if(stackDeQueue.size() == 0) {
      while(stackEnQueue.size() != 0) {
        stackDeQueue.push(stackEnQueue.pop());
      }
    }
    return stackDeQueue.peek();
  }

  /** Returns whether the queue is empty. */
  // When both stack is empty.
  public boolean empty() {
    return stackEnQueue.size() + stackDeQueue.size() == 0 ? true : false;
  }

}