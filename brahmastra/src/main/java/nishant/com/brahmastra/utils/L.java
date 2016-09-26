package nishant.com.brahmastra.utils;

import android.util.Log;

/**
 * Created by suraj on 9/12/15.
 */
public class L {
    static String LOGCAT_KEY = "response";

    public static void d(String message) {
        if (Config.IS_DEBUG) {
            Log.d(LOGCAT_KEY, message);
        }
    }

    public static void e(String message) {
        if (Config.IS_DEBUG) {
            Log.e(LOGCAT_KEY, message);
        }
    }
}
