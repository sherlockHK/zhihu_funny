package com.fanbo.kai.zhihu_funny.di.module;

import android.app.Activity;

import dagger.Module;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }
}
