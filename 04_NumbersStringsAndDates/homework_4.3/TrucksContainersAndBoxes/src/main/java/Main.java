import java.util.Scanner;
import org.apache.commons.collections.bidimap.AbstractOrderedBidiMapDecorator;

public class Main {

  static final int BOX_IN_CONTAINER = 27;
  static final int CONTAINER_IN_TRUCK = 12;
  static final int BOX_IN_TRUCK = BOX_IN_CONTAINER * CONTAINER_IN_TRUCK;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int box = scanner.nextInt();
    int container = 0;
    int truck = 0;
    int i = 0;

    while (i < box) {
      if (i % BOX_IN_TRUCK == 0) {
        System.out.println("Грузовик: " + ++truck);
      }

      if (i % BOX_IN_CONTAINER == 0) {
        System.out.println("\tКонтейнер: " + ++container);
      }
      System.out.println("\t\tЯщик: " + ++i);
    }
    System.out.println(
        "Необходимо:\nгрузовиков - " + truck + " шт." + "\nконтейнеров - " + container + " шт.");
  }
}

// TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
// пример вывода при вводе 2
// для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */

