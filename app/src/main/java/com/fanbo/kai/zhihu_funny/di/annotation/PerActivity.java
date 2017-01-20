package com.fanbo.kai.zhihu_funny.di.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
