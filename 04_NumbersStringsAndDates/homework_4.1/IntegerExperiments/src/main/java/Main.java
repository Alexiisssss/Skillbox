public class Main {

    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;
        int sum = sumDigits(7843);
        System.out.println(sum);

    }


    public static int sumDigits(Integer number) {
        return 0;
    }



    /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */


    public static int sumDigits(int number) {
        //создайте переменную для суммы чисел в методе;
        int sum = 0;

        //преобразуйте полученное число в строку
        Integer.toString(sum);

        //обойдите каждый символ строки и преобразуйте уже символ в число при обходе;
        for (String s : String.valueOf(number).split(""))

            //полученную цифру суммируйте при обходе;
            sum += Integer.valueOf(s);

        //верните сумму.
        return sum;

    }
}










