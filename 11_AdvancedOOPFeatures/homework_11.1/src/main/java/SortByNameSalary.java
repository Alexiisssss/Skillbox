import java.util.Comparator;

public class SortByNameSalary implements Comparator<Employee> {

  @Override
  public int compare(Employee o1, Employee o2) {
    int iSalComaprison = Integer.compare(o1.getSalary(), o2.getSalary());
    if (iSalComaprison == 0) {
      return o1.getName().compareTo(o2.getName());
    }
    return iSalComaprison;
  }
}













