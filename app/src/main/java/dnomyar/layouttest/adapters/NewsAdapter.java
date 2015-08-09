package dnomyar.layouttest.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import dnomyar.layouttest.models.News;
import dnomyar.layouttest.renderers.NewsRenderer;
import dnomyar.layouttest.renderers.VerticalProgressBarRenderer;

/**
 * Created by Raymond on 2015-06-21.
 */
public class NewsAdapter extends RecyclerView.Adapter {
    private static final String TAG = "NewsAdapter";
    static final int VIEW_TYPE_HOT_LIST_ITEM = 0;
    static final int VIEW_TYPE_NORMAL_LIST_ITEM = 1;
    static final int VIEW_TYPE_LOADING_INDICATOR = 2;

    private List<News> mNewsList;
    NewsRenderer mNewsRenderer;
    VerticalProgressBarRenderer mProgressBarRenderer;

    protected boolean mHasNext = true;

    public NewsAdapter(List<News> newsList) {
        this.mNewsList = newsList;
        mNewsRenderer = new NewsRenderer(mNewsList);
        mProgressBarRenderer = new VerticalProgressBarRenderer();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_NORMAL_LIST_ITEM) {
            return mNewsRenderer.onCreateViewHolder(parent, viewType);
        } else {
            return mProgressBarRenderer.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);

        if (viewType == VIEW_TYPE_NORMAL_LIST_ITEM) {
            mNewsRenderer.onBindViewHolder(viewHolder, mapPositionToItemPosition(position));
        } else {
            mProgressBarRenderer.onBindViewHolder(viewHolder, position);
        }
    }

    @Override
    public int getItemCount() {
        int count = mNewsList.size() + ((mHasNext) ? 1 : 0);
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHasNext) {
            if (position + 1 == getItemCount()) {
                return VIEW_TYPE_LOADING_INDICATOR;
            }
        }
        return VIEW_TYPE_NORMAL_LIST_ITEM;
    }

    protected int mapPositionToItemPosition(int position) {
        return position;
    }

}
