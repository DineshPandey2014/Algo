/*
     * Complete the function below.
     */
    static boolean check_if_sum_possible(long[] arr, long k) {
        // Sort the array.
        Arrays.sort(arr);
      
         
        int i = 0;
        int j = arr.length -1;
        
       while(i <= j) {
           if(arr[i] == k) {
               return true;
           }
           
           if(arr[j] == k) {
               return true;
           }
           
           if(arr[i] + arr [j] == k) {
               return true;
           } else if (arr[i] + arr[j] <k ) {
               i++;
           } else {
               j--;
           }
           
       }
       return false;
    }