package dnomyar.layouttest.apis;


import java.util.List;

import dnomyar.layouttest.apis.nytimes.NYTimesNewsResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Raymond on 2015-08-14.
 */
public interface NYTimesNewsService {
    @GET("/svc/news/v3/content/{source}/{section}.json?api-key=d5f5d1b06b3e4ed4dc5ae8387606cbed:6:72650800")
    Observable<List<NYTimesNewsResponse>> getRecentNews(@Path("source") String source,
                                                        @Path("section") String section,
                                                        @Query("limit") int limit,
                                                        @Query("offset") int offset);

    @GET("/svc/news/v3/content/{source}/{section}.json?api-key=d5f5d1b06b3e4ed4dc5ae8387606cbed:6:72650800")
    public void getRecentNewsByCallback(@Path("source") String source,
                       @Path("section") String section,
                       @Query("limit") int limit,
                       @Query("offset") int offset, Callback<NYTimesNewsResponse> cb);
}
