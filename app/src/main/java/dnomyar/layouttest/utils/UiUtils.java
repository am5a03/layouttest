package dnomyar.layouttest.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Raymond on 2015-08-09.
 */
public class UiUtils {
    public static int dpToPx(int dp, Resources resources) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.getDisplayMetrics());
    }
}
