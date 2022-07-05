import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movements {

  private static final String CSV_SPLIT = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
  private final ArrayList<String[]> csvParseLines;
  private static final int INDEX_INCOME = 6;
  private static final int INDEX_EXPENSE = 7;
  private static final int INDEX_DESCRIPTION_PAYMENT = 5;

  public Movements(String pathMovementsCsv) {
    csvParseLines = new ArrayList<>();
    try (Stream<String> pathStream = Files.lines(Paths.get(pathMovementsCsv))) {
      pathStream
          .skip(1)
          .map(line -> line.split(CSV_SPLIT))
          .forEach(csvParseLines::add);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  public double getExpenseSum() {
    return csvParseLines.stream()
        .map(Movements::getExpenseSumLine)
        .reduce(Double::sum)
        .get();
  }

  public double getIncomeSum() {
    return csvParseLines.stream()
        .map(Movements::getIncomeSumLine)
        .reduce(Double::sum)
        .get();
  }

  public Map<String, Optional<Double>> getListExpenseSumToCompany() {
    return csvParseLines.stream()
        .filter(strings -> getExpenseSumLine(strings)
            > 0)
        .collect(Collectors.groupingBy(Movements::getCompanyFromDescriptionPayment,

            Collectors.mapping(Movements::getExpenseSumLine,
                Collectors.reducing(Double::sum))));
  }

  public Map<String, Optional<Double>> getListIncomeSumToCompany() {
    return csvParseLines.stream()
        .filter(strings -> getIncomeSumLine(strings)
            > 0)
        .collect(Collectors.groupingBy(Movements::getCompanyFromDescriptionPayment,

            Collectors.mapping(Movements::getIncomeSumLine,
                Collectors.reducing(Double::sum))));
  }

  private static Double getExpenseSumLine(String[] strings) {
    return Double.parseDouble(strings[INDEX_EXPENSE].replaceAll("\"", "").replaceAll(",",
        "."));
  }

  private static Double getIncomeSumLine(String[] strings) {
    return Double.parseDouble(strings[INDEX_INCOME].replaceAll("\"", "").replaceAll(",",
        "."));
  }

  private static String getCompanyFromDescriptionPayment(
      String[] strings) {
    String[] descPayment = strings[INDEX_DESCRIPTION_PAYMENT].split("\\s+", 2);
    return descPayment[1].split("\\s{3}", 2)[0];
  }
}
