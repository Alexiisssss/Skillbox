import java.util.Comparator;

public class SortByDescendingSalary implements Comparator<Employee> {

  @Override
  public int compare(Employee worker1, Employee worker2) {
    return worker2.getMonthSalary() - worker1.getMonthSalary();
  }
}