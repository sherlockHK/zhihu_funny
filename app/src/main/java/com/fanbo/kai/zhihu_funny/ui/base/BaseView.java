package com.fanbo.kai.zhihu_funny.ui.base;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

public interface BaseView {
    void startLoading();

    void endLoading();

    void loadingError(String error);

    void showToast(String message);
}
