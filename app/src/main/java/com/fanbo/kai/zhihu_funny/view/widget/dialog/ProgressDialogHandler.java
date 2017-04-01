package com.fanbo.kai.zhihu_funny.view.widget.dialog;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

/**
 * Created by HK on 2017/1/23.
 * Email: kaihu1989@gmail.com.
 */

public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private LoadingDialog dialog;

    private Context context;
    private boolean cancelable;
    private ProgressCancelListener mProgressCancelListener;

    public ProgressDialogHandler(Context context, ProgressCancelListener mProgressCancelListener,
                                 boolean cancelable) {
        super();
        this.context = context;
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
    }

    private void initProgressDialog() {
        if (dialog == null) {
            dialog = new LoadingDialog(context);

            dialog.setCancelable(cancelable);

            if (cancelable) {
                dialog.setOnCancelListener(dialogInterface -> mProgressCancelListener.onCancelProgress());
            }

            if (!dialog.isShowing()) {
                dialog.show();
            }
        }
    }

    private void dismissProgressDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }

    public interface ProgressCancelListener {
        void onCancelProgress();
    }
}
