package dnomyar.layouttest.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dnomyar.layouttest.R;
import dnomyar.layouttest.models.News;
import dnomyar.layouttest.renderers.HotNewsListRenderer;

/**
 * Created by Raymond on 2015-08-09.
 */
public class HotNewsListAdapter extends NewsAdapter {
    private static final String TAG = "HotNewsListAdapter";
    private HotNewsListRenderer mHotNewsListRenderer;
    private HotNewsAdapter mHotNewsAdapter;

    public HotNewsListAdapter(List<News> newsList, List<News> hotNewsList) {
        super(newsList);
        mHotNewsAdapter = new HotNewsAdapter(hotNewsList);
        mHotNewsListRenderer = new HotNewsListRenderer(mHotNewsAdapter);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HOT_LIST_ITEM) {
            return mHotNewsListRenderer.onCreateViewHolder(parent, viewType);
        } else {
            return super.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);

        if (viewType == VIEW_TYPE_HOT_LIST_ITEM) {
            mHotNewsListRenderer.onBindViewHolder(viewHolder, position);
        } else {
            super.onBindViewHolder(viewHolder, position);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_HOT_LIST_ITEM;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    @Override
    protected int mapPositionToItemPosition(int position) {
        return super.mapPositionToItemPosition(position) - 1;
    }
}
