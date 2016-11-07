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
        boolean isPdf = intent.getBooleanExtra("isPdf", false);

        boolean isProgress = intent.getBooleanExtra("isProgress", false);
        boolean isCancelAble = intent.getBooleanExtra("isCancelAble", false);

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

        progressBar.setCancelable(isCancelAble);

        WebviewPresenter.setupWebView(url, isPdf, webView, progressBar, isProgress);


    }


}
