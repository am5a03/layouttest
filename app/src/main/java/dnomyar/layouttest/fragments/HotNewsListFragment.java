package dnomyar.layouttest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dnomyar.layouttest.R;
import dnomyar.layouttest.adapters.HotNewsListAdapter;
import dnomyar.layouttest.apis.nytimes.NYTimesApiDatasource;
import dnomyar.layouttest.models.News;
import rx.functions.Action1;

/**
 * Created by Raymond on 2015-08-02.
 */
public class HotNewsListFragment extends ListFragment {
    private static final String TAG = "HotNewsListFragment";
    private HotNewsListAdapter mHotNewsListAdapter;


    public static HotNewsListFragment newInstance(String title) {

        Bundle args = new Bundle();

        args.putString("title", title);

        HotNewsListFragment fragment = new HotNewsListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        initNews();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(mHotNewsListAdapter);
        recyclerView.addOnScrollListener(mOnScrollListener);

        return view;
    }

    @Override
    protected void initNews() {
        super.initNews();
        mHotNewsListAdapter = new HotNewsListAdapter(mNewsList);
    }

//    @Override
//    protected void loadNewsCallback(List<News> newses) {
//        super.loadNewsCallback(newses);
//        mHotNewsListAdapter.notifyDataSetChanged();
//    }

//    protected void initHotNews() {
//        mHotNewsList = new ArrayList<>();
//        mHotNewsListAdapter = new HotNewsListAdapter(mNewsList, mHotNewsList);
//
//
//        NYTimesApiDatasource apiDatasource = new NYTimesApiDatasource();
//        apiDatasource.getRecentNews(10, 11).subscribe(new Action1<List<News>>() {
//            @Override
//            public void call(List<News> newses) {
//                mHotNewsList.addAll(newses);
//                mHotNewsListAdapter.notifyDataSetChanged();
//                loadNewsCallback(newses);
//            }
//        });
////        manager.getRecentNewsByCallback(0, new Callback<NYTimesNewsResponse>() {
////            @Override
////            public void success(NYTimesNewsResponse nyTimesNewsResponse, Response response) {
////                Log.d(TAG, "success " + nyTimesNewsResponse.getNumResults());
////            }
////
////            @Override
////            public void failure(RetrofitError error) {
////                Log.d(TAG, "failure " + error.toString(), error.fillInStackTrace());
////            }
////        });
//
//
////    new Thread(()->{
////        try {
////
////            NYTimesApiDatasource manager = new NYTimesApiDatasource();
////
////            manager.getRecentNewsByCallback(0, new Callback<NYTimesNewsResponse>() {
////                @Override
////                public void success(NYTimesNewsResponse nyTimesNewsResponse, Response response) {
////                    Log.d(TAG, "success " + nyTimesNewsResponse.getNumResults());
////                }
////
////                @Override
////                public void failure(RetrofitError error) {
////                    Log.d(TAG, "failure " + error.getMessage());
////                }
////            });
////
////
////
////            Thread.sleep(1);
////            for (int i = 0; i < 10; i++) {
////                News news = News.Builder.newBuilder()
////                        .setHeader("Hot - " + i)
////                        .setContent("Content " + i)
////                        .setThumbnail("https://upload.wikimedia.org/wikipedia/en/7/7d/Bliss.png")
////                        .build();
////                mHotNewsList.add(news);
////            }
////
////            new Handler(Looper.getMainLooper()).post(mHotNewsListAdapter::notifyDataSetChanged);
////        } catch (InterruptedException e) {}
////    }).start();
//
//
////        mHotNewsListAdapter = new NewsAdapter(mNewsList);
////        mHotNewsAdapter.setHotNewsList(mHotNewsList);
//    }
}
