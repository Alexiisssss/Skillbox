import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    String a = input.replaceAll("[^\\d]", "");

    Pattern pattern = Pattern.compile("^((\\+?7|8)([0-9]{10}))$");
    Matcher matcher = pattern.matcher(a);

    if (a.length() == 10) {
      if (a.charAt(0) == '8') {
        a.replace(a.substring(0, 1), "7");
      }
      System.out.println("7" + a);
    }
    else if (matcher.matches()) {
      System.out.println(a.replaceAll("^\\d", "7"));
    } else {
      System.out.println("Неверный формат номера");
    }
  }
}


