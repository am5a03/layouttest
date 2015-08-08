package dnomyar.layouttest.news;

/**
 * Created by Raymond on 2015-06-21.
 */
public class News {

    String header;
    String content;
    String mThumbnail;

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

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

    public static class Builder {
        String mHeader;
        String mContent;
        String mThumbnail;

        News mNews;

        private Builder(){}

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder setHeader(String header) {
            this.mHeader = header;
            return this;
        }

        public Builder setContent(String content) {
            this.mContent = content;
            return this;
        }

        public Builder setThumbnail(String thumbnail) {
            this.mThumbnail = thumbnail;
            return this;
        }

        public News build() {
            mNews.setHeader(mHeader);
            mNews.setContent(mContent);
            mNews.setThumbnail(mThumbnail);
            return mNews;
        }
    }
}
