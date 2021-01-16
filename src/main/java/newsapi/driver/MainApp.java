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

public class MainApp {
    /*public static void main(String[] args) {
        // String htmlString = "<!doctype html><html xmlns=\"http://www.w3.org/1999/xhtml\" itemscope itemtype=\"http://schema.org/NewsArticle\"><head><title>Serum Institute To Stockpile Novavax Vaccine From April: Adar Poonawalla</title><meta name=\"news_keywords\" content=\"Serum Institute of India,Novavax,Coronavirus vaccine\" itemprop=\"keywords\"/><meta name=\"description\" content=\"The Serum Institute of India, the world&#039;s biggest vaccine maker, will start stockpiling millions of doses of the Novavax coronavirus vaccine candidate starting around April, CEO Adar Poonawalla told the Reuters Next conference on Thursday.\" itemprop=\"description\"/><meta name=\"section\" content=\"india\" itemprop=\"articleSection\"/><meta name=\"url\" content=\"https://www.ndtv.com/india-news/serum-institute-to-stockpile-novavax-vaccine-from-around-april-ceo-2352438\" itemprop=\"url\"/><link href=\"https://www.ndtv.com/india-news/serum-institute-to-stockpile-novavax-vaccine-from-around-april-ceo-2352438?amp=1&akamai-rum=off\" rel=\"amphtml\" ><link href=\"https://plus.google.com/+NDTV\" rel=\"publisher\" ><link href=\"android-app://com.july.ndtv/ndtv/ndtv.android/type=news/id=2352438/category=india-news\" rel=\"alternate\" ><link href=\"ios-app://377869410/ndtv/news/ndtv.com/news/view/ndtv/2352438/site=classic/\" rel=\"alternate\" ><link href=\"https://feeds2.feedburner.com/NdtvNews-TopStories\" rel=\"alternate\" type=\"application/rss+xml\" title=\"NDTV Top Stories\" ><meta name=\"keywords\" content=\"Serum Institute of India,Novavax,Coronavirus vaccine\" ><meta property=\"og:title\" content=\"Serum Institute To Stockpile Novavax Vaccine From April: Adar Poonawalla\"/><meta property=\"og:type\" content=\"article\"/><meta property=\"og:image\" content=\"https://c.ndtvimg.com/2020-11/hq3b24m_adar-poonawalla_650x400_20_November_20.jpg\"/><meta property=\"og:image:secure_url\" content=\"https://c.ndtvimg.com/2020-11/hq3b24m_adar-poonawalla_650x400_20_November_20.jpg\"/><meta property=\"og:image:width\" content=\"630\"/><meta property=\"og:image:height\" content=\"473\"/><meta property=\"og:url\" content=\"https://www.ndtv.com/india-news/serum-institute-to-stockpile-novavax-vaccine-from-around-april-ceo-2352438\"/><meta property=\"og:site_name\" content=\"NDTV.com\"/><meta property=\"og:description\" content=\"The Serum Institute of India, the world&#039;s biggest vaccine maker, will start stockpiling millions of doses of the Novavax coronavirus vaccine candidate starting around April, CEO Adar Poonawalla told the Reuters Next conference on Thursday.\"/><meta property=\"fb:app_id\" content=\"213741912058651\"/><meta property=\"al:android:url\" content=\"ndtvSocial://com.july.ndtv/ndtv/ndtv.android/type=news/id=2352438/category=india-news\"/><meta property=\"al:android:package\" content=\"com.july.ndtv\"/><meta property=\"al:android:app_name\" content=\"NDTV\"/><meta property=\"al:ios:url\" content=\"ndtv://news/ndtv.com/news/view/ndtv/2352438/site=classic/\"/><meta property=\"al:ios:app_store_id\" content=\"377869410\"/><meta property=\"al:ios:app_name\" content=\"NDTV\"/><meta property=\"al:ipad:url\" content=\"ndtvhd://news/ndtv.com/news/view/ndtv/2352438/site=classic/\"/><meta property=\"al:ipad:app_store_id\" content=\"390847563\"/><meta property=\"al:ipad:app_name\" content=\"NDTV HD\"/><meta name=\"twitter:card\" content=\"summary_large_image\"/><meta name=\"twitter:site\" content=\"@ndtv\"/><meta name=\"twitter:url\" content=\"https://www.ndtv.com/india-news/serum-institute-to-stockpile-novavax-vaccine-from-around-april-ceo-2352438\"/><meta name=\"twitter:title\" content=\"Serum Institute To Stockpile Novavax Vaccine From April: Adar Poonawalla\"/><meta name=\"twitter:description\" content=\"The Serum Institute of India, the world&#039;s biggest vaccine maker, will start stockpiling millions of doses of the Novavax coronavirus vaccine candidate starting around April, CEO Adar Poonawalla told the Reuters Next conference on Thursday.\"/><meta name=\"twitter:image\" content=\"https://c.ndtvimg.com/2020-11/hq3b24m_adar-poonawalla_650x400_20_November_20.jpg?ver-20201228.2\"/><meta name=\"twitter:app:url:iphone\" content=\"ndtv://news/ndtv.com/news/view/ndtv/2352438/site=classic/\"/><meta name=\"twitter:app:url:googleplay\" content=\"ndtvnews://www.ndtv.com/type=news/id=2352438/category=india-news\"/><meta property=\"snapchat:sticker\" content=\"https://c.ndtvimg.com/2020-11/hq3b24m_adar-poonawalla_650x400_20_November_20.jpg\" /><meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" /><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" /><meta property=\"category\" content=\"News\"/><link rel=\"preconnect\" crossorigin href=\"https://i.ndtvimg.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://social.ndtv.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://cdn.ndtv.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://drop.ndtv.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://static.social.ndtv.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://fonts.googleapis.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://fonts.gstatic.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://www.google-analytics.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://sb.scorecardresearch.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://www.googletagservices.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://securepubads.g.doubleclick.net/\" /><link rel=\"preconnect\" crossorigin href=\"https://partner.googleadservices.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://pagead2.googlesyndication.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://cdn.taboola.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://images.taboola.com/\" /><link rel=\"preconnect\" crossorigin href=\"https://cdn.taboola.com\" /><link rel=\"preconnect\" crossorigin href=\"https://trc.taboola.com/\" /><link rel=\"dns-prefetch\" href=\"//fastlane.rubiconproject.com/\"><link rel=\"preload\" as=\"script\" href=\"https://www.google-analytics.com/analytics.js\" /><link rel=manifest href=\"https://www.ndtv.com/manifest.json\" /><meta name=\"theme-color\" content=\"#e3eef9\" /><meta name=\"apple-itunes-app\" content=\"app-id=377869410 , app-argument=ndtv://news/ndtv.com/news/view/ndtv/2352438/site=classic/\"/><meta property=\"taboola:title\" content=\"Serum Institute To Stockpile Novavax Vaccine From April: Adar Poonawalla\"/><script type=\"text/javascript\" src=\"https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=uECqwk_PPvB-og2jlsYlem3wfGvfJXHQ3rVDKXUVbDpOYzthH96P5GFxwxHFgPVHMp5gJMzHZFIcEQiSsgvdNtfc7K7W1e02Ps37fvSI8vGy2YWs7GlcDCHcSKWvrZzVxL8HtSl-4CGQS-GtpZxXMNntFmqHuzQcCJaQczkgq74\" charset=\"UTF-8\"></script><link rel=\"stylesheet\" crossorigin=\"anonymous\" href=\"https://gc.kis.v2.scr.kaspersky-labs.com/E3E8934C-235A-4B0E-825A-35A08381A191/abn/main.css?attr=aHR0cHM6Ly93d3cubmR0di5jb20vaW5kaWEtbmV3cy9zZXJ1bS1pbnN0aXR1dGUtdG8tc3RvY2twaWxlLW5vdmF2YXgtdmFjY2luZS1mcm9tLWFyb3VuZC1hcHJpbC1jZW8tMjM1MjQzOA\"/><script type=\"text/javascript\"> window._rrCode = window._rrCode || [];_rrCode.push(function(){ window._taboola = window._taboola || [];";
        //Document doc = Jsoup.parse(htmlString);
        Document doc = null;
        String url = "https://news.google.com/__i/rss/rd/articles/CBMiamh0dHBzOi8vd3d3Lm5kdHYuY29tL2luZGlhLW5ld3Mvc2VydW0taW5zdGl0dXRlLXRvLXN0b2NrcGlsZS1ub3ZhdmF4LXZhY2NpbmUtZnJvbS1hcm91bmQtYXByaWwtY2VvLTIzNTI0MzjSAX9odHRwczovL3d3dy5uZHR2LmNvbS9pbmRpYS1uZXdzL3NlcnVtLWluc3RpdHV0ZS10by1zdG9ja3BpbGUtbm92YXZheC12YWNjaW5lLWZyb20tYXJvdW5kLWFwcmlsLWNlby0yMzUyNDM4P2FtcD0xJmFrYW1haS1ydW09b2Zm?oc=5";
        System.out.println("Connecting to=="+url);
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (doc != null) {
            Elements metaTags = doc.getElementsByTag("meta");
            for(Element metaTag : metaTags) {
                String content = metaTag.attr("content");
                String property = metaTag.attr("property");
                String name = metaTag.attr("name");
                if(!name.isEmpty())
                    System.out.println(name+"=="+"=="+content);
                if(!property.isEmpty())
                    System.out.println(property+"=="+content);
                if(property.equalsIgnoreCase("og:title"))
                    System.out.println(property+"=="+content);
                if(property.equalsIgnoreCase("og:type"))
                    System.out.println(property+"=="+content);
                if(property.equalsIgnoreCase("og:image"))
                    System.out.println(property+"=="+content);
                if(property.equalsIgnoreCase("og:url"))
                    System.out.println(property+"=="+content);
                if(property.equalsIgnoreCase("og:site_name"))
                    System.out.println(property+"=="+content);
                if(property.equalsIgnoreCase("og:description"))
                    System.out.println(property+"=="+content);
                if(property.equalsIgnoreCase("category"))
                    System.out.println(property+"=="+content);
            }
        }
    }*/

    public static void main(String[] args) {

        try {
            RssFeedParser rssFeedParser = new RssFeedParser(NewsSourceRssUrl.GOOGLE_NEWS_BUSINESS);
            RssFeed feed = rssFeedParser.parse();
            List<RssFeedMessage> feedMessages = feed.getEntries();
            for(RssFeedMessage message : feedMessages) {
                NewsMetaParser newsMetaParser = new NewsMetaParser(message.getLink());
                NewsArticle newsArticle = newsMetaParser.parse();
                System.out.println(newsArticle);
            }
            System.out.println("DONE");
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }

    }
}
