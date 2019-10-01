
class Solution {
    //Helloworld
    // lwr
    
    int count = 0;
    public String minWindow(String s, String t) {
        //char str [] = t.toCharArray();
        
        int length = s.length();
        int end = 0
        int start = 0;
        int count = 0;
        Map<Character> map = new HashMap();
        
        Set<Character> set = new HashSet();
        
        int j = 0;
        
        while(j < t.length()) {
        	set.add(t.charAt(j));	
        	j++;
        }
        
        while (end < length) {
        	char c = s.charAt(end);
        	
        	if(set.contains(c)) {
        	   if(!map.contains()) {
        	      map.put(c, 1);
        	   } else {
        	      map.put(c, map.get(c) + 1);
        	   }
        	}
        	
        	if() {
        	
        	}
        }
        
        
    }
}