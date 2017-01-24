package com.fanbo.kai.zhihu_funny.view.index.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanbo.kai.zhihu_funny.R;
import com.fanbo.kai.zhihu_funny.model.Sections;
import com.fanbo.kai.zhihu_funny.view.base.RecyclerViewBaseAdapter;
import com.fanbo.kai.zhihu_funny.view.base.RecyclerViewBaseHolder;
import com.fanbo.kai.zhihu_funny.view.index.viewholder.IndexViewHolder;

import java.util.List;

/**
 * Created by HK on 2017/1/24.
 * Email: kaihu1989@gmail.com.
 */

public class IndexAdapter extends RecyclerViewBaseAdapter<Sections.Section>{


    public IndexAdapter(List<Sections.Section> list) {
        super(list);
    }

    @Override
    public void onRefreshViewHolder(RecyclerViewBaseHolder holder, int position) {
        holder.populate(getData(position));
    }

    @Override
    public RecyclerViewBaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_item, parent, false);
        return new IndexViewHolder(view);
    }
}
