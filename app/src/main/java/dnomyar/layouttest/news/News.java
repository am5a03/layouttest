package dnomyar.layouttest.news;

/**
 * Created by Raymond on 2015-06-21.
 */
public class News {

    private String header;
    private String content;

    public News(String header, String content) {
        this.header = header;
        this.content = content;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

}
