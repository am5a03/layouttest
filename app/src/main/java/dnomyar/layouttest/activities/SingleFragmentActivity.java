package dnomyar.layouttest.activities;

import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import dnomyar.layouttest.R;
import dnomyar.layouttest.fragments.MainListFragment;

/**
 * Created by Raymond on 2015-07-31.
 */
public class SingleFragmentActivity extends AppCompatActivity {
    private TextView mHeapSizeTextView;

    private UpdateHeapSizeRunnable mUpdateHeapSizeRunnable;
    static Leaky mLeaky = null;
    class Leaky {
        void doSomething() {
            System.out.println("whatever...");
        }
    }

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

        if(mUpdateHeapSizeRunnable == null) {
            mUpdateHeapSizeRunnable = new UpdateHeapSizeRunnable(this);
        }
        mUpdateHeapSizeRunnable.run();

        if (mLeaky == null) {
            mLeaky = new Leaky();
        }
    }

    public void updateHeapSize() {
        mHeapSizeTextView.post(new Runnable() {
            @Override
            public void run() {
                final Double allocated = new Double(Debug.getNativeHeapAllocatedSize())/new Double((1024));
                final Double available = new Double(Debug.getNativeHeapSize())/1024.0;
                final Double free = new Double(Debug.getNativeHeapFreeSize())/1024.0;
                mHeapSizeTextView.setText(free + "KB");
                mHeapSizeTextView.postDelayed(this, 1000);
            }
        });
    }

    class UpdateHeapSizeRunnable implements Runnable {
        private SingleFragmentActivity mSingleFragmentActivity;
        public UpdateHeapSizeRunnable(SingleFragmentActivity mSingleFragmentActivity) {
            this.mSingleFragmentActivity = mSingleFragmentActivity;
        }

        @Override
        public void run() {
            mSingleFragmentActivity.updateHeapSize();
        }
    }
}
