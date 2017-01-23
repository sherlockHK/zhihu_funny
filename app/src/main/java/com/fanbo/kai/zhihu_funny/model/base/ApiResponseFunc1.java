package com.fanbo.kai.zhihu_funny.model.base;

import com.fanbo.kai.zhihu_funny.exceptions.ApiException;

import rx.functions.Func1;

/**
 * Created by HK on 2017/1/23.
 * Email: kaihu1989@gmail.com.
 */

public class ApiResponseFunc1<T> implements Func1<BaseModel, T> {
    private ApiException exception;

    @Override
    public T call(BaseModel baseModel) {
        return (T) baseModel;
    }
}
