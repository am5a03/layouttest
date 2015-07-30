package dnomyar.layouttest;

import android.app.Application;

import io.branch.referral.Branch;

/**
 * Created by Raymond on 2015-07-18.
 */
public class MyApplication extends Application {
    public static Branch sBranch;
    @Override
    public void onCreate() {
        super.onCreate();
        sBranch = Branch.getAutoInstance(this);
        sBranch.setDebug();
    }
}
