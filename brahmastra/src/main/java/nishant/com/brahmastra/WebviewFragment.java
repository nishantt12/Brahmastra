package nishant.com.brahmastra;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by nishant on 10/10/16.
 */

public class WebviewFragment extends Fragment {

    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.webview, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();

        String url = bundle.getString("url");
        String title = bundle.getString("title");
        boolean isPdf = bundle.getBoolean("isPdf", false);

        WebView webView = (WebView) view.findViewById(R.id.webview);


        ProgressDialog progressBar = ProgressDialog.show(context, "", "Loading...");

        WebviewPresenter.setupWebView(url, isPdf, webView, progressBar);


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
