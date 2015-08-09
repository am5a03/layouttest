package dnomyar.layouttest.renderers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dnomyar.layouttest.R;
import dnomyar.layouttest.adapters.HotNewsAdapter;
import dnomyar.layouttest.adapters.HotNewsListAdapter;

/**
 * Created by Raymond on 2015-08-09.
 */
public class HotNewsListRenderer implements RecyclerViewRendererInterface {

    private HotNewsAdapter mHotNewsAdapter;

    public HotNewsListRenderer(HotNewsAdapter hotNewsAdapter) {
        mHotNewsAdapter = hotNewsAdapter;
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
    }

    public static class HotNewsListViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        public HotNewsListViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }
}
