package com.fanbo.kai.zhihu_funny.network;

import com.fanbo.kai.zhihu_funny.model.StartImage;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Kai on 2017/1/20.
 * Email: kaihu1989@gmail.com
 */

public interface FunnyApi {
    @GET("start-image/1080*1776")
    Observable<StartImage> getStartImage();
}
