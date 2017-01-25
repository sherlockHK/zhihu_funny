package com.fanbo.kai.zhihu_funny.utils.reduce;

/**
 * Created by HK on 2017/1/25.
 * Email: kaihu1989@gmail.com.
 */

public interface ReduceFunc<F,T> {
    T apply(F currentElement, T origin);
}
