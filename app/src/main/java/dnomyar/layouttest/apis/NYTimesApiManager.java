package dnomyar.layouttest.apis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import dnomyar.layouttest.apis.nytimes.NYTimesNewsResponse;
import dnomyar.layouttest.apis.nytimes.Result;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Raymond on 2015-08-15.
 */
public class NYTimesApiManager {
    private final NYTimesNewsService mNYTimesNewsService;

    public NYTimesApiManager() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.nytimes.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(registerTypeAdapter())
                .build();
        mNYTimesNewsService = restAdapter.create(NYTimesNewsService.class);
    }

    public NYTimesNewsService getNYTimesNewsService() {
        return mNYTimesNewsService;
    }

    public Observable<List<NYTimesNewsResponse>> getRecentNews(int offset) {
        return mNYTimesNewsService
                .getRecentNews("all", "all", 10, offset)
                .subscribeOn(Schedulers.io())
                .map(new Func1<List<NYTimesNewsResponse>, List<NYTimesNewsResponse>>() {
                    @Override
                    public List<NYTimesNewsResponse> call(List<NYTimesNewsResponse> nyTimesNewsResponses) {
                        for (NYTimesNewsResponse response : nyTimesNewsResponses) {
//                            System.out.println(response.results[0]);
                        }
                        return nyTimesNewsResponses;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void getRecentNewsByCallback(int offset, Callback<NYTimesNewsResponse> cb) {
        mNYTimesNewsService.getRecentNewsByCallback("all", "all", 10, offset, cb);
    };

    protected GsonConverter registerTypeAdapter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Result.class, new Result.ResultDeserializer());
        Gson gson = gsonBuilder.create();
        return new GsonConverter(gson);
    }
}
