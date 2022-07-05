public class Hospital {

  public static final float min_Temp = 36.2f;
  public static final float max_Temp = 36.9f;


  public static float[] generatePatientsTemperatures(int patientsCount) {

    float[] patientsTemperature = new float[patientsCount];

    for (int i = 0; i < patientsCount; i++) {
      patientsTemperature[i] = Math.round(((float) (Math.random() * 8) + 32) * 100) / (float) 100.0;
    }
    return patientsTemperature;
  }

  public static String getReport(float[] temperatureData) {

    float totalTemperature = 0;
    int healthyPatientCount = 0;

//        стринг билдер чтобы конкатеринровать строку
    StringBuilder allTemperaturePatient = new StringBuilder();

//        перебираем прибывший массиый
    for (float temperature : temperatureData) {
      totalTemperature += temperature;
      allTemperaturePatient
          .append(temperature)
          .append(" ");

//            если попадает в диапазон значит здороый
      if (temperature >= min_Temp && temperature <= max_Temp) {
        healthyPatientCount++;
      }
    }

    float ratio = 100F;

    return "Температуры пациентов: " + allTemperaturePatient.toString().trim() +
        "\nСредняя температура: "
        + Math.round(totalTemperature / temperatureData.length * ratio) / ratio +
        "\nКоличество здоровых: " + healthyPatientCount;
  }
}