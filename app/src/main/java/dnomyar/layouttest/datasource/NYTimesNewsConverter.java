package dnomyar.layouttest.datasource;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import dnomyar.layouttest.apis.nytimes.models.NYTimesNewsResponse;
import dnomyar.layouttest.apis.nytimes.models.Result;
import dnomyar.layouttest.models.News;

/**
 * Created by Raymond on 2015-08-16.
 */
public class NYTimesNewsConverter implements ConverterInterface<NYTimesNewsResponse> {
    public List<News> convertNews(NYTimesNewsResponse responses) {
        List<News> newsList = new CopyOnWriteArrayList<>();
        List<Result> results = responses.getResults();
        for (Result result: results) {
            News news = News.Builder.newBuilder()
                    .setHeader(result.getTitle())
                    .setContent(result.getAbstract())
                    .build();
            if (result.getMultimedia() != null &&
                    result.getMultimedia().size() > 0) {
                news.setThumbnail(result.getMultimedia().get(0).getUrl());
            }
            newsList.add(news);
        }
        return newsList;
    }
}
