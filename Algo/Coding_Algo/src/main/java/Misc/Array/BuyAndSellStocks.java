package Misc.Array;

import org.junit.Test;

/**
 * Created by dpandey on 11/5/17.
 *
 * https://www.interviewcake.com/question/java/stock-price
 *
 *
 */
public class BuyAndSellStocks {

    @Test
    public void testMaxProfit() {
       // int [] stockPrice = {7, 1, 5, 3, 6, 4};
       // int [] stockPriceNoTransaction = {7,6,4,3,1};
        int [] stockPriceTwo = {1,2};

        //System.out.println(maxProfit(stockPriceTwo));

        System.out.println(maxProfitTwo(stockPriceTwo));
    }

    public int maxProfit(int[] prices) {
        // make sure we have at least 2 prices
        if(prices != null && prices.length < 2) {
            throw new IllegalArgumentException("To get a profit we need at least two transactions.");
        }
        // 7,1,5,3,6,4

        //  we'll greedily update minPrice and maxProfit, so we initialize
        // them to the first price and the first possible profit
        int minPrice = prices[0]; // 7
        int maxProfit = 0;// prices[1] - prices[0]; // -6

        // start at the second (index 1) time
        // we can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time!
        // if we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our
        // maxProfit is supposed to be *negative*--we'd return 0.
        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i]; // 1,5,3,6,4
            // see what our profit would be if we bought at the
            // min price and sold at the current price
            int currentProfit = currentPrice - minPrice; // 4,2,5,3
            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, currentProfit); // -6,4,5

            // update minPrice so it's always
            // the lowest price we've seen so far
            minPrice =  Math.min(minPrice, currentPrice); // 1
        }
        return maxProfit;
    }


    public int maxProfitTwo(int[] prices) {
        int maxProfit =  0;
        if(prices != null && prices.length >= 2) {
            // 7,1,5,3,6,4
            int minPrice = prices[0]; // 7
            for (int i = 1; i < prices.length; i++) {
                int currentPrice = prices[i]; // 1,5,3,6,4
                int currentProfit = currentPrice - minPrice; // 4,2,5,3
                maxProfit = Math.max(maxProfit, currentProfit); // -6,4,5
                minPrice =  Math.min(minPrice, currentPrice); // 1
            }
        }

        return maxProfit;
    }
}
