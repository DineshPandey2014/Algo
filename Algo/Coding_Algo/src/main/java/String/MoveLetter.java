package String;

public class MoveLetter {

    public static void main (String args[]) {
        String str = "kkkkKkkkkk";
        String output = moveLetter(str.toCharArray());
        System.out.println(output);
    }


   public static String moveLetter(char input []) {
        int s = 0;
        int d = 0;
        int length = input.length;
        int i = 0;
        int destination = 0;
        int source = destination + 1;

        while(i<length) {
            char c = input[i];
            if(Character.isDigit(c)) {
                destination = i;
                break;
            }
            i++;
        }


        int j = destination + 1;
        while(j<length && destination != 0) {
            if(Character.isLetter(input[j])) {
                input[destination] = input[j];
                destination++;
            }
            j++;
        }

        return String.valueOf(input);
    }

}
