package com.fanbo.kai.zhihu_funny.presenter.base;

import android.app.Activity;

import com.fanbo.kai.zhihu_funny.model.base.ApiResponseFunc1;
import com.fanbo.kai.zhihu_funny.model.base.BaseResponse;
import com.fanbo.kai.zhihu_funny.network.FunnyApi;
import com.fanbo.kai.zhihu_funny.ui.base.BaseView;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

public class BasePresenter<T extends BaseView> implements BasePresenterInterface<T>, RxSubscribeInterface {
    protected T mView;
    protected CompositeSubscription mCompositeSubscription;
    @Inject
    protected FunnyApi funnyApi;

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

    /**
     * presenter层发网络请求，封装了loading动画，错误提示等
     * */
    protected <P extends BaseResponse> void httpRequest(Observable<P> observable, final RequestListener<P> listener) {
        Subscription subscribe = observable
                .map(new ApiResponseFunc1<P>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ProgressSubscriber<>(new SubscriberOnNextListener<P>() {
                    @Override
                    public void onNext(P response) {
                        listener.onSuccess(response);
                    }
                }, (Activity) mView));
        addSubscribe(subscribe);
    }

    protected interface RequestListener<P extends BaseResponse>{
        void onSuccess(P response);
    }
}
