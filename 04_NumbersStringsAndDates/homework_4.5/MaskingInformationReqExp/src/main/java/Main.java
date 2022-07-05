import java.util.Scanner;

public class Main {


  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    //scanner.nextLine();

    String str2 = "Номер кредитной карты";
    String str = "<4008 1234 5678> 8912";

    //Scanner scanner = new Scanner(System.in);

    int openSpaceIndex = str.indexOf("<");
    int closeSpaceIndex = str.indexOf(">");
    int closeSpaceIndex2 = str.indexOf(">");
    str.substring(closeSpaceIndex2);
    System.out.println(str2 + " " + str.substring(openSpaceIndex + 1, closeSpaceIndex)
        .replaceAll("[0-9]+", "*") + str.substring(closeSpaceIndex2 + 1));
  }



    public static String searchAndReplaceDiamonds (String text, String placeholder){
      // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
      return text;
    }
  }


