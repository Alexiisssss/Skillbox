public class Main {

  public static void main(String[] args) {
    Computer computer;
    Processor processor = new Processor();
    processor.setManufacturer("DELL");
    processor.setWeight(40.0);
    processor.setCores(4);
    processor.setFrequency(3.2);
    Monitor monitor = new Monitor();
    monitor.setWeight(15.0);
    monitor.setType("IPS");
    monitor.setScreenDiagonal(21.7);
    Keyboard keyboard = new Keyboard();
    keyboard.setKeyboardBacklight(true);
    keyboard.setType("Mechanical");
    keyboard.setWeight(1.0);
    Ram ram = new Ram();
    ram.setVolume(8.0);
    ram.setType("DDR4");
    ram.setWeight(15.0);
    HardDrive hardDrive = new HardDrive();
    hardDrive.setMemoryVolume(512);
    hardDrive.setType("SSD");
    hardDrive.setWeight(122.0);

    computer = new Computer("GameComputer", processor, monitor, keyboard, ram, hardDrive, "INTEL");
    System.out.println(computer);
  }
}
