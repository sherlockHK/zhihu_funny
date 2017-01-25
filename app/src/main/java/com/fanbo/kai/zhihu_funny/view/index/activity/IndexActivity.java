package com.fanbo.kai.zhihu_funny.view.index.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.fanbo.kai.zhihu_funny.R;
import com.fanbo.kai.zhihu_funny.model.Sections;
import com.fanbo.kai.zhihu_funny.presenter.IndexPresenter;
import com.fanbo.kai.zhihu_funny.presenter.contract.IndexContract;
import com.fanbo.kai.zhihu_funny.utils.Constants;
import com.fanbo.kai.zhihu_funny.view.base.BasePresenterActivity;
import com.fanbo.kai.zhihu_funny.view.base.RecyclerViewBaseAdapter;
import com.fanbo.kai.zhihu_funny.view.base.RecyclerViewBaseHolder;
import com.fanbo.kai.zhihu_funny.view.index.adapter.IndexAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class IndexActivity extends BasePresenterActivity<IndexPresenter> implements IndexContract.View, RecyclerViewBaseAdapter.OnRecyclerViewItemClickListener {

    @BindView(R.id.xrv_title)
    XRecyclerView mRecyclerView;
    private IndexAdapter mAdapter;
    private List<Sections.Section> sectionList;

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setPullRefreshEnabled(false);
        sectionList = new ArrayList<>();
        mAdapter = new IndexAdapter(sectionList);
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.initSections();
    }

    @Override
    public void showSections(Sections sections) {
        sectionList.clear();
        sectionList.addAll(sections.getData());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(RecyclerViewBaseHolder holder, int position) {
        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra(Constants.SECTION_ID, mAdapter.getData(position).getId());
        startActivity(intent);
    }
}
