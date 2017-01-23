package com.fanbo.kai.zhihu_funny.di.module;

import com.fanbo.kai.zhihu_funny.FunnyApp;
import com.fanbo.kai.zhihu_funny.network.FunnyApi;
import com.fanbo.kai.zhihu_funny.network.RetrofitClient;
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
    public RetrofitClient providesFunnyRetrofit() {
        return new RetrofitClient();
    }
    @Provides
    @Singleton
    public FunnyApi providesFunnyApi(RetrofitClient retrofitClient) {
        return retrofitClient.getRetrofit().create(FunnyApi.class);
    }

    @Provides
    @Singleton
    public Gson providesGson() {
        return new Gson();
    }

}
