package com.xin.rsaandaesdemo.Login;

import com.xin.rsaandaesdemo.Bean.Result;
import com.xin.rsaandaesdemo.Bean.User;
import com.xin.rsaandaesdemo.Constants.Urls;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by admin on 2019/1/23.
 */

public interface LoginService {

    @POST(Urls.LOGIN_URL)
    Observable<Result<User>> login(@Body RequestBody body);//提交数据

}
