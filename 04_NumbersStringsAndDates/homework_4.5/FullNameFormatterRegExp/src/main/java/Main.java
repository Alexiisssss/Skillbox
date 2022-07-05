import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

  private static final String FCS_PATTERN = "[А-Я][а-я]+(-[А-Я])?[а-я]+(\\s[А-Я][а-я]+){2}";

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    String pattern = FCS_PATTERN;
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(input);
    if (m.matches()) {
      String[] str = input.split(" ");
      System.out.format("Фамилия: %s\nИмя: %s\nОтчество: %s\n", str[0], str[1], str[2] + " ");
    } else {
      System.out.println("Введенная строка не является ФИО");
    }
  }
}


























