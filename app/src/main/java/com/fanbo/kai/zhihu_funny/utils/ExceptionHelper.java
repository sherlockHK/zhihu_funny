package com.fanbo.kai.zhihu_funny.utils;

import android.util.Log;
import android.widget.Toast;

import com.fanbo.kai.zhihu_funny.FunnyApp;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by HK on 2017/4/26.
 * Email: kaihu1989@gmail.com.
 */

public class ExceptionHelper {

    public static void handleException(Throwable e) {
        String errorMessage;
        if (e instanceof SocketTimeoutException || e instanceof ConnectException || e instanceof UnknownHostException) {
            errorMessage = "网络超时，请检查网络";
        } else {
            errorMessage = "服务器数据异常";
        }
        Toast.makeText(FunnyApp.getAppContext(), errorMessage, Toast.LENGTH_SHORT).show();
        Log.d("[httpRequest onError]", e.getMessage());
    }
}
