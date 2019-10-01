package RandomNumber;

import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class GenerateRandomNumber {


    public static void main(String args[]) {
        /*
        for(int i = 0;i< 10;  i++ ) {
            String x = getRandomWholeNumber(1, 10);
            System.out.println(x);
        }*/


        for(int i = 0;i< 10;  i++ ) {
            double x = getDecimalNumber(1, 10);
            System.out.println(x);
        }
        /*
        double dob = 0.6862635330955831;
        decimalFormat(dob);
        */
    }

    public static String getRandomWholeNumber(int min, int max) {
        Random random = new Random();
        int range = max - min + 1;
        int randomNumber = random.nextInt(range) + min;
        return String.valueOf(randomNumber);
    }


    public static double getDecimalNumber(int min, int max) {
        Random random = new Random();
        int range = max - min;
       // double randomNumber = random.nextDouble() * max + min;
        double randomNumber = random.nextDouble() * range + min;
        return randomNumber;
    }

    public static void decimalFormat(double number) {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.FLOOR);
        String num = df.format(number);
        System.out.println(num);
    }
}
