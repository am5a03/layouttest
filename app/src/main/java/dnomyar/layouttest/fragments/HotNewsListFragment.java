package dnomyar.layouttest.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dnomyar.layouttest.R;
import dnomyar.layouttest.adapters.HotNewsListAdapter;
import dnomyar.layouttest.models.News;

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
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

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
        mHotNewsListAdapter = new HotNewsListAdapter(mNewsList, mHotNewsList);



        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    for (int i = 0; i < 10; i++) {
                        News news = News.Builder.newBuilder()
                                .setHeader("Hot - " + i)
                                .setContent("Content " + i)
                                .setThumbnail("https://upload.wikimedia.org/wikipedia/en/7/7d/Bliss.png")
                                .build();
                        mHotNewsList.add(news);
                    }

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            mHotNewsListAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (InterruptedException e) {}
            }
        }).start();



//        mHotNewsListAdapter = new NewsAdapter(mNewsList);
//        mHotNewsAdapter.setHotNewsList(mHotNewsList);
    }
}
