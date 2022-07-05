public  final class Monitor {

  private double screenDiagonal;
  private String type;
  private double weight;

  public void setScreenDiagonal(double screenDiagonal) {
    this.screenDiagonal = screenDiagonal;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getScreenDiagonal() {
    return screenDiagonal;
  }

  public String getType() {
    return type;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }
}
