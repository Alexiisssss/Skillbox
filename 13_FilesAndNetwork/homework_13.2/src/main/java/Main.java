import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {

      System.out.println(
          "Введите путь до папки, из которой будем копировать данные, либо ноль, чтобы завершить программу: ");
      String pathSource = scanner.nextLine().trim();
      if (pathSource.equals("0")) {
        System.exit(0);
      }
      while (FileUtils.checkPath(pathSource)) {
        System.out.println(
            "Введите корректный путь до папки, из которой будем копировать данные, либо ноль, чтобы завершить программу: ");
        pathSource = scanner.nextLine().trim();
        if (pathSource.equals("0")) {
          System.exit(0);
        }
      }
      System.out.println(
          "Введите путь до папки, в которую будем копировать данные, либо ноль, чтобы завершить программу: ");
      String pathDestination = scanner.nextLine().trim();
      if (pathDestination.equals("0")) {
        System.exit(0);
      }
      while (FileUtils.checkPath(pathDestination)) {
        System.out.println(
            "Введите корректный путь до папки, в которую будем копировать данные, либо ноль, чтобы завершить программу: ");
        pathDestination = scanner.nextLine().trim();
        if (pathDestination.equals("0")) {
          System.exit(0);
        }
      }
      FileUtils.copyFolder(pathSource, pathDestination);
    }
  }
}