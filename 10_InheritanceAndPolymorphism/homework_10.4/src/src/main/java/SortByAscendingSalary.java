import java.util.Comparator;

public class SortByAscendingSalary implements Comparator<Employee> {

  @Override
  public int compare(Employee worker1, Employee worker2) {
    return worker1.getMonthSalary() - worker2.getMonthSalary();
  }
}
