package nishant.com.brahmastra;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by nishant on 10/10/16.
 */

public class WebviewPresenter {


    public static void setupWebView(String url, boolean isPdf, WebView webView, final ProgressDialog progressBar) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progressBar.show();
                view.loadUrl(url);

                return true;
            }

            @Override
            public void onPageFinished(WebView view, final String url) {
                progressBar.dismiss();
            }
        });

//        Toast.makeText(this,  url, Toast.LENGTH_LONG).show();

        if (isPdf) {
            loadPdf(url, webView);
        } else {
            loadWeb(url, webView);
        }
    }

    private static void loadWeb(String url, WebView webView) {
        webView.loadUrl(url);
    }


    private static void loadPdf(String url, WebView webView) {
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + url);
    }

}
