package com.fanbo.kai.zhihu_funny.network;

import com.fanbo.kai.zhihu_funny.model.StartImage;
import com.fanbo.kai.zhihu_funny.model.Sections;

import retrofit2.http.GET;
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
}
