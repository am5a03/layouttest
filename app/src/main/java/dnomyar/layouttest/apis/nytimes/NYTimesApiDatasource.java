package dnomyar.layouttest.apis.nytimes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import dnomyar.layouttest.apis.nytimes.models.NYTimesNewsResponse;
import dnomyar.layouttest.apis.nytimes.models.Result;
import dnomyar.layouttest.datasource.NYTimesNewsConverter;
import dnomyar.layouttest.datasource.NewsDatasourceInterface;
import dnomyar.layouttest.models.News;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Raymond on 2015-08-15.
 */
public class NYTimesApiDatasource implements NewsDatasourceInterface {
    private final NYTimesNewsService mNYTimesNewsService;
    private final NYTimesNewsConverter mNYTimesNewsConverter;

    public NYTimesApiDatasource() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.nytimes.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(registerTypeAdapter())
                .build();
        mNYTimesNewsService = restAdapter.create(NYTimesNewsService.class);
        mNYTimesNewsConverter = new NYTimesNewsConverter();
    }

    public NYTimesNewsService getNYTimesNewsService() {
        return mNYTimesNewsService;
    }

    @Override
    public Observable<List<News>> getRecentNews(int limit, int offset) {
        return mNYTimesNewsService
                .getRecentNews("all", "all", limit, offset)
                .subscribeOn(Schedulers.io())
                .map(mNYTimesNewsConverter::convertNews)
                .observeOn(AndroidSchedulers.mainThread());
    }

//    public void getRecentNewsByCallback(int offset, Callback<NYTimesNewsResponse> cb) {
//        mNYTimesNewsService.getRecentNewsByCallback("all", "all", 10, offset, cb);
//    };

    protected GsonConverter registerTypeAdapter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Result.class, new Result.ResultDeserializer());
        Gson gson = gsonBuilder.create();
        return new GsonConverter(gson);
    }
}
