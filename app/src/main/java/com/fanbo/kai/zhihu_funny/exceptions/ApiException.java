package com.fanbo.kai.zhihu_funny.exceptions;

/**
 * Created by Kai on 2017/1/21.
 * Email: kaihu1989@gmail.com
 */

public class ApiException extends RuntimeException {
    //错误码
    public int errorCode;
    public ApiException(int errorCode) {
        super(errorCode + "");
        this.errorCode = errorCode;
    }
}
