package com.xin.rsaandaesdemo.Utils.Http;

import android.util.Log;

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

public class CustomResponseInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取到response
        Response response = chain.proceed(chain.request());
        //将加密后的AES秘钥存在SP中 方便接口调用的时候传递给服务器解密数据
        MyApplication.editor
                .putString(Constants.AES_SP_KEY, response.headers().get("SECRET"))
                .commit();
        // 得到Response  对它的response 进行包装  用我们自己定义的DownLoadResponseBody
        return response;
    }


}
