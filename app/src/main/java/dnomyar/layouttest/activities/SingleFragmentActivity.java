package dnomyar.layouttest.activities;

import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import dnomyar.layouttest.R;
import dnomyar.layouttest.fragments.MainListFragment;

/**
 * Created by Raymond on 2015-07-31.
 */
public class SingleFragmentActivity extends AppCompatActivity {
    private TextView mHeapSizeTextView;

    private UpdateHeapSizeRunnable mUpdateHeapSizeRunnable;
    private UpdateTextViewRunnable mUpdateTextViewRunnable;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        mHeapSizeTextView = (TextView) findViewById(R.id.heap_size);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, MainListFragment.newInstance(), "main-list");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE);
        fragmentTransaction.commit();


//        mUpdateHeapSizeRunnable = new UpdateHeapSizeRunnable(this);
//        mUpdateHeapSizeRunnable.run();

        mUpdateTextViewRunnable = new UpdateTextViewRunnable(mHeapSizeTextView);
        mHeapSizeTextView.post(mUpdateTextViewRunnable);
    }

    public void updateHeapSize() {
        mHeapSizeTextView.post(new Runnable() {
            @Override
            public void run() {
                final Double allocated = new Double(Debug.getNativeHeapAllocatedSize())/new Double((1024));
                final Double available = new Double(Debug.getNativeHeapSize())/1024.0;
                final Double free = new Double(Debug.getNativeHeapFreeSize())/1024.0;
                mHeapSizeTextView.setText(allocated + "KB");
                mHeapSizeTextView.postDelayed(this, 1000);
            }
        });
    }

    static class UpdateTextViewRunnable implements Runnable {
        private WeakReference<TextView> mTextViewWeakReference;

        public UpdateTextViewRunnable(TextView textViewWeakReference) {
            mTextViewWeakReference = new WeakReference<TextView>(textViewWeakReference);
        }

        @Override
        public void run() {
            if (mTextViewWeakReference.get() == null) return;
            final Double allocated = new Double(Debug.getNativeHeapAllocatedSize())/new Double((1024));
            final Double available = new Double(Debug.getNativeHeapSize())/1024.0;
            final Double free = new Double(Debug.getNativeHeapFreeSize())/1024.0;
            mTextViewWeakReference.get().setText(allocated + "KB");
            mTextViewWeakReference.get().postDelayed(this, 1000);
        }
    }

    static class UpdateHeapSizeRunnable implements Runnable {
        private WeakReference<SingleFragmentActivity> mSingleFragmentActivity;
        public UpdateHeapSizeRunnable(SingleFragmentActivity mSingleFragmentActivity) {
            this.mSingleFragmentActivity = new WeakReference<SingleFragmentActivity>(mSingleFragmentActivity);
        }

        @Override
        public void run() {
            if (mSingleFragmentActivity.get() == null) return;
            mSingleFragmentActivity.get().updateHeapSize();
        }
    }
}
