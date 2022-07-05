import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    for (; ; ) {
      System.out.print("Введите путь до папки, либо ноль, чтобы завершить программу: ");
      String path = scanner.nextLine().trim();
      if (path.equals("0")) {
        break;
      }
      while (!FileUtils.checkPath(path)) {
        System.out.print(
            "Введите корректный путь до папки, либо ноль, чтобы завершить программу: ");
        path = scanner.nextLine().trim();
        if (path.equals("0")) {
          break;
        }
      }
      FileUtils.calculateFolderSize(path);
    }
  }
}
