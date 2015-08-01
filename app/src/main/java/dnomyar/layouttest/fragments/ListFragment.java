package dnomyar.layouttest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dnomyar.layouttest.R;
import dnomyar.layouttest.news.News;
import dnomyar.layouttest.news.NewsAdapter;

/**
 * Created by Raymond on 2015-08-01.
 */
public class ListFragment extends Fragment {

    private ArrayList<News> mNewsList;
    private NewsAdapter mNewsAdapter;

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
        View view = inflater.inflate(R.layout.fragment_list_view, null);

        initNews();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(mNewsAdapter);

        return view;
    }

    private void initNews() {
        mNewsList = new ArrayList<>();
        Bundle bundle = getArguments();
        String title = "";
        if (bundle != null) {
            title = bundle.getString("title");
        }

        for (int i = 0; i < 300; i++) {
            mNewsList.add(new News(title + "-" + i, "Summary " + i));
        }

        mNewsAdapter = new NewsAdapter(mNewsList);
    }
}
