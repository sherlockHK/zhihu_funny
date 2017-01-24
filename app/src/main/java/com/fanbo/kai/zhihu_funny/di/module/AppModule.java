package com.fanbo.kai.zhihu_funny.di.module;

import com.fanbo.kai.zhihu_funny.FunnyApp;
import com.fanbo.kai.zhihu_funny.model.db.DbManager;
import com.fanbo.kai.zhihu_funny.network.FunnyApi;
import com.fanbo.kai.zhihu_funny.network.RetrofitClient;

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
    FunnyApp provideApp() {
        return app;
    }

    @Provides
    @Singleton
    RetrofitClient provideFunnyRetrofit() {
        return new RetrofitClient();
    }

    @Provides
    @Singleton
    FunnyApi provideFunnyApi(RetrofitClient retrofitClient) {
        return retrofitClient.getRetrofit().create(FunnyApi.class);
    }

    @Provides
    @Singleton
    DbManager provideDbManager() {return new DbManager();}
}
