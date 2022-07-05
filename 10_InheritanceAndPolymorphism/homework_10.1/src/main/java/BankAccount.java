public class BankAccount {

  private double amount = 0;

  public double getAmount() {
    return amount;
  }

  public void put(double amountToPut) {
    if (amountToPut > 0) {
      amount = amount + amountToPut;
    }
  }

  public double take(double amountToTake) {
    if (amountToTake <= amount) {
      amount = amount - amountToTake;
    }
    return amount;
  }

  // метод для отправки денег с одного счёта на другой.
  boolean send(BankAccount receiver, double amount) {
    receiver.take(amount);
    return receiver.getAmount() > 0;
  }
}






