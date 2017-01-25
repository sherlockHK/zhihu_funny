package com.fanbo.kai.zhihu_funny.model;

import com.fanbo.kai.zhihu_funny.model.base.BaseModel;

/**
 * Created by HK on 2017/1/25.
 * Email: kaihu1989@gmail.com.
 */
public class News extends BaseModel{
    private String body;
    private String title;
    private String image;

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
