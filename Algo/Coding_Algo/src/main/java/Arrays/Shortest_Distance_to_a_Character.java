package Arrays;

public class Shortest_Distance_to_a_Character {


  public int[] shortestToChar(String S, char C) {

        /*
         Algo : Two pass approach.
         One Pass from left to right
         Second Pass right to left.

         1. In first past we will hold the prev index as Integer.MAX_VALUE as the iterate the loop
            from left to right find the difference between i - prev.
            Keep updating the previous when found.

         2. In the second pass move from right to left. Assign prev index as Integer.MAX_VAL
            UE. Check if the incoming character is mathicng update the array as  Math.min (i - prev, data from previous array)
       */

    int length = S.length();

    int outputOne [] = new int [length];

    // Assume first character is at index of Integer AX value.
    int prevLeft = Integer.MAX_VALUE;

    // Moving from left to right
    for (int i = 0; i<S.length(); i++) {
      char input = S.charAt(i);

      if(input == C) {
        prevLeft = i;
      }

      if(prevLeft != Integer.MAX_VALUE) {
        outputOne[i] = i - prevLeft;
      } else {
        outputOne[i] = prevLeft;
      }

    }

    // Moving from right to left.
    int prevRight = Integer.MAX_VALUE;

    for (int j = S.length() -1; j>= 0; j--) {
      char input = S.charAt(j);

      if(input == C) {
        prevRight = j;
      }
      outputOne[j] = Math.min(outputOne[j], prevRight-j);
    }
    return outputOne;
  }
}
