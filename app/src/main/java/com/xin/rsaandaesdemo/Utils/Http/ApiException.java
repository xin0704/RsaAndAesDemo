package com.xin.rsaandaesdemo.Utils.Http;

import java.io.IOException;

/**
 * Created by admin on 2019/1/24.
 *
 * 自定义的异常   用于解密返回数据失败
 */

public class ApiException extends IOException {

    public ApiException(){}

    public ApiException(String msg){
        throw new RuntimeException(msg);
    }

}
