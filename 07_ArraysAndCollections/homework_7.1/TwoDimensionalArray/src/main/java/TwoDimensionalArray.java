import java.util.Arrays;
import java.util.stream.IntStream;

public class TwoDimensionalArray {

  public static char symbol = 'X';

  public static char[][] getTwoDimensionalArray(int size) {

    int[][] arr = new int[3][3];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0, x = arr[i].length; j < arr[i].length; j++, x--) {
        if (i == j || i == x - 1) arr[i][j] = 1;
       System.out.print(arr[i][j] + " ");
      }
      System.out.print("\n");
    }
    return new char[size][size];
  }
}





//TODO: Написать метод, который создаст двумерный массив char заданного размера.
  // массив должен содержать символ symbol по диагоналям, пример для size = 3
  // [X,  , X]
  // [ , X,  ]
  // [X,  , X]







