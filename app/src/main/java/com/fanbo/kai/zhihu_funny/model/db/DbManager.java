package com.fanbo.kai.zhihu_funny.model.db;

import com.fanbo.kai.zhihu_funny.FunnyApp;
import com.fanbo.kai.zhihu_funny.model.DaoMaster;
import com.fanbo.kai.zhihu_funny.model.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by HK on 2017/1/24.
 * Email: kaihu1989@gmail.com.
 */

public class DbManager {
    private final static String DB_NAME = "funny.db";
//    /data/data/com.fanbo.kai.zhihu_funny/databases

    private DaoSession daoSession;

    public DbManager() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(FunnyApp.getAppContext(), DB_NAME);
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
