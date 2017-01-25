package com.fanbo.kai.zhihu_funny.presenter.contract;

import com.fanbo.kai.zhihu_funny.presenter.base.BasePresenterInterface;
import com.fanbo.kai.zhihu_funny.view.base.BaseView;

/**
 * Created by HK on 2017/1/25.
 * Email: kaihu1989@gmail.com.
 */

public interface ContentContract {
    interface View extends BaseView {

        void showContent(String content);
    }

    interface Presenter extends BasePresenterInterface<View> {
        void initContentData(int sectionId);
    }
}
