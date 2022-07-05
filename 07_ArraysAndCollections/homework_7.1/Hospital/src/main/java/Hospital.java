import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Hospital {

  private final static Random RND = new Random();
  private final static DecimalFormat FORMATTER_1 = new DecimalFormat("#0.0");
  private final static DecimalFormat FORMATTER_2 = new DecimalFormat("#0.00");

  private final static double MIN_TEMP = 32;
  private final static double MAX_TEMP = 40;
  private final static double MIN_HEALTH_TEMP = 36.2;
  private final static double MAX_HEALTH_TEMP = 36.9;

  public static double[] generatePatientsTemperatures(int patientsCount) {
    return RND.doubles(patientsCount, MIN_TEMP, MAX_TEMP).toArray();
  }

  public static String getReport(double[] temperatureData) {

    double avg = Arrays.stream(temperatureData).average().getAsDouble();

    long patientsHealth = Arrays.stream(temperatureData)
        .filter(temp -> MIN_HEALTH_TEMP < temp && temp < MAX_HEALTH_TEMP).count();

    return String.join(" ",
        "Температуры пациентов:", printDouble(FORMATTER_1, temperatureData),
        "\nСредняя температура:", FORMATTER_2.format(avg),
        "\nКоличество здоровых:", String.valueOf(patientsHealth)
    );
  }

  private static String printDouble(DecimalFormat formatter, double... args) {
    return Arrays.stream(args).mapToObj(formatter::format).collect(Collectors.joining("; "));
  }
}