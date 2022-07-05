import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {

  private LocalDate lastIncome;
  private double amount = 0;

  private boolean getTermDeposit(LocalDate lastIncome, LocalDate dayOutcome) {
    return daysBetween(lastIncome, dayOutcome) > 30;
  }

  private int daysBetween(LocalDate lastIncome, LocalDate toDateTime) {
    return (int) ChronoUnit.DAYS.between(lastIncome, toDateTime);
  }

  private LocalDate currentDate() {
    return LocalDate.now();
  }

  public double take(double amountToTake) {
    double preliminaryAmount = super.take(amountToTake);

    if (lastIncome != null && getTermDeposit(lastIncome, currentDate()) || (preliminaryAmount
        >= 0)) {
      this.amount = Math.ceil(preliminaryAmount);
      lastIncome = currentDate();
    }
    return amount;
  }
}