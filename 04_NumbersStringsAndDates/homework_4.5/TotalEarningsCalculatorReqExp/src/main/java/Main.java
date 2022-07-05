import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

  public static void main(String[] args) {
  }


  public static int calculateSalarySum(String text) {
    int sum = 0;
    Scanner scanner = new Scanner(text);
    String input = scanner.nextLine();
    Pattern p = Pattern.compile("\\b\\d+\\b");
    Matcher m = p.matcher(input);
    while (m.find()) {
      sum += Integer.parseInt(m.group());
    }
    return (sum);
  }
}
































