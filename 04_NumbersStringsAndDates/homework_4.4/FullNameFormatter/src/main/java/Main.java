import java.util.Scanner;

public class Main {

  static boolean flag;


  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    while (true) {
      String input = scanner.nextLine();
      if (input.equals(" ") || input.equals("") || input.equals("0")) {
        break;
      }
      char[] chars = input.toCharArray();
      for (char c : chars) {
        flag = Character.isDigit(c);
        if (flag) {
          break;
        }
      }

      int count = 0;
      int spaceIndex = input.indexOf(' ');
      int spaceLastIndex = input.lastIndexOf(' ');

      if (input.length() != 0) {
        count++;
        for (int i = 0; i < input.length(); i++) {
          if (input.charAt(i) == ' ') {
            count++;
          }
        }
      }
      if (count != 3 || flag) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      String firstName = input.substring(0, spaceIndex);
      String lastName = input.substring(spaceIndex + 1, spaceLastIndex);
      String otherName = input.substring(spaceLastIndex + 1);
      System.out.println("Фамилия: " + firstName);
      System.out.println("Имя: " + lastName);
      System.out.println("Отчество: " + otherName);
    }
    scanner.close();
  }
}



