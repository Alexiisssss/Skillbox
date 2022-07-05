import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {

  private static List<Employee> listEmployees = new ArrayList<Employee>();

  public Company() {
    getIncome();
  }

  public void hire(Employee worker) {
    listEmployees.add(worker);
  }

  public void hireAll(int countToBeHired, Employee worker) {
    for (int i = 0; i < countToBeHired; i++) {
      hire(worker);
    }
  }

  public void fire(int number) {
    listEmployees.remove(number);
  }

  public static int getIncome() {
    return 500000;
  }

  public int getCountEmployees() {
    return listEmployees.size();
  }

  public List<Employee> getLowestSalaryStaff(int count) {
    if (checkListSize(listEmployees, count)) {
      return getCopySortedList(listEmployees, new SortByAscendingSalary(), count);
    }
    return new ArrayList<Employee>();
  }

  public List<Employee> getTopSalaryStaff(int count) {
    if (checkListSize(listEmployees, count)) {
      return getCopySortedList(listEmployees, new SortByDescendingSalary(), count);
    }
    return new ArrayList<Employee>();
  }

  private static boolean checkListSize(List<Employee> listEmployees, int count) {
    return listEmployees.size() >= count;
  }

  private static List<Employee> getCopySortedList(List<Employee> listEmployees,
      Comparator<Employee> comparator, int count) {
    List<Employee> resultSalary = new ArrayList<Employee>();
    if (checkListSize(listEmployees, count)) {
      List<Employee> listCopy = new ArrayList<Employee>(listEmployees);
      Collections.sort(listCopy, comparator);
      for (int i = 0; i <= count; i++) {
        resultSalary.add(listCopy.get(i));
      }
    }
    return resultSalary;
  }

  public boolean checkListSize(int count) {
    return listEmployees.size() >= count;
  }
}