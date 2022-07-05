public class Main {
    public static void main(String[] args) {

      float[] temperatureData = Hospital.generatePatientsTemperatures(20);
      System.out.println(Hospital.getReport(temperatureData));
    }
}


