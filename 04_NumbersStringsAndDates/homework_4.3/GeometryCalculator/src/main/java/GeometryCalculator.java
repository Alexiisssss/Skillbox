import java.util.Scanner;

public class GeometryCalculator {

  // метод должен использовать абсолютное значение radius
  public static double getCircleSquare(double radius) {
    double area = Math.PI * (radius * radius);
    System.out.println("Площадь круга равна: " + area);
    return area;
  }


  // метод должен использовать абсолютное значение radius
  public static double getSphereVolume(double radius) {

    double volume = 4 * Math.PI / 3 * (radius * radius * Math.abs(radius));
    System.out.println("Площадь шара равна: " + volume);
    return volume;
  }


  public static boolean isTrianglePossible(double a, double b, double c) {
    if (a + b <= c || a + c <= b || b + c <= a) {
      return false;
    } else {
      return true;
    }
  }

  // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
  // методом isTrianglePossible, если невозможен вернуть -1.0
  public static double getTriangleSquare(double a, double b, double c) {
    if (a + b <= c || a + c <= b || b + c <= a) {
      return -1.0;
    }
    double pp = (Math.abs(a) + Math.abs(b) + Math.abs(c)) / 2.0;
    return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
  }
}
