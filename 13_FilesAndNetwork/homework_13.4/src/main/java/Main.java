import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  private static Logger logger;
  private static final String address = "https://lenta.ru/";
  private static final String inputPath = "images/";

  public static void main(String[] args) {

    BasicConfigurator.configure();

    logger = org.apache.log4j.LogManager.getLogger(Main.class);

    Document document;
    try {
      document = Jsoup.connect(address).userAgent("yandex").get();   //userAgent добавляем, чтоб не считали ботом

      Elements images = document.select("img");  // получаем элементы страницы
      List<String> imageUrls = images.stream()
          .map(el -> el.attr("abs:src"))  //переведём в привычный список строк
          .filter(a -> a.contains(".jpg") || a.contains(".png") || a.contains(
              ".gif")) // отфильтруем счётчики
          .collect(Collectors.toList());
      if (!Files.exists(Paths.get(inputPath)) || !Files.isDirectory(Paths.get(inputPath))) {
        if (new File(
            inputPath).mkdir()) {   //если папка, куда копируем не существует, то создаём её
          logger.error("Создана папка: " + Paths.get(inputPath).toAbsolutePath());
        }
      }
      imageUrls.forEach(
          Main::downloadImage);    //копируем файлы по списку адресов в указанную папку
    } catch (Exception e) {
      logger.error("Возникла ошибка: " + e);       // тут фиксируем все ошибки
    }
  }

  private static void downloadImage(String urlStr) {
    String fileName = urlStr.substring(urlStr.lastIndexOf("/") + 1);  //это имя копируемого файла
    String filePlace = Main.inputPath + fileName;   // а это полный адрес назначения
    try (BufferedInputStream inputStream = new BufferedInputStream(new URL(urlStr).openStream());
        FileOutputStream outputStream = new FileOutputStream(filePlace)) {
      byte[] buffer = new byte[1024];
      int count;
      while ((count = inputStream.read(buffer, 0, 1024))
          != -1) { //читаем, пока не закончится входной поток
        outputStream.write(buffer, 0, count);                // потом записываем
      }
      outputStream.close();        // закрываем потоки
      inputStream.close();
      logger.error("Файл " + fileName + " успешно скопирован");
    } catch (IOException ex) {
      throw new RuntimeException(
          ex);   // пробрасываем необрабатываемое исключение, чтоб не пробрасывать его в лямбда-выражении
    }
  }
}