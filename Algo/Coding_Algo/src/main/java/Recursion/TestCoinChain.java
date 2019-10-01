package Recursion;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestCoinChain {

  @Test
  public void testCoinChain() {
    int coin [] = {3,2};
    int amount = 3;
    Map<String, Integer> map = new HashMap<>();

   int result =  coinChain(coin, amount, 0, map);
   System.out.println(result);
  }

  public int coinChain(int coin [], int amount, int index,  Map<String, Integer> map) {
    String key = amount + "$" + index;
    if(amount  == 0) {
      return 1;
    }

//    if(map.containsKey(key)) {
//      return map.get(key);
//    }

    if(amount < 0) {
      return 0;
    }

    int count = 0;

    for(int  i = index ; i < coin.length; i++) {
      count  = count + coinChain(coin, amount - coin[index], i, map);
       //map.put(key, count);
    }

    return count;
  }

}

