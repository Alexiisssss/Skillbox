import java.util.Arrays;

public class ReverseArray {

  public static String[] reverse(String[] strings) {


    if (strings == null || strings.length <= 1) {
      return strings;
    }
    for (int i = 0; i < strings.length / 2; i++) {
      String temp = strings[i];

      strings[i] = strings[strings.length - 1 - i];
      strings[strings.length - 1 - i] = temp;
    }
    System.out.println("reversed array : " + Arrays.toString(strings));
    return strings;
  }
}


