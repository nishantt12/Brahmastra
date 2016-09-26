package nishant.com.brahmastra.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by nishant on 22/6/16.
 */
public class T {


    public static void t(Context context) {
        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
    }

    public static void t(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
