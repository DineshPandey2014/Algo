
// Is 
boolean isPlaindrome(String str) {
   
    int i = 0;
    int j = str.length() -1;
    
	while(i<=j) {
	   if(str.charAt(i) == str.charAt(j) {
	        i++;
	        j--;
	   		continue;
	    } else {
	    	return false;
	    }
	    
	}
	return true;
}


