import java.util.ArrayList;

public class TodoList {

  private final ArrayList<String> todoList = new ArrayList<>();

  public void add(String todo) {
    todoList.add(todo);
    System.out.println("Добавлено дело " + "\"" + todoList.get(todoList.size() - 1) + "\"");
  }

  public void add(int index, String todo) {
    if (todoList.size() == 0 | todoList.size() - 1 < index) {
      todoList.add(todo);
      System.out.println("Добавлено дело " + "\"" + todoList.get(todoList.size() - 1) + "\"");
    } else {
      todoList.add(index, todo);
      System.out.println("Добавлено дело " + "\"" + todoList.get(index) + "\"");
    }

  }

  public void edit(String todo, int index) {
    if (todoList.size() - 1 >= index && todoList.size() > 0) {
      System.out.print("Дело " + "\"" + todoList.get(index) + "\" заменено на ");
      todoList.set(index, todo);
      System.out.println("\"" + todoList.get(index) + "\"");
    } else {
      System.out.println("Дело с таким номером не существует");
    }
  }

  public void delete(int index) {
    if (todoList.size() - 1 >= index && todoList.size() > 0) {
      System.out.println("Дело " + "\"" + todoList.get(index) + "\" удалено");
      todoList.remove(index);
    } else {
      System.out.println("Дело с таким номером не существует");
    }
  }

  public ArrayList<String> getTodos() {
    return todoList;
  }

  public void printTodos() {
    if (getTodos().size() == 0) {
      System.out.println("Cписок дел пустой");
    } else {
      for (int i = 0; i < getTodos().size(); i++) {
        System.out.println(i + " - " + todoList.get(i));
      }
    }
  }
}