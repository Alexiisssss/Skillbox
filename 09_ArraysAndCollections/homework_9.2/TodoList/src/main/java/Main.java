import java.util.Scanner;

public class Main {

  private static TodoList todoList = new TodoList();

  public static void main(String[] args) {
    // TODO: написать консольное приложение для работы со списком дел todoList
    String[] words;
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Введите операцию:");
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      int number = checkCommand(input);
      switch (number) {
        case (1):
          words = (changeInput(input)).split(" ");
          StringBuilder builder = new StringBuilder();
          for (int i = 1; i < words.length; i++) {
            builder.append(words[i]).append(" ");
          }
          String str = builder.toString().trim();
          todoList.add(Integer.parseInt(words[0]), str);
          break;
        case (2):
          input = changeInput(input);
          todoList.add(input);
          break;
        case (3):
          todoList.printTodos();
          break;
        case (4):
          input = changeInput(input);
          todoList.delete(Integer.parseInt(input));
          break;
        case (5):
          words = changeInput(input).split(" ");
          StringBuilder builderEdit = new StringBuilder();
          for (int i = 1; i < words.length; i++) {
            builderEdit.append(words[i]).append(" ");
          }
          String strEdit = builderEdit.toString().trim();
          todoList.edit(strEdit, Integer.parseInt(words[0]));
          break;
        default:
          System.out.println("Введена не верная команда. Введите команду заново");
          break;
      }
    }
  }

  public static int checkCommand(String input) {
    int numberAction;
    if (input.matches("^(ADD\\s[0-9]{1,5}(\\s\\w+){1,3})$")) {
      numberAction = 1;
    } else if (input.matches("^(ADD(\\s\\w+){1,3})$")) {
      numberAction = 2;
    } else if (input.matches("^(LIST)$")) {
      numberAction = 3;
    } else if (input.matches("^(DELETE\\s[0-9]{1,5})$")) {
      numberAction = 4;
    } else if (input.matches("^(EDIT\\s[0-9]{1,5}(\\s\\w+){1,3})$")) {
      numberAction = 5;
    } else {
      numberAction = 6;
    }
    return numberAction;
  }

  public static String changeInput(String input) {
    return (input.replaceAll("(ADD\\s)|(EDIT\\s)|(DELETE\\s)", "").trim());
  }
}