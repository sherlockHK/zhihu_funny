package com.fanbo.kai.zhihu_funny.view.widget.dialog.base;

import android.content.Context;
import android.view.WindowManager;
import android.widget.TextView;

import com.fanbo.kai.zhihu_funny.R;

/**
 * Created by HK on 2017/1/23.
 * Email: kaihu1989@gmail.com.
 */

public class LoadingDialog extends BaseDialog {
    private TextView msg;

    public LoadingDialog(Context context) {
        super(context);
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        super.setContentView(R.layout.dialog_loading);
        msg = (TextView) findViewById(R.id.msg);
    }

    public void setTitle(String content) {
        msg.setText(content);
    }
}
