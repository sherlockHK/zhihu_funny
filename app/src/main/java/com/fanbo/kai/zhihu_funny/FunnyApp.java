package com.fanbo.kai.zhihu_funny;

import android.app.Application;
import android.content.Context;

import com.fanbo.kai.zhihu_funny.di.component.AppComponent;
import com.fanbo.kai.zhihu_funny.di.component.DaggerAppComponent;
import com.fanbo.kai.zhihu_funny.di.module.AppModule;
import com.fanbo.kai.zhihu_funny.model.DaoMaster;
import com.fanbo.kai.zhihu_funny.model.DaoSession;
import com.umeng.analytics.MobclickAgent;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

public class FunnyApp extends Application {
    private static AppComponent appComponent;
    private static FunnyApp instance;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        instance = this;

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "funny.db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static Context getAppContext() {
        return instance;
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
