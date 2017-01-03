package nishant.com.brahmastra;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
        return inflater.inflate(R.layout.webview_fragment, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();

        String url = bundle.getString("url");
//        String title = bundle.getString("title");
        boolean isPdf = bundle.getBoolean("isPdf", false);
        boolean isProgress = bundle.getBoolean("isProgress", false);
        boolean isCancelAble = bundle.getBoolean("isCancelAble", false);

        WebView webView = (WebView) view.findViewById(R.id.webview);

        webView.getSettings().setTextZoom(200);

        ProgressDialog progressBar = ProgressDialog.show(context, "", "Loading...");

        progressBar.setCancelable(isCancelAble);

        WebviewPresenter.setupWebView(url, isPdf, webView, progressBar, isProgress);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
