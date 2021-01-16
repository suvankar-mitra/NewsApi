package newsapi.sources;

import newsapi.models.NewsArticle;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NewsMetaParser {
    final String newsArticleUrl;

    final static String URL = "og:url";
    final static String TITLE = "og:title";
    final static String TYPE = "og:type";
    final static String DESCRIPTION = "og:description";
    final static String DESCRIPTION2 = "description";
    final static String PUB_DATE = "publish-date";
    final static String PUB_DATE2 = "article:published_time";
    final static String IMAGE_URL = "og:image";
    final static String IMAGE_SECURE_URL = "og:image:secure_url";
    final static String IMAGE_WIDTH = "og:image:width";
    final static String IMAGE_HEIGHT = "og:image:height";
    final static String SITE_NAME = "og:site_name";


    public NewsMetaParser(String newsArticleUrl) {
        this.newsArticleUrl = newsArticleUrl;
    }

    public NewsArticle parse() {
        NewsArticle newsArticle = new NewsArticle();
        newsArticle.setSourceUrl(newsArticleUrl);

        Document doc;
        try {
            doc = Jsoup.connect(newsArticleUrl).get();
        } catch (IOException e) {
            //e.printStackTrace(); // silently fail
            return null;
        }

        if (doc != null) {
            Elements metaTags = doc.getElementsByTag("meta");
            for(Element metaTag : metaTags) {
                String content = metaTag.attr("content");
                String property = metaTag.attr("property");
                String name = metaTag.attr("name");
                String key = property.isEmpty() ? name : property;

                switch (key) {
                    case URL:
                        newsArticle.setUrl(content);
                        break;
                    case TITLE:
                        newsArticle.setTitle(content);
                        break;
                    case TYPE:
                        newsArticle.setType(content);
                        break;
                    case DESCRIPTION:
                    case DESCRIPTION2:
                        if(newsArticle.getDescription() == null)
                            newsArticle.setDescription(content);
                        break;
                    case PUB_DATE:
                    case PUB_DATE2:
                        if(newsArticle.getPublishDate() == null)
                            newsArticle.setPublishDate(content);
                        break;
                    case IMAGE_URL:
                        newsArticle.setImageUrl(content);
                        break;
                    case IMAGE_SECURE_URL:
                        newsArticle.setImageSecureUrl(content);
                        break;
                    case IMAGE_WIDTH:
                        newsArticle.setImageWidth(content);
                        break;
                    case IMAGE_HEIGHT:
                        newsArticle.setImageHeight(content);
                        break;
                    case SITE_NAME:
                        newsArticle.setSiteName(content);
                        break;
                }
            }
        }

        return newsArticle;
    }
}
