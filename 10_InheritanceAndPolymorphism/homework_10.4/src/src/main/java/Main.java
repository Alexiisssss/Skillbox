public class Main {

  public static void main(String[] args) {
    Company company = new Company();

    hireEmployees(company);
    fireEmployees(company);
    printLowestSalaryStaff(company, 15);
    printTopSalaryStaff(company, 15);
  }

  private static void hireEmployees(Company company) {
    for (int i = 0; i < 180; i++) {
      Employee operator = new Operator();
      company.hire(operator);
    }
    for (int i = 0; i < 80; i++) {
      Employee manager = new Manager();
      company.hire(manager);
    }
    for (int i = 0; i < 10; i++) {
      Employee topManager = new TopManager();
      company.hire(topManager);
    }
    System.out.println("Добавлено сотрудников: " + company.getCountEmployees());
  }

  private static void fireEmployees(Company company) {
    int countEmployees = company.getCountEmployees();
    for (int j = 0; j < countEmployees / 2; j++) {
      company.fire(j);
    }
    System.out.println("Осталось сотрудников после увольнения: " + company.getCountEmployees());
  }

  public static void printTopSalaryStaff(Company company, int count) {
    if (company.checkListSize(count)) {
      System.out.println("Самые высокие зарплаты: ");
      for (Employee employee : company.getTopSalaryStaff(count)) {
        System.out.println(employee.getMonthSalary() + " руб.");
      }
    } else {
      System.out
          .println("В компании нет такого количества сотрудников или вы ввели не корректное число");
    }
  }

  public static void printLowestSalaryStaff(Company company, int count) {
    if (company.checkListSize(count)) {
      System.out.println("Самые низкие зарплаты: ");
      for (Employee employee : company.getLowestSalaryStaff(count)) {
        System.out.println(employee.getMonthSalary() + " руб.");
      }
    } else {
      System.out
          .println("В компании нет такого количества сотрудников или вы ввели не корректное число");
    }
  }
}