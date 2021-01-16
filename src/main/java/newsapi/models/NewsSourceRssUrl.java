package newsapi.models;

import java.util.HashMap;
import java.util.Map;

public class NewsSourceRssUrl {
    private final static String GOOGLE_NEWS_WORLD = "https://news.google.com/rss/topics/CAAqJggKIiBDQkFTRWdvSUwyMHZNRGx1YlY4U0FtVnVHZ0pKVGlnQVAB?hl=en-IN&gl=IN&ceid=IN%3Aen";
    private final static String GOOGLE_NEWS_INDIA_TOP = "https://news.google.com/rss?hl=en-IN&gl=IN&ceid=IN:en";
    private final static String GOOGLE_NEWS_BUSINESS = "https://news.google.com/rss/topics/CAAqJggKIiBDQkFTRWdvSUwyMHZNRGx6TVdZU0FtVnVHZ0pKVGlnQVAB?hl=en-IN&gl=IN&ceid=IN%3Aen";
    private final static String GOOGLE_NEWS_TECHNOLOGY = "https://news.google.com/rss/topics/CAAqJggKIiBDQkFTRWdvSUwyMHZNRGRqTVhZU0FtVnVHZ0pKVGlnQVAB?hl=en-IN&gl=IN&ceid=IN%3Aen";
    private final static String GOOGLE_NEWS_ENTERTAINMENT = "https://news.google.com/rss/topics/CAAqJggKIiBDQkFTRWdvSUwyMHZNREpxYW5RU0FtVnVHZ0pKVGlnQVAB?hl=en-IN&gl=IN&ceid=IN%3Aen";
    private final static String GOOGLE_NEWS_SPORTS = "https://news.google.com/rss/topics/CAAqJggKIiBDQkFTRWdvSUwyMHZNRFp1ZEdvU0FtVnVHZ0pKVGlnQVAB?hl=en-IN&gl=IN&ceid=IN%3Aen";
    private final static String GOOGLE_NEWS_SCIENCE = "https://news.google.com/rss/topics/CAAqJggKIiBDQkFTRWdvSUwyMHZNRFp0Y1RjU0FtVnVHZ0pKVGlnQVAB?hl=en-IN&gl=IN&ceid=IN%3Aen";
    private final static String GOOGLE_NEWS_HEALTH = "https://news.google.com/rss/topics/CAAqIQgKIhtDQkFTRGdvSUwyMHZNR3QwTlRFU0FtVnVLQUFQAQ?hl=en-IN&gl=IN&ceid=IN%3Aen";

    public final static Map<String, String> TOPICS = new HashMap<>();

    static {
        TOPICS.put("world", GOOGLE_NEWS_WORLD);
        TOPICS.put("top", GOOGLE_NEWS_INDIA_TOP);
        TOPICS.put("business", GOOGLE_NEWS_BUSINESS);
        TOPICS.put("technology", GOOGLE_NEWS_TECHNOLOGY);
        TOPICS.put("entertainment", GOOGLE_NEWS_ENTERTAINMENT);
        TOPICS.put("sports", GOOGLE_NEWS_SPORTS);
        TOPICS.put("science", GOOGLE_NEWS_SCIENCE);
        TOPICS.put("health", GOOGLE_NEWS_HEALTH);
    }
}
