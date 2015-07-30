package dnomyar.layouttest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dnomyar.layouttest.R;

/**
 * Created by Raymond on 2015-07-31.
 */
public class SingleFragmentActivity extends AppCompatActivity {
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
    }
}
