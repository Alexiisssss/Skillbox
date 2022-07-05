import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Операции с массивами - получение среднего значения")
class HospitalTest {
    private static final double[] testHospitalData = new double[0];

    @BeforeAll
    static void setUp() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Test
    @DisplayName("Генерируемый массив не содержит температуры за рамками заданных предельных значений")
    void testCollectDataContainsCorrectEntries() {
        double[] testHospitalData = Hospital.generatePatientsTemperatures(100);
        long amountCorrectTemperatures = IntStream.range(0, testHospitalData.length)
                .mapToDouble(i -> testHospitalData[i])
                .filter(t -> t >= 32)
                .filter(t -> t <= 40)
                .count();

        assertEquals(100L, amountCorrectTemperatures,
                "Температуры выходят за предельные значения, actual - количество температур в требуемых диапазонах");
    }

    @Test
    @DisplayName("Массив температур содержит 30 значений температур")
    void testTemperatureArrayLength() {
        assertEquals(30, Hospital.generatePatientsTemperatures(30).length);
    }

    @Test
    @DisplayName("Метод корректно считает среднюю температуру и количество здоровых пациентов")
    void testGetReport() {
        String temperatures = String.join(" ",
                IntStream.range(0, testHospitalData.length)
                        .mapToObj(i -> String.valueOf(testHospitalData[i])).toArray(String[]::new));

        String expected = "Температуры пациентов: " + temperatures + System.lineSeparator() +
                "Средняя температура: 35.23" + System.lineSeparator() +
                "Количество здоровых: 5";

        assertEquals(expected, Hospital.getReport(testHospitalData)
                        .replaceAll("\r\n", "\n")
                        .replaceAll("\n", System.lineSeparator()),
                "Проверьте формат вывода, округление средней температуры и количество здоровых пациентов");
    }
}