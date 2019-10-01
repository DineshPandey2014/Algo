
    static String reverse_ordering_of_words(String s) {
      
      char [] charArr = s.toCharArray();
      int i = 0
      int j = charArr.length-1;
      
         while(i <= j) {  	
      	 char temp = charArr[i];
      	 charArr[i] = charArr[j]
      	 charArr[temp];
      	 i++;
      	 j++;
      	
      }	
      
    }