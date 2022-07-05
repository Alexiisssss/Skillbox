import java.util.*;

public class CoolNumbers {

  private static final List<String> coolNumbers = new ArrayList<>();
  private static List<String> coolNumbers2;
  private HashSet numbersHashSet;
  private TreeSet<String> numbersTreeSet;
  public static String number = "";
  final static String REGEX_NUMBER = "^[А,В,Е,К,М,Н,О,Р,С,Т,У,Х][1-9][1-9][1-9][А,В,Е,К,М,Н,О,Р,С,Т,У,Х]{2}([0][1-9]|[1-9][0-9]|[1][0-9][0-9])$";

  public CoolNumbers() {
    generateCoolNumbers();
  }

  public CoolNumbers(int input) {
    if (input == 1) {
      coolNumbers2 = new ArrayList<>(coolNumbers);
      Collections.sort(coolNumbers2);
    } else if (input == 2) {
      numbersHashSet = new HashSet(coolNumbers);

    } else if (input == 3) {
      numbersTreeSet = new TreeSet(coolNumbers);
    }
  }

  public static boolean checkRegexNumber(String input) {
    return input.matches(REGEX_NUMBER);
  }

  public static int generateBeautifulNumbers() {
    final int[] beautifulNumbers = {111, 222, 333, 444, 555, 666, 777, 888, 999};
    Random generator = new Random();
    int randomIndex = generator.nextInt(beautifulNumbers.length);
    return beautifulNumbers[randomIndex];
  }

  public static String generateRegion() {
    int thirstNumber = 1;
    int lastNumber = 199;
    int randomRegion = thirstNumber + (int) (Math.random() * lastNumber);
    return (randomRegion < 10) ? "0" + randomRegion : Integer.toString(randomRegion);
  }

  public static char generateLetters() {
    final char[] alphabet = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    Random generator = new Random();
    int randomIndex = generator.nextInt(alphabet.length);
    return alphabet[randomIndex];
  }

  public static List<String> generateCoolNumbers() {
    for (int i = 0; i < 2000001; i++) {
      StringBuilder numberBuilder = new StringBuilder();
      numberBuilder.append(generateLetters()).append(generateBeautifulNumbers())
          .append(generateLetters()).append(generateLetters()).append(generateRegion());
      coolNumbers.add(numberBuilder.toString());
      if (i == 9) {
        number = numberBuilder.toString();
      }
    }
    return coolNumbers;
  }


  public static boolean bruteForceSearchInList(List<String> list, String number) {
    boolean status = false;
    if (checkRegexNumber(number) && list.size() != 0) {
      long startTime = System.nanoTime();
      for (String element : list) {
        if (element.equals(number)) {
          status = true;
          break;
        }
      }

      long estimatedTime = System.nanoTime() - startTime;
      if (status) {
        System.out.println("Поиск перебором: номер найден, поиск занял " + estimatedTime + "нс");
      } else {
        System.out.println("Поиск перебором: номер не найден, поиск занял " + estimatedTime + "нс");
      }
    }
    return status;
  }

  public static boolean binarySearchInList(List<String> sortedList, String number) {
    boolean status = false;
    if (checkRegexNumber(number) && sortedList.size() != 0) {
      long startTime = System.nanoTime();
      if (Collections.binarySearch(sortedList, number) >= 0) {
        status = true;
      }
      long estimatedTime = System.nanoTime() - startTime;
      if (status) {
        System.out.println("Бинарный поиск: номер найден, поиск занял " + estimatedTime + "нс");
      } else {
        System.out.println("Бинарный поиск: номер не найден, поиск занял " + estimatedTime + "нс");
      }
    }
    return status;
  }


  public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
    boolean status = false;
    if (checkRegexNumber(number) && hashSet.size() != 0) {
      {
        long startTime = System.nanoTime();
        if (hashSet.contains(number)) {
          status = true;
        }
        long estimatedTime = System.nanoTime() - startTime;
        if (status) {
          System.out.println("Поиск в HashSet: номер найден, поиск занял " + estimatedTime + "нс");
        } else {
          System.out
              .println("Поиск в HashSet: номер не найден, поиск занял " + estimatedTime + "нс");
        }
      }
    }
    return status;
  }

  public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
    boolean status = false;
    if (checkRegexNumber(number) && treeSet.size() != 0) {
      System.out.println("vv");
      long startTime = System.nanoTime();
      if (treeSet.contains(number)) {
        status = true;
      }
      long estimatedTime = System.nanoTime() - startTime;
      if (status) {
        System.out.println("Поиск в TreeSet: номер найден, поиск занял " + estimatedTime + "нс");
      } else {
        System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + estimatedTime + "нс");
      }
    }
    return status;
  }


  public void callBruteForceSearchInList(String number) {
    bruteForceSearchInList(coolNumbers, number);
  }

  public void callBinarySearchInList(String number) {
    binarySearchInList(coolNumbers2, number);
  }

  public void callSearchInHashSet(String number) {
    searchInHashSet(numbersHashSet, number);
  }

  public void callSearchInTreeSet(String number) {
    searchInTreeSet(numbersTreeSet, number);
  }
}