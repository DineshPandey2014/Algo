package Heap_Priority_Queue;


/**
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA&list=PLUL4IRMCZfeXjd5AzDyry39Mf_pn1YLjQ
 *
 * #Good algorithm
 * https://www.youtube.com/watch?v=GubgNdSYdZg
 *
 * Implement PriorityQueue means SiftUP and SiftDown, Max heap implementation
 *
 */
public class MaxHeap_Array_Implementation {

  int heap[];
  int size;

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


  public MaxHeap_Array_Implementation(int maxSize) {
    heap = new int [maxSize]; // Size of the PQ
    size = 0; //heap.length -1;
  }

  // Bubble Up
   public void siftUp(int value) {
      if(size == heap.length)
        throw new IllegalArgumentException();

      // Insert to the last available position
      int pos = size;

      heap[pos] = value;

      while (pos > 0) {
          int parent = (pos - 1)/2;
          // When parent is greater then or equal position element. Don't do any thing
           // Just break.
          if(heap[parent] >= heap[pos]) {
              break;
          }

          // If parent is not greater then the element at position swap. Means highr element
          // Will get up.
          swapIndices(pos, parent);
          pos =parent;
      }
      size++;
   }

   // Bubble Down
   public int  siftDown() {
     // Max value that will return
     int toReturn = heap[0];

     // Moved last value to the begning value.
     heap[0] = heap[size-1];
     int pos = 0;

     // Maximum child which can have parent is size/2
     while (pos < size/2) {
        int leftChild = 2 * pos + 1;
        int rightChild = leftChild + 1;

       /**
        * Is it possible node can have left child but not right child.
        */

       if(rightChild < size && heap[leftChild] < heap[rightChild]) {
         if(heap[pos] >= heap[rightChild]) {
           break;
         }
         swapIndices(pos, rightChild);
         pos = rightChild;
        } else {
         if(heap[pos] >= heap[leftChild]) {
           break;
         }
         swapIndices(pos, leftChild);
         pos = leftChild;
       }
     }
      size --;
     return toReturn;
   }


   public void swapIndices(int pos, int parentIndex) {
      int temp = heap[pos];
      heap[pos] = heap[parentIndex];
      heap[parentIndex] = temp;
   }
}
