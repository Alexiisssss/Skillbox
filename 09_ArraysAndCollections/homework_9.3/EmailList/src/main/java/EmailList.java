import java.util.*;

public class EmailList {

  private final Set<String> treeSet;

  public EmailList() {
    treeSet = new TreeSet<>();
  }

  public static boolean checkRightEmail(String email) {
    return email.matches("^([a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]+)$");
  }

  public void add(String email) {
    if (checkRightEmail(email)) {
      treeSet.add(email.toLowerCase());
    }
  }

  public List<String> getSortedEmails() {
    return new ArrayList<>(treeSet);
  }

  public void printSortedEmails() {
    if (getSortedEmails().size() == 0) {
      System.out.println("Cписок email пуст");
    } else {
      for (String treeElem : getSortedEmails()) {
        System.out.println(treeElem);
      }
    }
  }
}