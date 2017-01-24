package com.fanbo.kai.zhihu_funny.di.component;

import com.fanbo.kai.zhihu_funny.di.module.AppModule;
import com.fanbo.kai.zhihu_funny.model.db.DbManager;
import com.fanbo.kai.zhihu_funny.network.FunnyApi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    FunnyApi getFunnyApi();

    DbManager getDbManager();
}
