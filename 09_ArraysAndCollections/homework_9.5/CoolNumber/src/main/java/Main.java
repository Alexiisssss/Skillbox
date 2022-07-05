import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    CoolNumbers carNumbers = new CoolNumbers();
    CoolNumbers carNumbers2 = new CoolNumbers(1);
    CoolNumbers carNumbers3 = new CoolNumbers(2);
    CoolNumbers carNumbers4 = new CoolNumbers(3);

    while (true) {
      System.out.println("Введите автомобильный номер для поиска или 0 для выхода из программы: ");
      String input = scanner.nextLine().trim();
      if (input.equals("0")) {
        break;
      } else if (CoolNumbers.checkRegexNumber(input)) {
        carNumbers.callBruteForceSearchInList(input);
        carNumbers2.callBinarySearchInList(input);
        carNumbers3.callSearchInHashSet(input);
        carNumbers4.callSearchInTreeSet(input);
      } else {
        System.out.println(
            "Номер не соответствует российскому автомобильному номеру. Введите правильный российский автомобильный номер: ");
      }
    }
  }
}




