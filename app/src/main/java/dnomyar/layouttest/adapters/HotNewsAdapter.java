package dnomyar.layouttest.adapters;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import dnomyar.layouttest.R;
import dnomyar.layouttest.models.News;

/**
 * Created by Raymond on 2015-08-02.
 */
public class HotNewsAdapter extends RecyclerView.Adapter<HotNewsAdapter.HotNewsViewHolder> {

    private List<News> mHotNewsList;

    public HotNewsAdapter(List<News> mHotNewsList) {
        this.mHotNewsList = mHotNewsList;
    }

    public static class HotNewsViewHolder extends RecyclerView.ViewHolder {
        CardView mHotNewsCardView;
        TextView mTextView;
        SimpleDraweeView mSimpleDraweeView;

        public HotNewsViewHolder(View itemView) {
            super(itemView);
            mHotNewsCardView = (CardView) itemView.findViewById(R.id.cardview);
            mTextView = (TextView) itemView.findViewById(R.id.header);
            mSimpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.thumbnail);
        }
    }

    @Override
    public HotNewsAdapter.HotNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.hot_news_items, null);
        HotNewsViewHolder hotNewsViewHolder = new HotNewsViewHolder(view);
        return hotNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(HotNewsAdapter.HotNewsViewHolder holder, int position) {
        holder.mTextView.setText(mHotNewsList.get(position).getHeader());
        holder.mSimpleDraweeView.setImageURI(Uri.parse(mHotNewsList.get(position).getThumbnail()));
    }

    @Override
    public int getItemCount() {
        return mHotNewsList.size();
    }
}
