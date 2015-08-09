package dnomyar.layouttest.renderers;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Raymond on 2015-08-09.
 */
public interface RecyclerViewRendererInterface<E extends RecyclerView.ViewHolder> {
    E onCreateViewHolder(ViewGroup parent, int viewType);
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position);
}
