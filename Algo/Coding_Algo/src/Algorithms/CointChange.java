 
 public static void main(String args[]) {
 
    public static int [] coins = {1, 2}
    public static int amount = 4;
 
 }
 
 static int makeChange(int amount, int[] coins) {
		
	if(amount  == 0) {
		return 1;
	}
	
	if(amount < 0) {
		return Integer.MAX_VALUE;
	}
	
	int val = 0;
	for (int i = 0; i < coins.length; i++) {
		val = val + makeChange(amount - coins[i],coins );
	}
	
	return val

  }
  
  
  
