public class Main {

  public static void main(String[] args) {
  }

  public static String splitTextIntoWords(String text) {
    String s = text.replaceAll("[\\d\\,\\.\\;]", "");
    String string = s.replaceAll("[\\-]", " ");
    String string2 = string.replaceAll(" ", "\n");
    String string3 = string2.replaceAll("\\s+", " ");
    return string3.replaceAll(" ","\n");
  }
}


















