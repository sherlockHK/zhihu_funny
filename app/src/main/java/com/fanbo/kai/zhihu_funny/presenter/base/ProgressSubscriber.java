package com.fanbo.kai.zhihu_funny.presenter.base;

import android.content.Context;
import android.widget.Toast;

import com.fanbo.kai.zhihu_funny.FunnyApp;
import com.fanbo.kai.zhihu_funny.model.base.BaseResponse;
import com.fanbo.kai.zhihu_funny.ui.widget.dialog.ProgressDialogHandler;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import rx.Subscriber;

/**
 * Created by HK on 2017/1/23.
 * Email: kaihu1989@gmail.com.
 */

public class ProgressSubscriber<T extends BaseResponse> extends Subscriber<T> implements ProgressDialogHandler.ProgressCancelListener {
    private SubscriberOnNextListener<T> mListener;
    private Context mContext;
    private ProgressDialogHandler mHandler;

    public ProgressSubscriber(SubscriberOnNextListener<T> listener, Context context) {
        this.mListener = listener;
        this.mContext = context;
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
        if (e instanceof SocketTimeoutException || e instanceof ConnectException || e instanceof UnknownHostException) {
            Toast.makeText(FunnyApp.getAppContext(), "网络超时，请检查网络", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(FunnyApp.getAppContext(), "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
