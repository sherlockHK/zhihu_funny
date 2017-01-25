package com.fanbo.kai.zhihu_funny.network;

import com.fanbo.kai.zhihu_funny.model.News;
import com.fanbo.kai.zhihu_funny.model.Section;
import com.fanbo.kai.zhihu_funny.model.StartImage;
import com.fanbo.kai.zhihu_funny.model.Sections;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

public interface FunnyApi {
    /**
     * 启动页
     * */
    @GET("start-image/1080*1776")
    Observable<StartImage> getStartImage();

    /**
     * 专栏列表
     * */
    @GET("sections")
    Observable<Sections> getSections();

    /**
     * 专栏列表
     * @param sectionId
     * */
    @GET("section/{id}")
    Observable<Section> getSectionById(@Path("id") int sectionId);

    /**
     * 新闻内容
     * @param newsId
     * */
    @GET("news/{id}")
    Observable<News> getNewsById(@Path("id") int newsId);
}
