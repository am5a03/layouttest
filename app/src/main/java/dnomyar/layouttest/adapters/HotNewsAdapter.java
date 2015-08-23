package dnomyar.layouttest.adapters;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import dnomyar.layouttest.R;
import dnomyar.layouttest.models.News;
import dnomyar.layouttest.renderers.HorizontalProgressBarRenderer;
import dnomyar.layouttest.renderers.HotNewsRenderer;

/**
 * Created by Raymond on 2015-08-02.
 */
public class HotNewsAdapter extends RecyclerView.Adapter {

    static final int VIEW_TYPE_ITEM = 0;
    static final int VIEW_TYPE_LOADING_INDICATOR = 1;

    private boolean mHasNext = true;

    private List<News> mHotNewsList;
    private HotNewsRenderer mHotNewsRenderer;
    private HorizontalProgressBarRenderer mHorizontalProgressBarRenderer;

    public HotNewsAdapter() {
        this.mHotNewsList = new ArrayList<>();
        mHotNewsRenderer = new HotNewsRenderer(mHotNewsList);
        mHorizontalProgressBarRenderer = new HorizontalProgressBarRenderer();
    }

    public List<News> getHotNewsList() {
        return mHotNewsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_LOADING_INDICATOR) {
            return mHorizontalProgressBarRenderer.onCreateViewHolder(parent, viewType);
        }
        return mHotNewsRenderer.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        if (viewType == VIEW_TYPE_LOADING_INDICATOR) {
            mHorizontalProgressBarRenderer.onBindViewHolder(holder, position);
        } else {
            mHotNewsRenderer.onBindViewHolder(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return mHotNewsList.size() + ((mHasNext) ? 1 : 0);
    }

    @Override
    public int getItemViewType(int position) {
        if (mHasNext) {
            if (position + 1 == getItemCount()) {
                return VIEW_TYPE_LOADING_INDICATOR;
            }
        }
        return VIEW_TYPE_ITEM;
    }
}
