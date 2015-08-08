package dnomyar.layouttest.news;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dnomyar.layouttest.R;

/**
 * Created by Raymond on 2015-08-09.
 */
public class HotNewsListAdapter extends NewsAdapter {

    private static final int VIEW_TYPE_HOT_LIST = 0;
    private static final int VIEW_TYPE_NORMAL_LIST = 1;

    private HotNewsAdapter mHotNewsAdapter;

    public HotNewsListAdapter(List<News> newsList, List<News> hotNewsList) {
        super(newsList);
        mHotNewsAdapter = new HotNewsAdapter(hotNewsList);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HOT_LIST:
                Context context = parent.getContext();
                View view = LayoutInflater.from(context).inflate(R.layout.hot_news_list, parent, false);
                HotNewsListViewHolder holder = new HotNewsListViewHolder(view);
                return holder;
            case VIEW_TYPE_NORMAL_LIST:
                return super.onCreateViewHolder(parent, viewType);
            default:
                return super.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);

        if (viewType == VIEW_TYPE_HOT_LIST) {
            HotNewsListViewHolder holder = (HotNewsListViewHolder) viewHolder;
            Context context = holder.mRecyclerView.getContext();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            holder.mRecyclerView.setAdapter(mHotNewsAdapter);
            holder.mRecyclerView.setLayoutManager(linearLayoutManager);
        } else {
            super.onBindViewHolder(viewHolder, position);
        }
    }


    public static class HotNewsListViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        public HotNewsListViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_HOT_LIST;
        }
        return VIEW_TYPE_NORMAL_LIST;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 1;
    }
}
