package Heap_Priority_Queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Min heap implementation usig shift up technique.
 * https://www.youtube.com/watch?v=LhhRbRXhB40&list=PLs8TmeZHJEeF2UMA8KCI6g0BMDrVUgB0r&index=9
 *
 * Sift down is used to build a heap.
 */
public class Heap_Array_Implementaation {
  ArrayList<Integer> heap = new ArrayList();


  @org.junit.Test
  public void minHeapUsingSiftUP() {
    insert(6);
    insert(7);
    insert(3);
    insert(4);
    insert(6);
    insert(8);
    insert(1);

    // Input array List of { 2,3,1}
//      insert(3);
//      insert(6);
//      insert(7);
      //insert(4);
      //insert(10);
      //insert(5);
      //insert(10);
//      System.out.println(heap);
//
//      while (heap.size() > 0) {
//        siftDown(heap);
//
//      }
  }




  /**
   * Time complexity O(log n)
   */
  public void removal() {

  }

  /**
   *
   * Time complexity is O (log n) it calls internally sift up.
   *
   * Traversing half of the tree.
   *
   * Insert in element to heap.
   *
   * @param value
   */
  public void insert(int value) {
    heap.add(value);
    siftUp(heap);
  }

  //CurrentIdX is the index of the last element in the heap.
  // siftUp is get called from insert. Adding element to last index
  // Building min heap.

  /**
   * sift up O(log n) time | O (1) space
   *
   * Traversing half of the tree.
   *
   * @param heap
   */
  public void siftUp(ArrayList<Integer> heap) {
    int currentIdx = heap.size() - 1;
    // Find parent index of the last index where we added our last element and reheapify the heap.
    // Heap got heapify.
    while (currentIdx > 0) {
      int parentIndex = (currentIdx -1)/2;
      int parent = heap.get(parentIndex);
      int item = heap.get(currentIdx);

      if(parent > item) {
        break;
      }
        swap(currentIdx, parentIndex, heap);
        currentIdx = parentIndex;
    }
  }


  /**
   *  Time complexity for sift Down is O( log n) time | O(1) space
   *
   * @param heap
   */
  public void siftDown(ArrayList<Integer> heap) {
    int currentIdx = 0; // Which is root.
    int leftIndex = 2 * currentIdx + 1;
    //int rightIndex = 2 * currentIdx -1;

    while (currentIdx < heap.size()) {
      int max  = leftIndex;
      int rightIndex = 2 * currentIdx + 2;

      // Check if right index exist.
      if(rightIndex < heap.size()) {
        if (heap.get(rightIndex).compareTo(heap.get(leftIndex)) > 0) {
          max = rightIndex;
        }
      }

      if(heap.get(max).compareTo(heap.get(currentIdx)) > 0) {
        Integer temp = heap.get(currentIdx);
        heap.set(currentIdx, heap.get(max));
        heap.set(max, temp);
      }
      currentIdx =max;
    }

  }

  public void swap(int currentIdx, int parentIndex, ArrayList<Integer> heap) {
    int temp = heap.get(parentIndex);
    heap.set(parentIndex, heap.get(currentIdx));
    heap.set(currentIdx, temp);
  }

  /**
   * Time complexity O n log n)
   *
   * Using sift up operation
   */
  public void buildHeapUsingSitUp () {

  }

  /**
   * Time complexity O (n)
   *
   * Using sift Down operation
   */
  public void buildHeapUsingSitDown() {

  }

}
