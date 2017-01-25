package com.fanbo.kai.zhihu_funny.view.index.activity;

import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.fanbo.kai.zhihu_funny.FunnyApp;
import com.fanbo.kai.zhihu_funny.R;
import com.fanbo.kai.zhihu_funny.presenter.ContentPresenter;
import com.fanbo.kai.zhihu_funny.presenter.contract.ContentContract;
import com.fanbo.kai.zhihu_funny.utils.Constants;
import com.fanbo.kai.zhihu_funny.view.base.BasePresenterActivity;

import butterknife.BindView;

/**
 * Created by HK on 2017/1/25.
 * Email: kaihu1989@gmail.com.
 */
public class ContentActivity extends BasePresenterActivity<ContentPresenter> implements ContentContract.View {

    private static final int DEFAULT_VALUE = 1;
    @BindView(R.id.fl_wv_container)
    FrameLayout mWvContainer;
    private WebView webView;

    @Override
    protected void inject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override
    protected void initView() {
        webView = new WebView(FunnyApp.getAppContext());
        webView.setLayoutParams(new ViewGroup.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDefaultTextEncodingName("utf-8");
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());

        mWvContainer.addView(webView);
    }

    @Override
    protected void initData() {
        int sectionId = getIntent().getIntExtra(Constants.SECTION_ID, DEFAULT_VALUE);
        mPresenter.initContentData(sectionId);
    }

    @Override
    public void showContent(String content) {
        String htmlData = "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />" + content;
        webView.loadDataWithBaseURL("file:///android_asset/", htmlData, "text/html", "utf-8", null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        clearWebViewResource();
    }

    //防止webview内存泄露
    private void clearWebViewResource() {
        if (webView != null) {
            webView.removeAllViews();
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.setTag(null);
            webView.clearHistory();
            webView.destroy();
            webView = null;
        }
    }

}
