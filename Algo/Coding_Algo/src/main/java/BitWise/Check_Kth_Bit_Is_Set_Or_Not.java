package BitWise;

/**
 * Created by dpandey on 10/14/17.
 *
 * https://www.youtube.com/results?search_query=how+do+you+check+whether+K-th+bit+is+set+or+not
 *
 */
public class Check_Kth_Bit_Is_Set_Or_Not {

    // 4 ----> 0100
    public static void main(String [] args) {
        System.out.println(isKTh_Bit_Is_Set(0b10001000, 4));
    }

    /**
     * // Number is input binary number. Check if kth bit is set or not.
     *
     * Using bit wise operator. Here if kth bit is setg by taking and with kth bit. It will be greate than 0
     *
     */
    private static boolean isKTh_Bit_Is_Set(int number, int k) {
        System.out.println(1<<k-1);
        System.out.println(number & (0b00001000<<k-1));
        if((number & (1<<k-1)) >0) {
            return true;
        }
        return false;
    }
}
