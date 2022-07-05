import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FileUtils {

  private FileUtils() {
  }

  private static final Logger log = LogManager.getLogger(FileUtils.class);
  private static final String BYTE = "Bytes";
  private static final String KILOBYTE = "Kb";
  private static final String MEGABYTE = "Mb";
  private static final String GIGABYTE = "Gb";
  private static final long SIZE_1024 = 1024;
  private static final long SIZE_0 = 0;

  public static boolean checkPath(String path) {
    var folder = new File(path);
    if (folder.isDirectory()) {
      return true;
    } else {
      log.info("Приведенный путь не ведет к папке");
      return false;
    }
  }

  public static long calculateFolderSize(String path) throws IOException {
    long sizeFiles = -1;

    try (Stream<Path> input = Files.walk(new File(path).toPath())) {
      sizeFiles = input.map(Path::toFile)
          .filter(File::isFile)
          .mapToLong(File::length).sum();
      dimensionFileSize(sizeFiles);
    } catch (IOException ex) {
      log.error(ex.getMessage());
    }
    return sizeFiles;
  }

  private static void dimensionFileSize(long size) {

    if (size >= SIZE_0) {
      String dimension = BYTE;
      if (size > SIZE_1024) {
        size = size / SIZE_1024;
        dimension = KILOBYTE;
      }
      if (size > SIZE_1024) {
        size = size / SIZE_1024;
        dimension = MEGABYTE;
      }
      if (size > SIZE_1024) {
        size = size / SIZE_1024;
        dimension = GIGABYTE;
      }
      if (log.isInfoEnabled()) {
        log.info(String.format(" (%s) %s", size, dimension));
      }
    }
  }
}

