public abstract class Client {

  private double amount = 0;

  public double getAmount() {
    double scale = Math.pow(10, 2);
    return Math.ceil(amount * scale) / scale;
  }

  public double put(double amountToPut) {
    if (amountToPut > 0) {
      amount = amount + amountToPut;
    }
    return amount;
  }

  public double take(double amountToTake) {
    if (amountToTake <= amount) {
      amount = amount - amountToTake;
    }
    return amount;
  }


  public abstract void printBankTerms();
}
