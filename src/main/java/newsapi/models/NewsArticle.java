package newsapi.models;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringJoiner;

public class NewsArticle {
    private String sourceUrl;
    private String url;
    private String title;
    private String type;
    private String description;
    private String publishDate;
    private String imageUrl;
    private String imageSecureUrl;
    private String imageWidth;
    private String imageHeight;
    private String siteName;
    private String siteIconUrl;

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        try {
            URL siteUrl = new URL(url);
            this.siteIconUrl = "https://icons.duckduckgo.com/ip3/"+siteUrl.getHost()+".ico";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageSecureUrl() {
        return imageSecureUrl;
    }

    public void setImageSecureUrl(String imageSecureUrl) {
        this.imageSecureUrl = imageSecureUrl;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteIconUrl() {
        return siteIconUrl;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NewsArticle.class.getSimpleName() + "[", "]")
                .add("url='" + url + "'")
                .add("title='" + title + "'")
                .add("type='" + type + "'")
                .add("description='" + description + "'")
                .add("publishDate='" + publishDate + "'")
                .add("imageUrl='" + imageUrl + "'")
                .add("imageSecureUrl='" + imageSecureUrl + "'")
                .add("imageWidth='" + imageWidth + "'")
                .add("imageHeight='" + imageHeight + "'")
                .add("siteName='" + siteName + "'")
                .add("siteIconUrl='" + siteIconUrl + "'")
                .add("sourceUrl='" + sourceUrl + "'")
                .toString();
    }
}
