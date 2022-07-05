import java.io.IOException;

public class Main {

  static final String MOVEMENTLISTFILE = "src/test/src.main.src.main.resources/movementList.csv";

  public static void main(String[] args) throws IOException {

    Movements movements = new Movements(MOVEMENTLISTFILE);

    System.out.println("Сумма расходов: " + movements.getExpenseSum() + " руб.");
    System.out.println("Сумма доходов: " + movements.getIncomeSum() + " руб.");

    System.out.println("==============================================\n" +
        "Сумма расходов по организации:");
    movements.getListExpenseSumToCompany().forEach((s, strings) -> System.out.println(s + (s.length() < 30 ? "\t\t\t\t" : "\t") + strings.get() + " руб."));

    System.out.println("==============================================\n" +
        "Сумма доходов по организации:");
    movements.getListIncomeSumToCompany().forEach((s, strings) -> System.out.println(s + "\t" + strings.get() + " руб."));

  }
}