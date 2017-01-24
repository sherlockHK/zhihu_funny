package com.fanbo.kai.zhihu_funny.view.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by HK on 2017/1/24.
 * Email: kaihu1989@gmail.com.
 */

public abstract class RecyclerViewBaseHolder<D> extends RecyclerView.ViewHolder {
    public RecyclerViewBaseHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void populate(D item);
}
