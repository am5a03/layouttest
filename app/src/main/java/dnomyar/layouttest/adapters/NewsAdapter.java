package dnomyar.layouttest.adapters;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.List;

import dnomyar.layouttest.R;
import dnomyar.layouttest.models.News;

/**
 * Created by Raymond on 2015-06-21.
 */
public class NewsAdapter extends RecyclerView.Adapter {

    private List<News> mNewsList;

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mHeader;
        TextView mContent;
        SimpleDraweeView mSimpleDraweeView;

        NewsViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.cardview);
            mHeader = (TextView) itemView.findViewById(R.id.header);
            mContent = (TextView) itemView.findViewById(R.id.content);
            mSimpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.thumbnail);
        }
    }

    public NewsAdapter(List<News> newsList) {
        this.mNewsList = newsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_items, parent, false);
        NewsViewHolder nvh = new NewsViewHolder(v);
        return nvh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        NewsViewHolder holder = (NewsViewHolder) viewHolder;
        News news = mNewsList.get(position);
        holder.mHeader.setText(news.getHeader());
        holder.mContent.setText(news.getContent());

        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(news.getThumbnail()))
                .setProgressiveRenderingEnabled(true)
                .build();

        holder.mSimpleDraweeView.setController(Fresco.newDraweeControllerBuilder()
                .setImageRequest(imageRequest)
                .setOldController(holder.mSimpleDraweeView.getController())
                .build());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}
