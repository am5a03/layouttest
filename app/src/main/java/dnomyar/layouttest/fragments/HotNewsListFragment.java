package dnomyar.layouttest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dnomyar.layouttest.R;
import dnomyar.layouttest.news.HotNewsListAdapter;
import dnomyar.layouttest.news.News;
import dnomyar.layouttest.news.NewsAdapter;

/**
 * Created by Raymond on 2015-08-02.
 */
public class HotNewsListFragment extends ListFragment {

    private ArrayList<News> mHotNewsList;
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
        View view = inflater.inflate(R.layout.fragment_list_view, null);

        initNews();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(mHotNewsListAdapter);

        return view;
    }

    @Override
    protected void initNews() {
        super.initNews();
        initHotNews();
    }

    protected void initHotNews() {
        mHotNewsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            News news = News.Builder.newBuilder()
                    .setHeader("Hot - " + i)
                    .setContent("Content " + i)
                    .setThumbnail("https://upload.wikimedia.org/wikipedia/en/7/7d/Bliss.png")
                    .build();
            mHotNewsList.add(news);
        }
        mHotNewsListAdapter = new HotNewsListAdapter(mNewsList, mHotNewsList);
//        mHotNewsListAdapter = new NewsAdapter(mNewsList);
//        mHotNewsAdapter.setHotNewsList(mHotNewsList);
    }
}
