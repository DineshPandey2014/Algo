package BitWise;

/**
 * Created by dpandey on 10/16/17.
 */
public class Is_Number_Is_Odd {
    public static void main(String args[]) {
        System.out.println(isOdd(7));  // Even true
    }

    public static boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}
