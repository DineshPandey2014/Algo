package Heap_Priority_Queue;

public class GivenArray_Check_If_It_Is_Heap {

  public static void main(String args[]) {
    int input [] = {25, 14, 16, 13, 10, 8, 12};
    System.out.println(isMaxHeap(input));
    System.out.println(isMinHeap(input));
  }

 static boolean isMaxHeap(int [] input) {
    for (int i = 0;  i < input.length; i++) {
      int k = i;
      int leftChild = 2*k+1;
      int rightChild = 2*k+2;

      if(leftChild <=input.length -1 && rightChild <=input.length -1 && (input[i] < input[leftChild]
              || input[i] < input[rightChild]) ) {
        return false;
      }
    }
    return true;
 }

  static boolean isMinHeap(int [] input) {
    for (int i = 0;  i < input.length; i++) {
      int k = i;
      int leftChild = 2*k+1;
      int rightChild = 2*k+2;

      if(leftChild <=input.length -1 && rightChild <=input.length -1 && (input[i] > input[leftChild]
              || input[i] > input[rightChild]) ) {
        return false;
      }
    }
    return true;
  }

}
