package BitWise;

/**
 * Created by dpandey on 10/16/17.
 */
public class Toggle_Kth_Bit {

    public static void main(String args[]) {
        // 12 --> 8 + 4 --> 1100 --> (After toggling third bit 1000 ---> It will become 8)
        int x = toggle_Kth_Bit(12,3);
        System.out.println(x);

        // 8 --> 8  --> 1000 --> (After toggling third bit 1100 ---> It will become 12)
        int y = toggle_Kth_Bit(8,3);
        System.out.println(y);

    }

    public static int toggle_Kth_Bit(int number, int kth_bit) {
        return (number ^ (1<< kth_bit -1));
    }

}
