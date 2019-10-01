package String.KMP;

/**
 * KMP algorithm. Crearting an array for input String. Which will tell us logest substring prefix. for
 * input pattern.
 *
 * https://www.youtube.com/watch?v=y2b94AxPlF8
 *
 *  Knuth Morris Pattern. called as (Pi or lps as Longest prefix pattern)
 *
 *  # Tushar how to build prefix table for KMP
 *  https://www.youtube.com/watch?v=KG44VoDtsAA&t=320s
 *
 *  #Tushar KMP
 *  https://www.youtube.com/watch?v=GTJr8OvyEVQ&t=626s
 *
 *
 */
public class ComputePatternArray {

  public static void main (String args[] ) {
    String patterOne = ",";
    int prefixArray [] = getPrefixKMPArray(patterOne);

    for(int outputNumber : prefixArray) {
      System.out.println(outputNumber);
    }
  }

  private static int[]  getPrefixKMPArray(String pattern) {
    char arrayPat [] = pattern.toCharArray();

    int patternArr [] = new int[pattern.length()];

    patternArr[0] = 0;

    int  i = 1;
    int  j = 0;

     while (i < pattern.length()) {
       if(arrayPat[i] == arrayPat[j]) {
         patternArr[i] = j + 1;
         i++;
         j++;
       } else {
         if(j != 0) {
           j = patternArr[j - 1];
         }
           if(j == 0) {
             patternArr[i] = 0;
             i++;
         }
       }
     }
    return patternArr;
  }

}
