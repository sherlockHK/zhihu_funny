package com.fanbo.kai.zhihu_funny.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fanbo.kai.zhihu_funny.FunnyApp;
import com.fanbo.kai.zhihu_funny.di.component.ActivityComponent;
import com.fanbo.kai.zhihu_funny.di.component.DaggerActivityComponent;
import com.fanbo.kai.zhihu_funny.di.module.ActivityModule;
import com.fanbo.kai.zhihu_funny.presenter.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

public abstract class BasePresenterActivity<P extends BasePresenter> extends BaseSimpleActivity {
    @Inject
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        inject();
        if (mPresenter != null){
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }

    protected abstract void inject();

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder().appComponent(FunnyApp.getAppComponent()).activityModule(new ActivityModule(this)).build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.unAttachView();
        }
    }
}
