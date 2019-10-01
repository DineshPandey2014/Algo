package DP;

import org.junit.Test;

public class Coin_Change_Recursion {

  @Test
  public void change() {
    // Coins of denomination 1 and 2
    int coins [] = {1, 2};

    // No of ways we can make amount 4.
    int amount = 4;
    int currentCoinIndex = 0;

    int countNoOfCoins = healperChange( amount, coins, currentCoinIndex);
    System.out.println(countNoOfCoins);
  }

  // One set got successfully
  int healperChange(int amount, int [] coins, int currentCoinIndex) {
    if(amount == 0) {
      return 1;
    }

    if(amount < 0) {
      return 0;
    }

    int count = 0;
    for (int coinIndex = currentCoinIndex; coinIndex < coins.length; coinIndex++) {
      count = count + healperChange(amount - coins[coinIndex], coins, coinIndex);
    }
    return count;
  }

}

//1,1,1,1
//1,1,2
//2,2