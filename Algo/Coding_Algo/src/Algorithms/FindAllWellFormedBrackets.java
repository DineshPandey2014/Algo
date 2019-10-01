

public void findAllBraces (int n, int leftBraceCount, int rightBraceCount, List<String> list, String pair) {

 if(leftBraceCount == rightBraceCount) {
    list.add(pair);
    return;
 }

   if(leftBraceCount < n) {
        findAllBraces (n, leftBraceCount +1, rightBraceCount, list, pair + "(");
     }
   
  if(rightBraceCount < n && rightBraceCount <= leftBraceCount) {
	    findAllBraces (n, leftBraceCount, rightBraceCount + 1, list, pair + ")");
	 }
}