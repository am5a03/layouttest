package dnomyar.layouttest.renderers;

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
 * Created by Raymond on 2015-08-09.
 */
public class HotNewsRenderer implements RecyclerViewRendererInterface {

    private List<News> mHotNewsList;

    public HotNewsRenderer(List<News> hotNewsList) {
        mHotNewsList = hotNewsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.hot_news_items, null);
        HotNewsViewHolder hotNewsViewHolder = new HotNewsViewHolder(view);
        return hotNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        HotNewsViewHolder holder = (HotNewsViewHolder) viewHolder;
        holder.mTextView.setText(mHotNewsList.get(position).getHeader());
        if (mHotNewsList.get(position).getThumbnail() != null) {
            holder.mSimpleDraweeView.setImageURI(Uri.parse(mHotNewsList.get(position).getThumbnail()));
        } else {
            holder.mSimpleDraweeView.setImageURI(null);
        }
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
}
