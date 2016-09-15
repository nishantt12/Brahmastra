package nishant.com.brahmastra;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by nishant on 15/9/16.
 */
public class WebViewActivity extends AppCompatActivity {


    private ProgressDialog progressBar;

    private static final String TAG = "WebViewActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.webview);

        Intent intent = getIntent();

        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");

        WebView webView = (WebView) findViewById(R.id.webview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (title != null) {
            toolbar.setTitle(title);
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        progressBar = ProgressDialog.show(this, "", "Loading...");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
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

        webView.loadUrl(url);


    }
}
