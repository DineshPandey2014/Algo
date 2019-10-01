package Stack;

import java.util.LinkedList;
import java.util.Queue;


/**
 * https://www.youtube.com/watch?v=Wn45fJKBTTc
 *
 *  This can be omplemented using two queues
 *
 *  // Push all the elements to one queue.
 *  // For popping
 *
 * Implementation of Stack using single queue.
 *
 * 1) Use LinkedList.
 * 2) Add the element in the List.
 * 3) Need to maintained the List whose first element is the last element of the queue.
 * 4) When you add the incoming element. Poll all other element and add in the last.
 */
public class StackImplUsingSingleQueue {

  public static void main(String args[]) {
    MyStack stack = new MyStack();
    stack.push(2);
    stack.push(3);
    stack.push(4);
     int x1 = stack.pop();
     System.out.println(x1);
     int x2 = stack.pop();
    System.out.println(x2);
    int x3 = stack.pop();
    System.out.println(x3);
    //System.out.println(x2);
    //int x3 = stack.pop();
    //System.out.println(x3);

  }

}

class MyStack {
  Queue<Integer> queue;
  /** Initialize your data structure here. */
  public MyStack() {
    queue = new LinkedList();
  }

  /** Push element x onto stack. */

  /**
   *
   * @param x
   */
  public void push(int x) {
    queue.add(x);

    for (int i = 0; i < queue.size() -1; i++) {
      // After adding 3 to the queue which has the element 2 already --> 2, 3
      // queue will poll first element from the queue which is 2 and add that element after 3. ---> 3, 2
      queue.add(queue.poll());
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return queue.poll();
  }

  /** Get the top element. */
  public int top() {
    return queue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }
}