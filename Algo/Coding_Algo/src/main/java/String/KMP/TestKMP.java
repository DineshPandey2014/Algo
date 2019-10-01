package String.KMP;

import java.util.ArrayList;
import java.util.List;

public class TestKMP {

  public static void main(String args[]) {
    //String text = "abxabcabcababcaby";
    //String pattern = "abcaby";

    String text = "much,";
    String pattern = ",";

    int output[] = getAllMatchingIndexes(text ,pattern);

    for(Integer out : output) {
      System.out.println(out);
    }
  }

  private static int [] findKMPPrefixTable(String p) {
    char [] arrayPattern = p.toCharArray();
    int [] prefixPattern = new int [p.length()];
    int i = 1;
    int j = 0;

    prefixPattern[0] = 0;
    while(i < arrayPattern.length) {
      if(arrayPattern[j] == arrayPattern[i] ) {
        prefixPattern [i] = j + 1;
        i++;
        j++;
      } else {
        if(j == 0) {
          prefixPattern[i] = 0;
          i++;
        }
        if(j != 0) {
          j = prefixPattern[j - 1];
        }
      }
    }
    return prefixPattern;
  }


  private static int[] getAllMatchingIndexes(String t1, String p1) {
    int [] prefixPattern = findKMPPrefixTable(p1);
    char textArray [] = t1.toCharArray();
    char patternArray [] = p1.toCharArray();

    List<Integer> foundIndex = new ArrayList();

    int t = 0;  // For text
    int p = 0;  // For Pattern

    while (t < textArray.length) {
      if(textArray[t] == patternArray[p]) {
        if(p == patternArray.length - 1) {
          foundIndex.add(t-p);
          p = 0;
          if(t == textArray.length -1) {
            t++;
          }
        } else {
          t++;
          p++;
        }

      } else {
        if(p != 0) {
          p = prefixPattern[p-1];
        } else {
          // This is the case when j = 0 character doesn't match with text[y] character
          // In this case j will not increment only i will increment like i++
          t++;
        }
      }
    }

    if(foundIndex.size() == 0) {
      foundIndex.add(-1);
    }

    int  matchindPatternIndex [] = new int [foundIndex.size()];

    int i = 0;
    for(int index : foundIndex) {
      matchindPatternIndex[i] = index;
      i++;
    }

    return matchindPatternIndex;
  }
}
