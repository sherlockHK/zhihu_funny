package com.fanbo.kai.zhihu_funny.ui.base;

/**
 * Created by Kai on 2017/1/20.
 */

public interface BaseView {
    void startLoading();

    void endLoading();

    void loadingError(String error);

    void showToast(String message);
}
