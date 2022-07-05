public final class Manager extends Company implements Employee {

  public final double PERCENT_OF_PROFIT = 0.05;
  public final double BASE_RATE = 15000;
  private final int earnedMoney;

  public Manager() {
    int thirstMeaning = 115;
    int lastMeaning = 140;
    earnedMoney = (int) (
        PERCENT_OF_PROFIT * ((int) (Math.random() * (lastMeaning - thirstMeaning + 1))
            + thirstMeaning) * 1000 + BASE_RATE);
  }

  public int getMonthSalary() {
    return earnedMoney;
  }
}