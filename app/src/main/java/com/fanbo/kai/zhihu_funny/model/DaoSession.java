package com.fanbo.kai.zhihu_funny.model;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig startImageDaoConfig;

    private final StartImageDao startImageDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        startImageDaoConfig = daoConfigMap.get(StartImageDao.class).clone();
        startImageDaoConfig.initIdentityScope(type);

        startImageDao = new StartImageDao(startImageDaoConfig, this);

        registerDao(StartImage.class, startImageDao);
    }
    
    public void clear() {
        startImageDaoConfig.clearIdentityScope();
    }

    public StartImageDao getStartImageDao() {
        return startImageDao;
    }

}
