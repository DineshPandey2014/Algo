package Heap_Priority_Queue;

public class MaxHeap_Test {
  int heap [];
  int size;
  public MaxHeap_Test(int heapSize) {
    heap = new int[heapSize];
    size = 0;
  }

  public static void main(String args[]) {
    // 6,7,3,4,6,0,1
    MaxHeap_Array_Implementation heap = new MaxHeap_Array_Implementation(7);
    heap.siftUp(6);
    heap.siftUp(7);
    heap.siftUp(3);
    heap.siftUp(4);
    heap.siftUp(6);
    heap.siftUp(0);
    heap.siftUp(1);
    System.out.println(heap.size);

    int outputOne = heap.siftDown();
    System.out.println(outputOne);
    int outputTwo = heap.siftDown();
    System.out.println(outputTwo);
  }


  // Bubble Up operation
  public void siftUp(int value) {
    if(size == heap.length) {
      throw new IllegalArgumentException();
    }
    int pos = size;
    heap[size] = value;

    while(pos > 0) {
      int parent = (pos -1)/2;
      if(heap[parent] > heap[pos]) {
        break;
      }
      // When parent is less then the element at position
      swapIndices(pos, parent);
      pos = parent;
    }
    // Add element at next index
    size++;

  }

  // Bubble Down;
  public int siftDown() {
    int toReturn = heap[0];
    heap[0] = heap[size-1];

    int pos = 0;
    // Re heapify after moving last element at the fist position
    while (pos < size/2) {
      // Left Child
      int leftChild =  2 * pos + 1;

      // Find right child
      int rightChild = leftChild +1;

      if(rightChild < size && heap[leftChild] < heap[rightChild]) {
        if(heap[pos] > heap[rightChild]) {
          break;
        }
        swapIndices(pos, rightChild);
        pos = rightChild;
      } else {
        if(heap[pos] > heap[leftChild]) {
          break;
        }
        swapIndices(pos, leftChild);
        pos = leftChild;
      }
      // Find left child
    }
    // Size will deccrement when the one element reached it's correct postion.
    size--;
    return toReturn;

  }

  public void swapIndices(int pos, int parent) {
    int temp = heap[pos];
    heap[pos] = heap[parent];
    heap[parent] = pos;
  }

}
