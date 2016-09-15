package nishant.com.brahmastra;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

/**
 * Created by nishant on 15/9/16.
 */
public class Brahmastra {


    public static void openWeb(Activity activity, String url, String title) {

        Intent intent = new Intent(activity, WebViewActivity.class);

        Log.e("d", url);
        Log.d("d", url);

        intent.putExtra("url", url);
        intent.putExtra("title", title);

        activity.startActivity(intent);

    }

}
