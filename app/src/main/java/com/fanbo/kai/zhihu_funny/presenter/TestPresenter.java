package com.fanbo.kai.zhihu_funny.presenter;

import com.fanbo.kai.zhihu_funny.model.StartImageDao;
import com.fanbo.kai.zhihu_funny.presenter.base.BasePresenter;
import com.fanbo.kai.zhihu_funny.presenter.contract.TestContract;

import javax.inject.Inject;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter {
    @Inject
    public TestPresenter() {
    }

    @Override
    public void test() {
        StartImageDao startImageDao = dbManager.getDaoSession().getStartImageDao();
        httpRequest(funnyApi.getStartImage(), response -> {
            mView.showTest(response.getImg());
            startImageDao.insert(response);
        });
    }
}
