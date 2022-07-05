public class PhysicalPerson extends Client {

  @Override
  public void printBankTerms() {
    System.out.println("Пополнение и списание денег со счета производится без комиссии. " +
        "Баланс вашего счета: " + getAmount());
  }
}









