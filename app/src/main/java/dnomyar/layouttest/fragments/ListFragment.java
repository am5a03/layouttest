package dnomyar.layouttest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dnomyar.layouttest.R;
import dnomyar.layouttest.apis.nytimes.NYTimesApiDatasource;
import dnomyar.layouttest.models.News;
import dnomyar.layouttest.adapters.NewsAdapter;
import rx.functions.Action1;

/**
 * Created by Raymond on 2015-08-01.
 */
public class ListFragment extends Fragment {
    private static final String TAG = "ListFragment";
    ArrayList<News> mNewsList;
    private NewsAdapter mNewsAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected NYTimesApiDatasource mNYTimesApiDatasource;

    public static ListFragment newInstance(String title) {

        Bundle args = new Bundle();

        args.putString("title", title);

        ListFragment fragment = new ListFragment();
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
        recyclerView.setAdapter(mNewsAdapter);
        recyclerView.addOnScrollListener(mOnScrollListener);

        return view;
    }

    protected RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            LinearLayoutManager lm = (LinearLayoutManager) recyclerView.getLayoutManager();
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            LinearLayoutManager lm = (LinearLayoutManager) recyclerView.getLayoutManager();
//            lm.findLastVisibleItemPosition() == recyclerView.getAdapter().getItemCount();
            super.onScrolled(recyclerView, dx, dy);
        }
    };

    protected void initNews() {
        mNYTimesApiDatasource = new NYTimesApiDatasource();
        mNewsList = new ArrayList<>();
        mNewsAdapter = new NewsAdapter(mNewsList);
        mNYTimesApiDatasource.getRecentNews(10, 0)
                .subscribe(new Action1<List<News>>() {
                    @Override
                    public void call(List<News> newses) {
                        mNewsList.clear();
                        mNewsList.addAll(newses);
                        mNewsAdapter.notifyDataSetChanged();
                    }
                });
//        Bundle bundle = getArguments();
//        String title = "";
//        if (bundle != null) {
//            title = bundle.getString("title");
//        }
//
//        for (int i = 0; i < 10; i++) {
//            News news = News.Builder.newBuilder()
//                    .setHeader(title + "-" + i)
//                    .setContent("Summary " + i)
//                    .setThumbnail("http://www.seanews.com.tr/images/article/2014_04/124917/hk.jpg")
//                    .build();
//            mNewsList.add(news);
//        }
//
//        mNewsAdapter = new NewsAdapter(mNewsList);
    }


}
