package dnomyar.layouttest.datasource;

import java.util.List;


import dnomyar.layouttest.models.News;
import rx.Observable;

/**
 * Created by Raymond on 2015-08-16.
 */
public interface NewsDatasourceInterface extends DatasourceInterface {
    Observable<List<News>> getRecentNews(int limit, int offset);
}
