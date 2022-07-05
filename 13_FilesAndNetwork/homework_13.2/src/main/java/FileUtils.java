import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.OutputStreamManager;


public class FileUtils {


  private FileUtils() {
  }

  private static final Logger log = LogManager.getLogger(FileUtils.class);


  public static boolean checkPath(String directory) {
    try {
      return Files.isDirectory(Path.of(directory));
    } catch (Exception e) {
      log.error("Не удалось считать путь к папке");
      log.error(e.getMessage());
      return true;
    }
  }

  public static boolean checkPaths(String sourceDirectory, String destinationDirectory) {
    try {
      var pathSource = Path.of(sourceDirectory);
      var pathDestination = Path.of(destinationDirectory);
      return (Files.isDirectory(pathSource) &&
          Files.isDirectory(pathDestination) &&
          !pathSource.equals(pathDestination));
    } catch (Exception e) {
      log.error("Не удалось считать путь к папкам");
      log.error(e.getMessage());
      return false;
    }
  }

  public static void copyFolder(String sourceDirectory, String destinationDirectory) {

    if (checkPaths(sourceDirectory, destinationDirectory)) {
      try
          (Stream<Path> path = Files.walk(Paths.get(sourceDirectory))) {
        path.forEach(source -> {
          var destination = Paths.get(destinationDirectory,
              source.toString().substring(sourceDirectory.length()));
          try {
            Files.copy(source, destination);
          } catch (IOException e) {
            log.error(e.getMessage());
          }
        });
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    } else {
      log.info("Данные не скопированы из одной папки в другую");
    }
  }
}