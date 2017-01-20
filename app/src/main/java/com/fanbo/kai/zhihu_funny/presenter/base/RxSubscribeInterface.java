package com.fanbo.kai.zhihu_funny.presenter.base;

import rx.Subscription;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */
public interface RxSubscribeInterface {
    void addSubscribe(Subscription subscription);
    void unSubscribe();
}
