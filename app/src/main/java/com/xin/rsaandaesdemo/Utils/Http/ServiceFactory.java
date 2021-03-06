package com.xin.rsaandaesdemo.Utils.Http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by admin on 2018/4/19.
 */

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private Retrofit retrofit;

    public static ServiceFactory getInstance() {

        if (serviceFactory == null) {
            synchronized (ServiceFactory.class) {
                if (serviceFactory == null) {
                    serviceFactory = new ServiceFactory();
                }
            }
        }

        return serviceFactory;
    }

    public <T> T createService(String baseUrl, Class<T> clz) {

        OkHttpClient client = new OkHttpClient.Builder().
                connectTimeout(60, TimeUnit.SECONDS).
                readTimeout(60, TimeUnit.SECONDS).
                writeTimeout(60, TimeUnit.SECONDS)
                //添加拦截器 在此拦截器中可添加header
                .addInterceptor(new CustomRequestInterceptor())
                //添加拦截器 在此拦截器中可获取header
                .addInterceptor(new CustomResponseInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(CustomGsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(clz);
    }

}
