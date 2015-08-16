package dnomyar.layouttest.datasource;

import java.util.List;

import dnomyar.layouttest.apis.nytimes.models.NYTimesNewsResponse;
import dnomyar.layouttest.models.News;

/**
 * Created by Raymond on 2015-08-16.
 */
public interface ConverterInterface<E> {
    List<News> convertNews(E newsResponse);
}
