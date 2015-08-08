package dnomyar.layouttest.news;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import dnomyar.layouttest.R;

/**
 * Created by Raymond on 2015-08-02.
 */
public class HotNewsAdapter extends RecyclerView.Adapter {

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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.hot_news_items, null);
        HotNewsViewHolder hotNewsViewHolder = new HotNewsViewHolder(view);
        return hotNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HotNewsViewHolder hotNewsViewHolder = (HotNewsViewHolder) holder;
        hotNewsViewHolder.mTextView.setText(mHotNewsList.get(position).getHeader());
//        hotNewsViewHolder.mSimpleDraweeView.setImageURI(Uri.parse(mHotNewsList.get(position).getThumbnail()));
    }

    @Override
    public int getItemCount() {

        if (mHotNewsList != null) {
            return mHotNewsList.size();
        }
        return 0;
    }
}
