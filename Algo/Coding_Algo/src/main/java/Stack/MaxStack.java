package Stack;

import org.junit.Test;

import java.util.Stack;

/*

 https://www.youtube.com/watch?v=0bpDvc2VjPU

  Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5);
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5

 */

/*
     This algo is Is based on Two Stack
     1. Stack is holding all the values.
     2. Second stack is holding all the max values.
     3. Here one thing is importent.
        When we push the element we will push the element in both Stack
        When we pop the element we will pop from both Stack

     4) push(int x)
        When we push for max Stack.
             a) int max = maxStack.peekMAx() check if it is empty return x else return maxStack.peek();
             b) In maxStack push max value. max > x push max else puch x
       When we push for Stack.
        a_ push stack.push(x)

    5  int  pop() : Here we call maxStack.pop() and stack.pop(). Just call pop in both stack and return stack.pop() value.

    6 popMax()
      a) Will take tempBuffer to hold the values from Stack.
      b) Run while loop check if stack.peek() is less then stackMax.peek().
         Add in tempBuffer stack by calling tempBuffer.push(stack.pop());
      c) Now again called pop() // To pop actual matching values from Stack
      d) push bacj tempBuffer to stack using while loop

    7) popMax() --> Reterives the maximum element in the stack and remove it. If you
       find more than one maximum elements only remove the top most one.

    */
public class MaxStack {

  // We will in built Stack.
  Stack <Integer> stack;
  Stack <Integer> maxStack;

  public MaxStack() {
    stack = new Stack();
    maxStack = new Stack();
  }

  public void push(int x) {
    // We need to push in both the Stack ( stack and maxStack)
    // When we push the element in the Stack we need to check if
    // Incoming element is greater then maxStack.peek() element.
    // If it is greater then we will push the same value to maxStack
    // Else we will push to x
    if(maxStack.isEmpty()) {
      maxStack.push(x);
    } else {
      maxStack.push(Math.max(peekMax(), x )); // Push the max value to Stack
    }
    // Push all the incoming value to stack
    stack.push(x);
  }

  public int pop() {
    // When we pop we need to pop() in both Stack (stack, maxStack)
    maxStack.pop();
    return stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return maxStack.peek();
  }

  public int popMax() {
    int max = peekMax();
    // Take the tempBuffer
    Stack<Integer> tempBuffer = new Stack();
    // Call till peekMax is greater then stack.peek()
    while(max > stack.peek()) {
      tempBuffer.push(pop());
    }
    // Call once pop when peekMax is equals stack.peek()
    pop();

    // Push back all the values from tempBuffer to stack.
    while(!tempBuffer.isEmpty()) {
      push(tempBuffer.pop());
    }
    return max;
  }


    @Test
  public void testStack() {
      MaxStack stack = new MaxStack();
      stack.push(5);
      stack.push(5);
      stack.push(1);
      stack.push(1);
       int top = stack.top();
       int max = stack.popMax();
       System.out.println(max);
    }
}


  /** initialize your data structure here. */

    /*
     This algo is Is based on Two Stack
     1. Stack is holding all the values.
     2. Second stack is holding all the max values.
     3. Here one thing is importent.
        When we push the element we will push the element in both Stack
        When we pop the element we will pop from both Stack

     4) push(int x)
        When we push for max Stack.
             a) int max = maxStack.peekMAx() check if it is empty return x else return maxStack.peek();
             b) In maxStack push max value. max > x push max else puch x
       When we push for Stack.
        a_ push stack.push(x)

    5  int  pop() : Here we call maxStack.pop() and stack.pop(). Just call pop in both stack and return stack.pop() value.

    6 popMax()
      a) Will take tempBuffer to hold the values from Stack.
      b) Run while loop check if stack.peek() is less then stackMax.peek().
         Add in tempBuffer stack by calling tempBuffer.push(stack.pop());
      c) Now again called pop() // To pop actual matching values from Stack
      d) push bacj tempBuffer to stack using while loop

    7) popMax() --> Reterives the maximum element in the stack and remove it. If you
       find more than one maximum elements only remove the top most one.

    */



