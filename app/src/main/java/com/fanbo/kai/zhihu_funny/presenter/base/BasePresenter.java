package com.fanbo.kai.zhihu_funny.presenter.base;

import com.fanbo.kai.zhihu_funny.network.ZhiHuFunnyApi;
import com.fanbo.kai.zhihu_funny.ui.base.BaseView;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

public class BasePresenter<T extends BaseView> implements BasePresenterInterface<T>, RxSubscribeInterface {
    private T mView;
    private CompositeSubscription mCompositeSubscription;
    @Inject
    protected ZhiHuFunnyApi funnyApi;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void unAttachView() {
        unSubscribe();
        mView = null;
    }

    @Override
    public void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
