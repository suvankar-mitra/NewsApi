package newsapi.sources.rss;

import newsapi.models.RssFeed;
import newsapi.models.RssFeedMessage;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class RssFeedParser {
    static final String TITLE = "title";
    static final String DESCRIPTION = "description";
    static final String CHANNEL = "channel";
    static final String LANGUAGE = "language";
    static final String COPYRIGHT = "copyright";
    static final String LINK = "link";
    static final String SOURCE = "source";
    static final String AUTHOR = "author";
    static final String ITEM = "item";
    static final String PUB_DATE = "pubDate";
    static final String GUID = "guid";

    final URL url;

    public RssFeedParser(String rssFeedUrl) throws MalformedURLException {
        this.url = new URL(rssFeedUrl);
    }

    public RssFeed parse() throws IOException, XMLStreamException {
        RssFeed feed = null;

        boolean isHeader = true;

        String title = null;
        String link = null;
        String description = null;
        String language = null;
        String copyright = null;
        String source = null;
        String author = null;
        String guid = null;
        String publishDate = null;

        // open the URL as input stream and prepare to read the xml
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        InputStream in = openUrlToRead();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(in);

        // read xml top to bottom
        while(xmlEventReader.hasNext()) {
            XMLEvent event = xmlEventReader.nextEvent();
            if(event.isStartElement()) {
                String localPart = event.asStartElement().getName().getLocalPart();
                switch (localPart) {
                    case ITEM: {
                        if (isHeader) {
                            isHeader = false;
                            feed = new RssFeed(title, link, description, language, copyright, publishDate);
                        }
                        break;
                    }
                    case TITLE: {
                        title = getCharacterData(xmlEventReader);
                        break;
                    }
                    case DESCRIPTION: {
                        description = getCharacterData(xmlEventReader);
                        break;
                    }
                    case LANGUAGE: {
                        language = getCharacterData(xmlEventReader);
                        break;
                    }
                    case COPYRIGHT: {
                        copyright = getCharacterData(xmlEventReader);
                        break;
                    }
                    case LINK: {
                        link = getCharacterData(xmlEventReader);
                        break;
                    }
                    case SOURCE: {
                        source = getCharacterData(xmlEventReader);
                        break;
                    }
                    case AUTHOR: {
                        author = getCharacterData(xmlEventReader);
                        break;
                    }
                    case PUB_DATE: {
                        publishDate = getCharacterData(xmlEventReader);
                        break;
                    }
                    case GUID: {
                        guid = getCharacterData(xmlEventReader);
                        break;
                    }
                }
            } else if (event.isEndElement()) {
                String localPart = event.asEndElement().getName().getLocalPart();
                if(localPart.equals(ITEM)) {
                    RssFeedMessage rssFeedMessage = new RssFeedMessage();
                    rssFeedMessage.setDescription(description);
                    rssFeedMessage.setGuid(guid);
                    rssFeedMessage.setTitle(title);
                    rssFeedMessage.setLink(link);
                    rssFeedMessage.setSource(source);
                    rssFeedMessage.setAuthor(author);
                    rssFeedMessage.setPublishDate(publishDate);

                    if (feed != null) {
                        feed.getEntries().add(rssFeedMessage);
                    }

                    xmlEventReader.nextEvent();
                }
            }
        }

        return feed;
    }

    private String getCharacterData(XMLEventReader xmlEventReader) throws XMLStreamException {
        XMLEvent event = xmlEventReader.nextEvent();
        if(event.isCharacters()) {
            return event.asCharacters().getData();
        }
        return null;
    }

    private InputStream openUrlToRead() throws IOException {
        return url.openStream();
    }
}
