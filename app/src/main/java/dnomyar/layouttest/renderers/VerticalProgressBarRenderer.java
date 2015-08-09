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
public class VerticalProgressBarRenderer implements RecyclerViewRendererInterface {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        linearLayout.addView(progressBar, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        return new ProgressBarViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

    }

    public static class ProgressBarViewHolder extends RecyclerView.ViewHolder {

        public ProgressBarViewHolder(View itemView) {
            super(itemView);
        }
    }
}
