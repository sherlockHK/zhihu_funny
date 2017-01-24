package com.fanbo.kai.zhihu_funny.di.component;

import com.fanbo.kai.zhihu_funny.view.index.activity.IndexActivity;
import com.fanbo.kai.zhihu_funny.di.annotation.PerActivity;
import com.fanbo.kai.zhihu_funny.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(IndexActivity indexActivity);
}
