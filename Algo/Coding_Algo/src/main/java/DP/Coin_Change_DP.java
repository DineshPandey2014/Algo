package DP;

import java.util.Arrays;

public class Coin_Change_DP {

    public static void main(String args[]) {
        int coins [] = { 1,2,3};
        int amount = 3;
       int x =  coinChange(coins, amount);
       System.out.println(x);
    }
    public static int coinChange(int[] coins, int amount) {

        int max = amount + 1;

        // Dynamic table to hold the minimum of counts to get the amounts. Lenght is amount + 1.
        //
        int[] dp = new int[amount + 1];

        // Here we find the minmimum of counts of coins to get the amount. Taking max value will give the minimum value.
        Arrays.fill(dp, amount+1);

        // Base no coin chossen as amount is 0
        dp[0] = 0;

        /* Here we Iterate in outer loop for amount which is ( 1....n)
         *
         *  Amount can not be negative. Need to put check coins should be less then the amount.
         *
         */

        // Iterating first with amount start from
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // Checks coin is less then and equal to amount i
                /*
                 * Note here we have inner loop for coins. To get the amount we need to iterate for each coin
                 *
                 */
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}


