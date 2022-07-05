public class TopManager extends Company implements Employee {

  public static int FIX_SALARY = 1500000;

  public int getMonthSalary() {
    return FIX_SALARY + Company.getIncome() > 10000000 ? (int) (FIX_SALARY * 1.5) : 0;
  }
}