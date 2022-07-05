import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();
    String input2 = scanner.nextLine();

    String number = "<4008 1234 5678> 8912";
    String number2 = "<4008 1234 5678> 8912";


    System.out.println(number.replaceAll("[<0-9>]", "*"));
    System.out.println(number2.replaceAll("[<0-9>]", ""));





   // }
  }

  public static String searchAndReplaceDiamonds(String text, String placeholder) {

    // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
    return text;
  }
}

