package BitWise;

/**
 * Created by dpandey on 10/15/17.
 *
 * Unset kth bit means.
 *
 * 1) if it is 0 it will remain as 0
 * 2) If it is 1 make it 0.
 */
public class UnSet_Kth_Bit {

    public static void main(String args[]) {
        // 12 --> 8 + 4 --> 1100 --> (After unsetting third bit 1000 ---> It will become 8)
        //System.out.println(8 ^ (1<<2));
        System.out.println(-12 ^ (1<<2)); // Using Exclusive or operator. (0^1) ---> 1 and  (1^1) ---> 0

        int x = unset_kth_bit(-12,3);
        System.out.println(x);
    }

    public static int unset_kth_bit(int number, int kth_bit) {
       return (number & ( ~ (1<<kth_bit-1)));
    }
}
