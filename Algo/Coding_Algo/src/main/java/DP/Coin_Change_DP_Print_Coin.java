package DP;

import java.util.Arrays;

/**
 * Coin change problem.
 * https://www.youtube.com/watch?v=rdI94aW6IWw
 *
 *
 */
public class Coin_Change_DP_Print_Coin {

    public static void main (String args[]) {

        int coins [] = { 3,4,5};
        int amount = 8; // {(1,2)}

        int x =  coinChange(coins, amount);
    }

    public static int coinChange(int[] coins, int amount) {
        int dp [] = new int [amount + 1];

        String coinsPrint [] = new String [amount + 1];

        Arrays.fill(dp, 9);

        dp[0] = 0;




        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    if(dp[i - coins[j]] + 1 <= dp[i]) {
                        coinsPrint[i] = coinsPrint[i] + "#" +coins[j];
                    }

                }
            }
        }


        String x = coinsPrint[8];
        int index = x.indexOf("#");
        String y  = x.substring(index+1, x.length());
        String z [] = y.split("#");
        int amountCalc = 0;
        for (String str : z) {
             amountCalc = amount;
            if(str != null) {
                while(amountCalc != 0) {
                    amountCalc = amountCalc - Integer.parseInt(str);
                    String coin = coinsPrint[amountCalc];
                    int indexOfCoin = coin.indexOf("#");
                }
            }
        }


        return dp[amount];
    }
}
