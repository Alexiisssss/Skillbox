import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.*;


public class Main {

  public static String url;
  public static CopyOnWriteArrayList<String> turnList = new CopyOnWriteArrayList<>();
  public static ArrayList<String> turnPrintList = new ArrayList<>();
  private static PrintWriter textFile;
  private static final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> siteMap = new ConcurrentHashMap<>();
  private static int index = 1;
  private static final int numOfThread = Runtime.getRuntime().availableProcessors();

  private static ExecutorService service;


  public static void main(String[] args) throws IOException {

    url = "https://Skillbox.ru/";
    turnList.add(url);

    String textFileName = "list.txt";
    textFile = new PrintWriter("src/data/" + textFileName);

    service = Executors.newFixedThreadPool(numOfThread);

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(
        numOfThread / 2);

    for (int i = 0; i < numOfThread / 2; i++) {

      scheduledExecutorService.scheduleAtFixedRate(() -> {
        try {
          tread();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }, 0, 1, TimeUnit.SECONDS);
    }

    while (turnList.size() > 0) {
    }
    scheduledExecutorService.shutdown();

    textFile.write(url + "\n");
    turnPrintList.add(url);
    print(url);
    textFile.flush();
    textFile.close();
  }


  public static CopyOnWriteArrayList<String> searchLink(String urlSite) throws IOException {

    Document doc = Jsoup.connect(urlSite).userAgent("yandex").get();

    CopyOnWriteArrayList<String> linkList = new CopyOnWriteArrayList<>();
    linkList.clear();

    for (Element e : doc.select("a")) {
      String link = e.attr("abs:href");

      if (link.regionMatches(true, 0, url, 0, url.length()) && link.length() > url.length()
          && link.matches(url + "[a-zA-Z0-9_\\-/]+[a-zA-Z0-9_\\-]+[/]?")
          && !urlSite.equals(link)
          && !linkList.contains(link)) {
//                System.out.println(urlSite.get(0) + " " + link);
        linkList.add(link);
        String good = link;

        if (!siteMap.containsKey(good) && !turnList.contains(good)) {
          System.out.println(good);
          turnList.add(good);
        }
      }
    }
    return linkList;
  }

  public static void print(String url) throws IOException {

    for (String prints : siteMap.get(url)) {

      for (int j = 0; j < index; j++) {
        textFile.write("\t");
      }
      textFile.write(prints + "\n");

      if (!turnPrintList.contains(prints)) {
        turnPrintList.add(prints);
        if (siteMap.containsKey(prints)) {
          index++;
          print(prints);
        }
      }
    }
    index--;
  }

  public static void tread() throws IOException {

    while (!turnList.isEmpty()) {

      String urlSite = turnList.get(0);
      siteMap.put(urlSite, searchLink(urlSite));

      turnList.remove(0);
    }
  }
}
