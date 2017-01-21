package com.fanbo.kai.zhihu_funny.di.component;

import com.fanbo.kai.zhihu_funny.di.module.AppModule;
import com.fanbo.kai.zhihu_funny.network.FunnyApi;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Gson getGson();

    FunnyApi getFunnyApi();

}
