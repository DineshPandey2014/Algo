package BitWise;

/**
 * Created by dpandey on 11/26/17.
 *
 * Time complexity is O(1)
 * Space Complexity is O(1)
 *
 * Using bitwise operator.
 */
public class Number_Of_1_Bits {

    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1; // for 32 bit there will be 31 zeros in left side.
        for (int i = 1; i < 32; i++) {
            if( ( n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }

        return count;
    }
}
