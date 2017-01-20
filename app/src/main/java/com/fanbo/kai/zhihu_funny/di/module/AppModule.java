package com.fanbo.kai.zhihu_funny.di.module;

import com.fanbo.kai.zhihu_funny.ZhiHuFunnyApp;
import com.fanbo.kai.zhihu_funny.network.ZhiHuFunnyApi;
import com.fanbo.kai.zhihu_funny.network.ZhiHuFunnyRetrofit;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */
@Module
public class AppModule {
    private ZhiHuFunnyApp app;

    public AppModule(ZhiHuFunnyApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public ZhiHuFunnyApp providesApp() {
        return app;
    }
    @Provides
    @Singleton
    public ZhiHuFunnyRetrofit providesPuerBiRetrofit() {
        return new ZhiHuFunnyRetrofit();
    }
    @Provides
    @Singleton
    public ZhiHuFunnyApi providesPuerBiApi(ZhiHuFunnyRetrofit zhiHuFunnyRetrofit) {
//        return zhiHuFunnyRetrofit.getRetrofit().create(ZhiHuFunnyApi.class);
        return null;
    }

    @Provides
    @Singleton
    public Gson providesGson() {
        return new Gson();
    }

}
