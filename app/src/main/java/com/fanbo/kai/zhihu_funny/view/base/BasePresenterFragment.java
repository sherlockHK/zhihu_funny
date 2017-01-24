package com.fanbo.kai.zhihu_funny.view.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fanbo.kai.zhihu_funny.FunnyApp;
import com.fanbo.kai.zhihu_funny.di.component.DaggerFragmentComponent;
import com.fanbo.kai.zhihu_funny.di.component.FragmentComponent;
import com.fanbo.kai.zhihu_funny.di.module.FragmentModule;
import com.fanbo.kai.zhihu_funny.presenter.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Kai on 2017/1/21.
 * Email: kaihu1989@gmail.com
 */

public abstract class BasePresenterFragment<P extends BasePresenter> extends BaseSimpleFragment {
    @Inject
    protected P mPresenter;
    @Inject
    Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        if (mPresenter != null){
            mPresenter.attachView(this);
        }
    }

    protected abstract void inject();

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder().appComponent(FunnyApp.getAppComponent()).fragmentModule(new FragmentModule(this)).build();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.unAttachView();
        }
    }
}
