public class Computer {

  public final String name;
  public final Processor processor;
  public final Monitor screenDiagonal;
  public final Keyboard keyboardBacklight;
  public final Ram ram;
  public final HardDrive hardDrive;
  public final String vendor;


  public Computer(String name, Processor processor, Monitor screenDiagonal,
      Keyboard keyboardBacklight, Ram ram, HardDrive hardDrive, String vendor) {
    this.name = name;
    this.processor = processor;
    this.screenDiagonal = screenDiagonal;
    this.keyboardBacklight = keyboardBacklight;
    this.ram = ram;
    this.hardDrive = hardDrive;
    this.vendor = vendor;
  }

  public String getName() {
    return name;
  }

  public String getVendor() {
    return vendor;
  }

  public double sumWeightAccessories() {
    return processor.getWeight() + screenDiagonal.getWeight() + keyboardBacklight.getWeight()
        + ram.getWeight() + hardDrive.getWeight();
  }


  @Override
  public String toString() {
    return "Computer: " + "\n" +
        "Name = " + getName() + "\n" +
        "Processor = :" + "\n" +
        "frequency " + processor.getFrequency() + " Ггц." + "\n" +
        "cores " + processor.getCores() + "\n" +
        "manufacturer " + processor.getManufacturer() + "\n" +
        "weight " + processor.getWeight() + " гр." + "\n" +
        "Monitor = :" + "\n" +
        "screenDiagonal " + screenDiagonal.getScreenDiagonal() + " см." + "\n" +
        "type " + screenDiagonal.getType() + "\n" +
        "weight " + screenDiagonal.getWeight() + " кг." + "\n" +
        "Keyboard = :" + "\n" +
        "keyboardBackLight " + keyboardBacklight.isKeyboardBacklight() + "\n" +
        "type " + keyboardBacklight.getType() + "\n" +
        "weight " + keyboardBacklight.getWeight() + " гр." + "\n" +
        "Ram = :" + "\n" +
        "type " + ram.getType() + "\n" +
        "volume " + ram.getVolume() + " Гб." + "\n" +
        "weight " + ram.getWeight() + " гр." + "\n" +
        "HardDrive = :" + "\n" +
        "type " + hardDrive.getType() + "\n" +
        "memoryVolume " + hardDrive.getMemoryVolume() + " мб." + "\n" +
        "weight " + hardDrive.getWeight() + " гр." + "\n" +
        "vendor = " + getVendor() + "\n" +
        "sumWeightAccessories " + sumWeightAccessories() + " гр.";
  }
}
