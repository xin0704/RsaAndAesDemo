package com.xin.rsaandaesdemo.Utils.Http;

import com.xin.rsaandaesdemo.Base.MyApplication;
import com.xin.rsaandaesdemo.Constants.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2019/1/30.
 * 自定义拦截器  把AES加密的秘钥放在header中
 */

public class CustomRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                //添加header  AES秘钥
                .header("SECRET", MyApplication.sp.getString(Constants.AES_SP_KEY, ""))
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);

    }
}
