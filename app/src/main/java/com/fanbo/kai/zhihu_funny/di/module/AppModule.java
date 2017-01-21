package com.fanbo.kai.zhihu_funny.di.module;

import com.fanbo.kai.zhihu_funny.FunnyApp;
import com.fanbo.kai.zhihu_funny.network.FunnyApi;
import com.fanbo.kai.zhihu_funny.network.FunnyRetrofit;
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
    private FunnyApp app;

    public AppModule(FunnyApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public FunnyApp providesApp() {
        return app;
    }
    @Provides
    @Singleton
    public FunnyRetrofit providesFunnyRetrofit() {
        return new FunnyRetrofit();
    }
    @Provides
    @Singleton
    public FunnyApi providesFunnyApi(FunnyRetrofit funnyRetrofit) {
        return funnyRetrofit.getRetrofit().create(FunnyApi.class);
    }

    @Provides
    @Singleton
    public Gson providesGson() {
        return new Gson();
    }

}
