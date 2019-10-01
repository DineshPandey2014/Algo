package Queue;

public class Queue_Impl_Using_Array_Implementation {

  public static void main(String args[]) {
    Queue_Array_Impl qai = new Queue_Array_Impl();
    int number [] = new int [3];
    qai.enqueue(number, 3);
    qai.enqueue(number, 4);
    qai.enqueue(number, 5);
    qai.dequeue(number);
    qai.dequeue(number);
    qai.dequeue(number);
  }

}

class Queue_Array_Impl {
  // Both are pointing to index 0
  int front = 0;
  int rear = 0;

  public void enqueue(int []num, int data) {
    if(rear == num.length) {
      System.out.println("Queue is full. Overflow");
    }
    num[rear] = data;
    rear++;
  }

  public int dequeue(int []num) {
      if(front == rear) {
         throw new ArrayIndexOutOfBoundsException(front);
      }
      int data = num[front];
      front++;
      System.out.println("Dequeue data-->  "+ data);
      return data;
  }

  public int getfront(int []num) {
    return num[front];
  }

  public int getSize(int []num) {
    return rear -front;
  }

  public boolean isEmpty() {
    return front == rear;
  }
}
