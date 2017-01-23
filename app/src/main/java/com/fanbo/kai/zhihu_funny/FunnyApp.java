package com.fanbo.kai.zhihu_funny;

import android.app.Application;
import android.content.Context;

import com.fanbo.kai.zhihu_funny.di.component.AppComponent;
import com.fanbo.kai.zhihu_funny.di.component.DaggerAppComponent;
import com.fanbo.kai.zhihu_funny.di.module.AppModule;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

public class FunnyApp extends Application {
    private static AppComponent appComponent;
    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();

        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        instance = this;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }


    public static Context getAppContext() {
        return instance;
    }
}
