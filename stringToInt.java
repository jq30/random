import java.util.Arrays;

public class stringToInt {
  public static int shittyStringToInt(String s) {
    for (int i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i++) {
      if (s.equals("" + i)) {
        return i;
      }
    }
    throw new NumberFormatException("For input string: " + s);
  }

  public static int valueOf(char c) {
    char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    return Arrays.BinarySearch(digits, c);
  }

  public static int stringToInt(String s) {
    //index to loop through string
    int i = 0;

    //check for negative
    boolean negative = false;
    if (String.charAt(0) == '-') {
      negative = true;
    }


  }

  public static void main(String[] args) {
    System.out.println(shittyStringToInt(args[0]));
  }
}
