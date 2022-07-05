import java.util.Scanner;

public class Main {

  public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
  public static final String COMMAND = "LIST";
  private final static EmailList emailList = new EmailList();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      if (input.equals(COMMAND)) {
        emailList.printSortedEmails();
      } else if (input.matches("(^ADD)\\s.*")) {
        checkCommand(input);
      }
    }
  }

  public static void checkCommand(String input) {
    input = input.replaceFirst("^ADD\\s", "").trim();
    if (EmailList.checkRightEmail(input)) {
      emailList.add(input);
    } else {
      System.out.println(WRONG_EMAIL_ANSWER);
    }
  }
}
