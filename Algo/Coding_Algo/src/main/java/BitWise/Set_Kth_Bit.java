package BitWise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpandey on 10/15/17.
 *
 *  Statement:
 *   Given a bit sequence x, set the kth bit; where the zeroth (0th) bit is
 *   the least significant (rightmost) bit.
 *
 * Sample Input:  0010010010
 * Sample Output: 0010010011
 *
 */
public class Set_Kth_Bit {

    public static void main(String args[]) {
        // 00000000 ---> 00000011 ---> 2  ---> 2
        int y = setKthBit(0b00000010, 3); //---> 1*4 + 1*2 + 0 --> 6
        System.out.println(y);
        /*
        List<Integer> lst = new ArrayList<>();

        while(y > 1) {
            int remainder = y % 2;
            lst.add(remainder);
            y = y/2;
        }
        if( y == 1) {
            lst.add(1);
        }
        System.out.println(lst);

        for(int x = lst.size()-1; x >=0; x--) {
            System.out.print(lst.get(x));
        }
*/
    }

    /**
     *  To set Kth bit we will use bit wise or operator (|)
     *
     */
    private static int setKthBit(int number, int kbit) {
        return number | (1 << kbit - 1);
    }
}
