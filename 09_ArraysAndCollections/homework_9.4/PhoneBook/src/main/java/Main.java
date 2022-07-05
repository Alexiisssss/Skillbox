import java.util.Scanner;
import java.util.TreeSet;

public class Main {

  static PhoneBook phoneList = new PhoneBook();
  static final String COMMAND = "LIST";
  static final String WRONG_ANSWER = "Введите правильную команду или цифру ноль для завершения программы ";
  static final String ABSENCE_NAME = "Такого имени в телефонной книге нет. Введите номер телефона для абонента ";
  static final String ABSENCE_PHONE = "Такого номера нет в телефонной книге. Введите имя абонента для номера ";
  static final String INVALID_FORMAT = "Неверный формат ввода";
  static String name = "";
  static String phone = "";


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Введите номер, имя или команду:");
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      if (input.equals(COMMAND)) {
        phoneList.printAllContacts(phoneList.getAllContacts());
      } else if (phoneList.checkInputName(input)) {
        name = input;
        if (phoneList.getPhonesByName(name).equals(new TreeSet<>())) {
          System.out.println(ABSENCE_NAME + name);
          input = scanner.nextLine();
          while (!input.matches(PhoneBook.REGEX_PHONE)) {
            System.out.println(INVALID_FORMAT);
            input = scanner.nextLine();
            if (input.equals("0")) {
              break;
            }
          }
          phone = input;
          phoneList.addContact(phone, name);
        } else {
          phoneList.printAllContacts(phoneList.getPhonesByName(name));
        }
      } else if (phoneList.checkInputPhone(input)) {
        phone = input;
        if (phoneList.getNameByPhone(phone).equals("")) {
          System.out.println(ABSENCE_PHONE + phone);
          input = scanner.nextLine();
          while (!input.matches(PhoneBook.REGEX_NAME)) {
            System.out.println(INVALID_FORMAT);
            input = scanner.nextLine();
            if (input.equals("0")) {
              break;
            }
          }
          name = input;
          phoneList.addContact(phone, name);
        } else {
          phoneList.printContactsByPhone(phone);
        }
      } else {
        System.out.println(WRONG_ANSWER);
      }
    }
  }
}



