public class CardAccount extends BankAccount {

  public final double COMMISSION_PERCENT = 0.01;


  public double getAmount() {
    return super.getAmount();
  }


  public void put(double amountToPut) {
    super.put(amountToPut);
  }


  public double take(double amountToTake) {

    double preliminaryAmount = amountToTake + (amountToTake * COMMISSION_PERCENT);

    if (preliminaryAmount >= 0) {
      amountToTake = preliminaryAmount;
    }
    return super.take(amountToTake);
  }
}






