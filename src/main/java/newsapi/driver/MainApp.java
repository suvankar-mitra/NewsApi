package newsapi.driver;

import newsapi.models.NewsArticle;
import newsapi.models.NewsSourceRssUrl;
import newsapi.models.RssFeed;
import newsapi.models.RssFeedMessage;
import newsapi.sources.NewsMetaParser;
import newsapi.sources.rss.RssFeedParser;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class MainApp {

    public static void main(String[] args) {

        final String USAGE = "java -cp NewsApi-1.0-SNAPSHOT-jar-with-dependencies.jar newsapi.driver.MainApp [Source] [Optional parameters]\n" +
                "Source:\n" +
                "\t[ world / top / business / technology / sports / entertainment / science / health ]\n" +
                "Optional parameters:\n" +
                "\t<number> -- Limit number of responses" +
                "\n\n" +
                "E.g.\n" +
                "java -cp NewsApi-1.0-SNAPSHOT-jar-with-dependencies.jar newsapi.driver.MainApp business 5\n";

        if(args.length < 1) {
            System.out.println(ansi().fg(GREEN).a("Usage: ").reset().a(USAGE));
            System.exit(0);
        }

        final String topic = args[0];
        if(!NewsSourceRssUrl.TOPICS.containsKey(topic)) {
            System.out.println(ansi().fg(RED).a("This topic '"+topic+"' is not supported.").reset());
            System.out.println(ansi().fg(GREEN).a("Usage: ").reset().a(USAGE));
            System.exit(0);
        }
        int limit = Integer.MAX_VALUE;
        try {
            if (args.length == 2) {
                limit = Integer.parseInt(args[1]);
            }
        } catch (Exception e) {
            //silently ignore
        }

        if(limit < Integer.MAX_VALUE) {
            System.out.println(ansi().fg(MAGENTA).a("Getting top "+limit+" "+topic.toUpperCase(Locale.ROOT)+" News!").reset());
            System.out.println();
        } else {
            System.out.println(ansi().fg(MAGENTA).a("Getting "+topic.toUpperCase(Locale.ROOT)+" News!").reset());
            System.out.println();
        }


        try {
            RssFeedParser rssFeedParser = new RssFeedParser(NewsSourceRssUrl.TOPICS.get(topic));
            RssFeed feed = rssFeedParser.parse();
            List<RssFeedMessage> feedMessages = feed.getEntries();
            int k = 0;
            for(RssFeedMessage message : feedMessages) {
                NewsMetaParser newsMetaParser = new NewsMetaParser(message.getLink());
                NewsArticle newsArticle = newsMetaParser.parse();
                if(newsArticle != null
                        && newsArticle.getType() != null
                        && newsArticle.getType().toLowerCase(Locale.ROOT).contains("article")) {
                    System.out.println();
                    System.out.println(ansi().fg(GREEN).a(newsArticle.getTitle()).reset());
                    System.out.println(newsArticle.getDescription());
                    System.out.println(ansi().fg(CYAN).a("["+newsArticle.getUrl()+"]").reset());
                    System.out.print(ansi().fg(MAGENTA).a(newsArticle.getSiteName()));
                    if(newsArticle.getPublishDate() != null)
                        System.out.println(ansi().fg(MAGENTA).a(" | "+newsArticle.getPublishDate()).reset());
                    System.out.println();
                    if(++k >= limit)
                        break;
                }
            }
            System.out.println("DONE");
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }

    }
}
