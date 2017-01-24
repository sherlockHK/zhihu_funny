package com.fanbo.kai.zhihu_funny;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fanbo.kai.zhihu_funny.presenter.TestPresenter;
import com.fanbo.kai.zhihu_funny.presenter.contract.TestContract;
import com.fanbo.kai.zhihu_funny.view.base.BasePresenterActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BasePresenterActivity<TestPresenter> implements TestContract.View {

    @BindView(R.id.iv_main)
    ImageView imageView;

    @OnClick(R.id.btn_load_img)
    public void onClick(){
        mPresenter.test();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void inject() {
        getActivityComponent().inject(this);
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
        mPresenter.test();
    }

    @Override
    public void showTest(String str) {
        Glide.with(this).load(str).into(imageView);
    }
}
