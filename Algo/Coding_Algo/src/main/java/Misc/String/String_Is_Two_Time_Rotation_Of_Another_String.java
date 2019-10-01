package Misc.String;

/**
 * Created by dpandey on 10/4/17.
 */
public class String_Is_Two_Time_Rotation_Of_Another_String {
    // Method to check if string2 is obtained by string 1 after n rotation

    static boolean isRotation(String str1, String str2, int n) {

        if(str1 == null || str2 ==null) {
            return false;
        }

        if(str1.length() != str2.length()) {
            return false;
        }

        // Clock wise rotation
        String originalString_ClockWiseRotation = str2.substring(n, str2.length()) +  str2.substring(0, n);

        // Anti clock wise rotation
        String originalString_AntiClockWiseRotation = str2.substring(str2.length() -2, str2.length()) + str2.substring(0, str2.length() -2);

        return str1.equals(originalString_ClockWiseRotation) || str1.equals(originalString_AntiClockWiseRotation);
    }

    // Driver method
    public static void main(String[] args)
    {
        /*
        String str1 = "geeks";
        String str2_clockwise = "ksgee";
        isRotation(str1, str2_clockwise, 2);
        */            //0,1,2,3,4
        String str1 = "geeks";
        //String str3_anticlockwise = "";
        String str2_anticlockwise = "eksge";
        isRotation(str1, str2_anticlockwise, 2);


        //System.out.println(isRotated(str1, str2) ?  "Yes"
         //       : "No");
    }

    /*
    static boolean isRotated(String str1, String str2)
    {
        if (str1.length() != str2.length())
            return false;

        String clock_rot = "";
        String anticlock_rot = "";
        int len = str2.length();

        // Initialize string as anti-clockwise rotation
        anticlock_rot = anticlock_rot +
                str2.substring(len-2, len) +
                str2.substring(0, len-2) ;

        // Initialize string as clock wise rotation
        clock_rot = clock_rot +
                str2.substring(2) +
                str2.substring(0, 2) ;

        // check if any of them is equal to string1
        return (str1.equals(clock_rot) ||
                str1.equals(anticlock_rot));
    }

    // Driver method
    public static void main(String[] args)
    {
        String str1 = "geeks";
        String str2 = "eksge";

        System.out.println(isRotated(str1, str2) ?  "Yes"
                : "No");
    }*/
}
