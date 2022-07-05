public class IndividualBusinessman extends Client {

  public final double COMMISSION_WITHDRAWAL = 0.01;
  public final double COMMISSION_ADDITION2 = 0.005;


  public double put(double amountToPut) {
    if (amountToPut >= 0 && amountToPut < 1000) {
      amountToPut = amountToPut - (amountToPut * COMMISSION_WITHDRAWAL);
    } else {
      amountToPut = amountToPut - (amountToPut * COMMISSION_ADDITION2);
    }
    return super.put(amountToPut);
  }

  @Override
  public double take(double amountToTake) {
    return super.take(amountToTake);
  }

  @Override
  public void printBankTerms() {
    System.out.println(
        "Пополнение счета производится c комиссией 1% за каждую операцию, " + System.lineSeparator()
            +
            "если сумма пополнения меньше 1000 р. " + System.lineSeparator() +
            "Пополнение счета производится c комиссией 0,5% за каждую операцию, " + System
            .lineSeparator() +
            "если сумма пополнения от 1000 р" + System.lineSeparator() +
            "Баланс вашего счета: " + getAmount());
  }
}