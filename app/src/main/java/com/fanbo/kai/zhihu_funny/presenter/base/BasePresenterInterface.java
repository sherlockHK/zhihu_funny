package com.fanbo.kai.zhihu_funny.presenter.base;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */
public interface BasePresenterInterface<T> {
    void attachView(T view);
    void unAttachView();
}
