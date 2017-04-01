package com.fanbo.kai.zhihu_funny.view.widget.dialog.base;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by HK on 2017/1/23.
 * Email: kaihu1989@gmail.com.
 */

public class BaseDialog extends Dialog {
    protected Window window;

    public BaseDialog(Context context) {
        super(context);
        setTheme();
        window = getWindow();
        WindowManager.LayoutParams attributesParams = window.getAttributes();
        attributesParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        attributesParams.dimAmount = 0.4f;

        @SuppressWarnings("deprecation")
        int screenWidth = window.getWindowManager().getDefaultDisplay().getWidth();
        int windowWidth = (int) (screenWidth * 0.8);

        window.setLayout(windowWidth, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    protected void setTheme() {
        getContext().setTheme(android.R.style.Theme_Holo_InputMethod);
    }
}
