package com.fanbo.kai.zhihu_funny.utils.reduce;

import java.util.Iterator;

/**
 * Created by HK on 2017/1/25.
 * Email: kaihu1989@gmail.com.
 */

public class Reduce {
    private Reduce() {
    }
    public static <F,T> T reduce(final Iterable<F> iterable, final ReduceFunc<F, T> func, T origin) {
        for (Iterator iterator = iterable.iterator(); iterator.hasNext(); ) {
            origin = func.apply((F)(iterator.next()), origin);
        }
        return origin;
    }
}
