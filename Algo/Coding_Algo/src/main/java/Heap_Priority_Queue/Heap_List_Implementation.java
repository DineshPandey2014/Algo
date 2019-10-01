package Heap_Priority_Queue;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=hj9lOSJCy-U
 *
 * https://www.youtube.com/watch?v=W81Qzuz4qH0&index=10&list=PLs8TmeZHJEeF2UMA8KCI6g0BMDrVUgB0r
 *
 * # Good algorithm for Heap (Max Heap, Min Heap, Heap Sort)
 *
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html
 *
 * 1. Height if the heap tree for n nodes is O(log n)
 *
 * 2. Insertion O(log n) : The new elements initially appended to the end of the heap as the element of the array.
 *    The heap property is repaired by comparing the added element with its parent and moving the added element
 *    up a level (swapping positions with the parent). Sift up (percolation up) the comparison is repeated
 *    until the parent is larger than or equal to the percolating element.
 *
 * 3. DeleteMin O(log (n) : Minimum element/Max element can be found at the root. Which is the first element in the array. We remove the root
 *      and replace it with the last element of the heap and then restore the heap property by precolating down.
 *      Similar to insertion the worst case run-time is
 *
 *
 * 4. Find max value is constant O(1) time
 *
 * Implementation of Heap :
 *
 * 1. HeapSort:
 *    The algorithm runs in two steps. Given an array of data, first, we build a heap and then turn it into a sorted
 *    list by calling deleteMin. The running time of the algorithm is O(n log n).
 *
 * 2. Priority Queue:
 *    Priority queue are useful for any application that involves processing elements based on some priority. It supports
 *    two major operations insert(object) and deleteMin(). The elements of a priority queue must be comparable to each other
 *    either through the Comparable and Comparator interface.Using a heap to implementat a priority queue we will always
 *    have the element of highest priority in the root node of the heap.
 *
 *
 *
 * @param <T>
 */
public class Heap_List_Implementation <T extends Comparable<T>>{

  private ArrayList<T> items;

  private Heap_List_Implementation() {
    items = new ArrayList<T>();
  }

  public static void main(String [] args) {
    Heap_List_Implementation<Integer> hp = new Heap_List_Implementation<Integer>();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter next int , 'done' to stop: ");
    String line = sc.next();
    while(!line.equals("done")) {
      hp.insert(Integer.parseInt(line));
      System.out.println(hp);
      System.out.println("Enter next int, 'done' to stop: ");
      line = sc.next();
    }

    while(!hp.isEmpty()) {
      int max = hp.delete();
      System.out.println(max + " " + hp);
    }
  }
  /**
   * Here sift up method is get called after inserting the element in the heap to the
   * last element in the ArrayList. And then we do heapify or bubbleup or siftup.
   * This is max heap implementation of heap.
   * When every node of a tree is greater then it's child node.
   */

  private void siftUp() {
    // New element inserted in the list. Now we need to heapify the heap again.
    // Bubble the max element in the heap.

    // K index of the last element in the array.
    int k = items.size() -1;

    while(k > 0) {
      // P is the parent index of the k.
      int p = (k - 1) / 2;

      T item = items.get(k); // Item at index k
      T parent = items.get(p); // Item at index p.

      if (item.compareTo(parent) > 0) {
        // swap
        items.set(k, parent); // if parent is less then then the child
        items.set(p, item);  // If child is greater then the parent

        k = p; // Move k index
      } else {
        break;
      }
    }
  }

  /**
   * Nee item is added at the end of the list and shifted up
   * @param item
   */
  private void insert(T item) {
    items.add(item);
    siftUp();
  }

  private void siftDown() {
    int k = 0; // Sift down from the index 0
    int l = 2*k+1; // left index

    while(l < items.size()) {
      int max = l; // Let say left index value is maximum
      int r = l +1; // Right index is +1 to left index i.e (2*k+1)/2 )
      if(r<items.size()) { // There is a right child
         if(items.get(r).compareTo(items.get(l)) > 0) { // Compare right item with left item
           // Swap
           T temp = items.get(k);
           items.set(k, items.get(max));
           items.set(max, temp);
           k = max;
           l = 2*k+1;
         }
      } else {
        break;
      }
    }
  }

  public T delete() throws NoSuchElementException {
    if(items.size() == 0) {
      throw new NoSuchElementException();
    }

    if(items.size() == 1) {
      return items.remove(0);
    }

    T hold = items.get(0);
    items.set(0, items.remove(items.size() -1));
    siftDown();
    return hold;
  }

  public int size() {
    return items.size();
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

  public String toString() {
    return items.toString();
  }
}
