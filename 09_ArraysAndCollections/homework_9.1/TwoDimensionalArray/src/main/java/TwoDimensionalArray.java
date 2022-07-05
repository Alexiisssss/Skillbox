public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]


        char[][] ggg = new char[size][size];

        for (int i = 0; i < ggg.length; i++) {
            for (int j = 0; j < ggg.length; j++) {
                if (i == j || i + j == (size - 1)) {
                    ggg[i][j] = symbol;
                } else {
                    ggg[i][j] = ' ' ;
                }
            }
        }
        return ggg;
    }
}
