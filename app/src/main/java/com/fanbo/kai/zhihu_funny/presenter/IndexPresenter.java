package com.fanbo.kai.zhihu_funny.presenter;

import com.fanbo.kai.zhihu_funny.presenter.base.BasePresenter;
import com.fanbo.kai.zhihu_funny.presenter.contract.IndexContract;

import javax.inject.Inject;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

public class IndexPresenter extends BasePresenter<IndexContract.View> implements IndexContract.Presenter {
    @Inject
    public IndexPresenter() {
    }

    @Override
    public void initSections() {
        httpRequest(funnyApi.getSections(), response -> mView.showSections(response));
    }
}
