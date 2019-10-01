package Recursion;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=k4y5Pr0YVhg
 *
 * https://www.interviewcake.com/question/java/coin?course=fc1&section=dynamic-programming-recursion
 *
 * // Bottom up DP https://www.youtube.com/watch?v=L27_JpN6Z1Q
 *
 */
public class Coin_Chain_Recursion {

  private Map<String, Integer> memo = new HashMap<>();

  @Test
 public void noOfCoinsPossibility() {
    int x [] = {1,2};

    int countPossibility = changePossibilitiesTopDown(3, x);
    System.out.println(countPossibility);
  }

  public  int changePossibilitiesTopDown(int amount, int[] denominations) {
    return changePossibilitiesTopDown(amount, denominations, 0);
  }

  private  int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex) {
    if(amountLeft == 0) {
      return 1; // Return 1 means there is one combination of coin which is equal to given amount
    }

    if(amountLeft < -1) {
       return 0; // Return 0 means there this combination is not valid as the amountleft is negative.
    }

    //We are out of denominations
    if(currentIndex == denominations.length) {
      return 0;
    }

    System.out.printf("checking ways to make %d with %s\n",
            amountLeft, Arrays.toString(Arrays.copyOfRange(denominations, currentIndex, denominations.length)));
                    //toString(Arrays.copyOfRange(denominations,
                    //currentIndex, denominations.length)));

    // Choose a current coin
    int currentCoin = denominations[currentIndex];

    // See how many possibility we can get for each number of times to use current coin.
    int numPossibility = 0;

    while (amountLeft >= 0) {
      numPossibility = numPossibility + changePossibilitiesTopDown(amountLeft, denominations,
              currentIndex + 1);
      amountLeft =  amountLeft - currentCoin;
    }

    return numPossibility;
  }


  private  int changePossibilitiesTopDownWithDP(int amountLeft, int[] denominations, int currentIndex) {

    String memoKey = amountLeft + "," + currentIndex;

    if(memo.containsKey(memoKey)) {
      return memo.get(memoKey);
    }

    if(amountLeft == 0) {
      return 1; // Return 1 means there is one combination of coin which is equal to given amount
    }

    if(amountLeft < -1) {
      return 0; // Return 0 means there this combination is not valid as the amountleft is negative.
    }

    //We are out of denominations
    if(currentIndex == denominations.length) {
      return 0;
    }

    System.out.printf("checking ways to make %d with %s\n",
            amountLeft, Arrays.toString(Arrays.copyOfRange(denominations, currentIndex, denominations.length)));
    //toString(Arrays.copyOfRange(denominations,
    //currentIndex, denominations.length)));

    // Choose a current coin
    int currentCoin = denominations[currentIndex];

    // See how many possibility we can get for each number of times to use current coin.
    int numPossibility = 0;

    while (amountLeft >= 0) {
      numPossibility = numPossibility + changePossibilitiesTopDown(amountLeft, denominations,
              currentIndex + 1);
      amountLeft =  amountLeft - currentCoin;
      // save the answer in our memo so we don't compute it again
      memo.put(memoKey, numPossibility);
    }

    return numPossibility;
  }

  // Bottom Up for DP
  // https://www.youtube.com/watch?v=L27_JpN6Z1Q
}
