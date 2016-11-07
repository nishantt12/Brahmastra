package nishant.com.brahmastra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    public static void openPdf(Activity activity, String url, String title) {

        Intent intent = new Intent(activity, WebViewActivity.class);

        Log.e("d", url);
        Log.d("d", url);

        intent.putExtra("url", url);
        intent.putExtra("isPdf", true);
        intent.putExtra("title", title);

        activity.startActivity(intent);

    }

    public static void openPdfFragment(int layoutId, AppCompatActivity context, String url, boolean isProgress, boolean isCancelAble) {
        Log.e("d", url);

        Bundle bundle = new Bundle();

        bundle.putString("url", url);
        bundle.putBoolean("isPdf", true);
        bundle.putBoolean("isCancelAble", isCancelAble);
        bundle.putBoolean("isProgress", isProgress);


        ManageFragments manageFragments = new ManageFragments();

        manageFragments.showFragmentNoEnter(context, layoutId, false, false, new WebviewFragment(), "", bundle);


    }

}
