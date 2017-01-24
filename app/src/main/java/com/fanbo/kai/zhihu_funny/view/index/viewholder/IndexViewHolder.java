package com.fanbo.kai.zhihu_funny.view.index.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fanbo.kai.zhihu_funny.FunnyApp;
import com.fanbo.kai.zhihu_funny.R;
import com.fanbo.kai.zhihu_funny.model.Sections;
import com.fanbo.kai.zhihu_funny.view.base.RecyclerViewBaseHolder;

import butterknife.BindView;

/**
 * Created by HK on 2017/1/24.
 * Email: kaihu1989@gmail.com.
 */

public class IndexViewHolder extends RecyclerViewBaseHolder<Sections.Section> {
    @BindView(R.id.tv_index__item_title)
    TextView title;
    @BindView(R.id.iv_index_item_img)
    ImageView img;

    public IndexViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void populate(Sections.Section item) {
        title.setText(item.getName());
        Glide.with(FunnyApp.getAppContext()).load(item.getThumbnail()).into(img);
    }
}
