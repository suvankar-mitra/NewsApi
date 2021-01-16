package newsapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RssFeed {
    private String title;
    private String link;
    private String description;
    private String language;
    private String copyright;
    private String pubDate;

    public RssFeed(String title, String link, String description, String language, String copyright, String pubDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
    }

    private List<RssFeedMessage> entries = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public List<RssFeedMessage> getEntries() {
        return entries;
    }

    public void setEntries(List<RssFeedMessage> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RssFeed.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("link='" + link + "'")
                .add("description='" + description + "'")
                .add("language='" + language + "'")
                .add("copyright='" + copyright + "'")
                .add("pubDate='" + pubDate + "'")
                .add("entries=" + entries)
                .toString();
    }
}
