package com.fanbo.kai.zhihu_funny;

import android.os.Bundle;

import com.fanbo.kai.zhihu_funny.presenter.TestPresenter;
import com.fanbo.kai.zhihu_funny.presenter.contract.TestContract;
import com.fanbo.kai.zhihu_funny.ui.base.BasePresenterActivity;

public class MainActivity extends BasePresenterActivity<TestPresenter> implements TestContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void inject() {
        getActivityComponent().Inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mPresenter.test("this is a simple MVP test!!");
    }

    @Override
    public void showTest(String str) {
        showToast(str);
    }
}
