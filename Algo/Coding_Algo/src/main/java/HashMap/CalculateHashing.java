package HashMap;

import org.junit.Test;

/**
 * Created by dpandey on 9/4/17.
 */
public class CalculateHashing {

    String strOne = "My first string";
    String strTwo = "My second string";
    String strThree = "My third string";
    String strFour = "My fourth string";
    String strFive = "My fiveth string";
    String strSix = "My fiveth string";
    String strSeven = "My sixth string";

    @Test
    public void testHashCode() {
        System.out.println("strOne hash code--->> "+strOne.hashCode());
        System.out.println("---One---"+ strOne.hashCode() % 15);


        System.out.println("strTwo hash code--->> "+strTwo.hashCode());
        System.out.println("---Two---"+ strTwo.hashCode() % 15);

        System.out.println("strThree hash code--->> "+strThree.hashCode());
        System.out.println("---Three---"+ strThree.hashCode() % 15);


        System.out.println("strFour hash code--->> "+strFour.hashCode());
        System.out.println("---Four---"+ strFour.hashCode() % 15);

        System.out.println("strFive hash code--->> "+strFive.hashCode());
        System.out.println("---Four---"+ strFive.hashCode() % 15);

        System.out.println("strSix hash code--->> "+strSix.hashCode());
        System.out.println("---Six---"+ strSix.hashCode() % 15);


        System.out.println("strSeven hash code--->> "+strSeven.hashCode());
        System.out.println("---Seven---"+ strSix.hashCode() % 15);

    }



}
