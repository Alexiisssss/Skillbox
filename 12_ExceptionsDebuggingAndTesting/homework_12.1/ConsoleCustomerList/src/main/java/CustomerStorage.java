import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {

  private final Map<String, Customer> storage;

  public CustomerStorage() {
    storage = new HashMap<>();
  }

  public void addCustomer(String data) {
    final int INDEX_NAME = 0;
    final int INDEX_SURNAME = 1;
    final int INDEX_EMAIL = 2;
    final int INDEX_PHONE = 3;

    String[] components = data.split("\\s+");

    if (components.length > 4) {
      throw new IllegalStateException("The count of words more than 4");
    } else if (components.length < 4) {
      throw new IllegalStateException("The count of words little than 4");
    } else if (!components[INDEX_EMAIL].matches(
        "((([0-9A-Za-z]{1}[-0-9A-z.]{0,30}[0-9A-Za-z]?)|([0-9А-Яа-я]{1}[-0-9А-я.]{0,30}[0-9А-Яа-я]?))@([-A-Za-z]{1,}.){1,}[-A-Za-z]{2,})")) {
      throw new IllegalStateException("wrong format of email");
    } else if (!components[INDEX_PHONE].matches("^(\\+?(79[0-9]{9})|(89[0-9]{9})|(9[0-9]{9}))$|")) {
      throw new IllegalStateException("wrong format of phone");
    }
    components[INDEX_PHONE] = components[INDEX_PHONE].replaceAll("[\\s-()]", "");

    String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
    storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
  }

  public void listCustomers() {
    storage.values().forEach(System.out::println);
  }

  public void removeCustomer(String name) {
    storage.remove(name);
  }

  public Customer getCustomer(String name) {
    return storage.get(name);
  }

  public int getCount() {
    return storage.size();
  }
}