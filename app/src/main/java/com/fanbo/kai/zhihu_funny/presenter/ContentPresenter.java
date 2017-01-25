package com.fanbo.kai.zhihu_funny.presenter;

import com.fanbo.kai.zhihu_funny.model.Section;
import com.fanbo.kai.zhihu_funny.presenter.base.BasePresenter;
import com.fanbo.kai.zhihu_funny.presenter.contract.ContentContract;
import com.fanbo.kai.zhihu_funny.presenter.contract.ContentContract.Presenter;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by HK on 2017/1/25.
 * Email: kaihu1989@gmail.com.
 */
public class ContentPresenter extends BasePresenter<ContentContract.View> implements Presenter {
    private List<Integer> storyIds = new ArrayList<>();

    @Inject
    public ContentPresenter() {
    }

    @Override
    public void initContentData(int sectionId) {
        httpRequest(funnyApi.getSectionById(sectionId), response -> {
            storyIds.addAll(Lists.transform(response.getStories(), Section.Story::getId));
            fetchContentBody();
        });
    }

    private void fetchContentBody() {
        httpRequest(funnyApi.getNewsById(storyIds.get(0)), response -> mView.showContent(response.getBody()));
    }
}
