public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        int size = 10;
        char[][] ggg = TwoDimensionalArray.getTwoDimensionalArray(size);
        for (char[] chars : ggg) {
            for (Character character : chars) {
                System.out.print(character);
            }
            System.out.println();
        }
    }
}





