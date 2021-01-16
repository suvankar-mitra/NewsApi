package newsapi.models;

import java.util.StringJoiner;

public class RssFeedMessage {
    private String title;
    private String description;
    private String link;
    private String source;
    private String author;
    private String guid;
    private String publishDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RssFeedMessage.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("description='" + description + "'")
                .add("link='" + link + "'")
                .add("source='" + source + "'")
                .add("author='" + author + "'")
                .add("guid='" + guid + "'")
                .add("publishDate='" + publishDate + "'")
                .toString();
    }
}
