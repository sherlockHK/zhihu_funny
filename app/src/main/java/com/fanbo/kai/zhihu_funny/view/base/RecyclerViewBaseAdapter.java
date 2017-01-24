package com.fanbo.kai.zhihu_funny.view.base;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by HK on 2016/11/23.
 */

public abstract class RecyclerViewBaseAdapter<Data> extends RecyclerView.Adapter<RecyclerViewBaseHolder> {
    private List<Data> list;

    private OnRecyclerViewItemClickListener mItemClickListener;

    public RecyclerViewBaseAdapter() {
    }

    public RecyclerViewBaseAdapter(List<Data> list) {
        this.list = list;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public int getItemCount() {
        if (null == list) {
            return 0;
        }
        return list.size();
    }

    @Override
    public void onBindViewHolder(final RecyclerViewBaseHolder holder, int position) {
        onRefreshViewHolder(holder, position);
        if (null != mItemClickListener) {
            holder.itemView.setOnClickListener(v -> {
                int layoutPosition = holder.getLayoutPosition();
                mItemClickListener.onItemClick(holder, layoutPosition - 1);
            });
        }
    }

    public abstract void onRefreshViewHolder(RecyclerViewBaseHolder holder, int position);

    protected List<Data> getList() {
        return list;
    }

    public Data getData(int position) {
        return list.get(position);
    }

    public void setList(List<Data> list) {
        this.list = list;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(RecyclerViewBaseHolder holder, int position);
    }
}
