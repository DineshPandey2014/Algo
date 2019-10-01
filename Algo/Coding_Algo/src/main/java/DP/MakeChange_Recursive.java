package DP;

public class MakeChange_Recursive {

    public static void main(String args[]) {
        int [] coins = {1, 2};
       int amount = 2;
       Integer counter = 0;
       int x = makeChange(2, coins, counter);
       System.out.println("Count---"+ x);

    }

    static int makeChange(int amount, int[] coins, Integer counter) {

        if(amount  == 0) {
            return 1;
        }

        if(amount < 0) {
            return 0;
        }


        for (int i = 0; i < coins.length; i++) {
                counter = counter + makeChange(amount - coins[i],coins ,counter );
        }

        return counter;

    }




}
