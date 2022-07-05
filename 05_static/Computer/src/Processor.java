public final class Processor {

  private double frequency;
  private int cores;
  private String manufacturer;
  private double weight;



  public double getFrequency() {
    return frequency;
  }

  public int getCores() {
    return cores;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public double getWeight() {
    return weight;
  }


  public void setFrequency(double frequency) {
    this.frequency = frequency;
  }

  public void setCores(int cores) {
    this.cores = cores;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

}

