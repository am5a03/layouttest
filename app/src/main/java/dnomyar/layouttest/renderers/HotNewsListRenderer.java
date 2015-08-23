package dnomyar.layouttest.renderers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dnomyar.layouttest.R;
import dnomyar.layouttest.adapters.HotNewsAdapter;
import dnomyar.layouttest.adapters.HotNewsListAdapter;
import dnomyar.layouttest.apis.nytimes.NYTimesApiDatasource;
import dnomyar.layouttest.models.News;
import rx.functions.Action1;

/**
 * Created by Raymond on 2015-08-09.
 */
public class HotNewsListRenderer implements RecyclerViewRendererInterface {

    private HotNewsAdapter mHotNewsAdapter;
    private NYTimesApiDatasource mNYTimesApiDatasource;
    private final static int LIMIT = 10;
    private int mLastOffset = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                int lastVisiblePos = linearLayoutManager.findLastVisibleItemPosition();
                if (mHotNewsAdapter.getHotNewsList().size() - lastVisiblePos < 3) {
                    loadMore(mLastOffset);
                };
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    };

    public HotNewsListRenderer(HotNewsAdapter hotNewsAdapter) {
        mHotNewsAdapter = hotNewsAdapter;
        mNYTimesApiDatasource = new NYTimesApiDatasource();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.hot_news_list, parent, false);
        HotNewsListViewHolder holder = new HotNewsListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        HotNewsListViewHolder holder = (HotNewsListViewHolder) viewHolder;
        Context context = holder.mRecyclerView.getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.mRecyclerView.setAdapter(mHotNewsAdapter);
        holder.mRecyclerView.setLayoutManager(linearLayoutManager);
        holder.mRecyclerView.addOnScrollListener(mOnScrollListener);
        initHotNews();
    }

    protected void loadMore(int offset) {
        mNYTimesApiDatasource.getRecentNews(LIMIT, offset)
                .subscribe(new Action1<List<News>>() {
                    @Override
                    public void call(List<News> newses) {
                        mHotNewsAdapter.getHotNewsList().addAll(newses);
                        mHotNewsAdapter.notifyDataSetChanged();
                        mLastOffset += LIMIT + 1;
                    }
                });
    }

    protected void initHotNews() {
        mNYTimesApiDatasource.getRecentNews(LIMIT, 10)
                .subscribe(new Action1<List<News>>() {
                    @Override
                    public void call(List<News> newses) {
                        mHotNewsAdapter.getHotNewsList().addAll(newses);
                        mHotNewsAdapter.notifyDataSetChanged();
                        mLastOffset += LIMIT + 1;
                    }
                });
    }

    public static class HotNewsListViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        public HotNewsListViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }
}
