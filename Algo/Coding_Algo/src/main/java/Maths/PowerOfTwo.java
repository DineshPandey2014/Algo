package Maths;

public class PowerOfTwo {

public static void main(String args[]) {
 boolean powerOfTwo = isPowerOfTwoUsingRecursion(5);
 System.out.println(powerOfTwo);
}

  public static boolean isPowerOfTwoUsingRecursion(int n) {
    if(n < 0 || n == 0) {
      return false;
    }

    // Exit condition
    if(n == 1) {
      return true;
    }

    int y = n%2;

    if(y!= 0) {
      return false;
    }
    n = n/2;
    return isPowerOfTwoUsingRecursion(n) ;

  }

  public boolean isPowerOfTwoWithoutRecursion(int n) {

    if(n == 1) { // 2^0 = 1
      return true;
    }

    long i = 1;
    while(i < n) {
      i = i * 2;   // 2, 2 *2, 2*2*2, 2*2*2*2, 128*2 = 256, 256*2 = 512,
    }

    return i==n;
  }
}
