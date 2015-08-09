package dnomyar.layouttest.renderers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * Created by Raymond on 2015-08-09.
 */
public class HorizontalProgressBarRenderer implements RecyclerViewRendererInterface {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.addView(progressBar, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));

        return new HorizontalProgressBarViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

    }

    public static class HorizontalProgressBarViewHolder extends RecyclerView.ViewHolder {

        public HorizontalProgressBarViewHolder(View itemView) {
            super(itemView);
        }
    }
}
