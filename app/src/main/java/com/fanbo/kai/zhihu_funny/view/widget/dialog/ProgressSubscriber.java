package com.fanbo.kai.zhihu_funny.presenter.base;

import android.content.Context;

import com.fanbo.kai.zhihu_funny.model.base.BaseModel;
import com.fanbo.kai.zhihu_funny.utils.ExceptionHelper;
import com.fanbo.kai.zhihu_funny.view.widget.dialog.ProgressDialogHandler;

import rx.Subscriber;

/**
 * Created by HK on 2017/1/23.
 * Email: kaihu1989@gmail.com.
 */

public class ProgressSubscriber<T extends BaseModel> extends Subscriber<T> implements ProgressDialogHandler.ProgressCancelListener {
    private SubscriberOnNextListener<T> mListener;
    private ProgressDialogHandler mHandler;

    public ProgressSubscriber(SubscriberOnNextListener<T> listener, Context context) {
        this.mListener = listener;
        mHandler = new ProgressDialogHandler(context, this, true);
    }

    private void showProgressDialog() {
        if (mHandler != null) {
            mHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mHandler != null) {
            mHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mHandler = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        ExceptionHelper.handleException(e);
        dismissProgressDialog();
    }

    @Override
    public void onNext(T t) {
        if (mListener != null) {
            mListener.onNext(t);
        }
    }

    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}
