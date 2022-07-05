/**
 * URL             Method              Description
 * <p>
 * /list/          GET                 Список всех задач
 * <p>
 * [ { "id": 23, "name": "Заполнить БД", "date": 01.01.2001, "description": "БД должна содержать
 * поля..... ", }, { "id": 24, "name": "Сходить в магазин", "date": 01.04.2020, "description":
 * "Купить: гречку, туалетную бумагу, дробовик, патроны", }, ]
 * <p>
 * /list/ID        GET                 Конкретная задача
 * <p>
 * { "id": 23, "name": "Заполнить БД", "date": 01.01.2001, "description": "БД должна содержать
 * поля..... ", }
 * <p>
 * /list/          POST                Добавление новой задачи
 * <p>
 * { "name": "Заполнить БД", "date": 01.01.2001, "description": "БД должна содержать поля..... ", }
 * <p>
 * <p>
 * <p>
 * /list/ID        PUT                 Сохранение изменений задачи целиком
 * <p>
 * { "name": "Заполнить БД", "date": 01.01.2001, "description": "БД должна содержать поля..... ", }
 * <p>
 * /list/ID        PATCH               Сохранение изменений отдельных свойств
 * <p>
 * { "description": "БД должна содержать поля..... ", }
 * <p>
 * /list/ID        DELETE              Удаление задачи
 */

package main;

import main.model.ToDo;
import main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
public class DefaultController {

  @Autowired
  private ToDoRepository toDoRepository;

  @Value("${someParameter.value}")
  private Integer someParameter;

  @RequestMapping("/")
  public String index(Model model) {
    Iterable<ToDo> toDoIterable = toDoRepository.findAll();
    ArrayList<ToDo> toDos = new ArrayList<>();
    for (ToDo toDo : toDoIterable) {
      toDos.add(toDo);
    }

    model.addAttribute("list", toDos);
    model.addAttribute("ToDoCount", toDos.size());
    model.addAttribute("someParameter", someParameter);
    return "index";
  }

}
