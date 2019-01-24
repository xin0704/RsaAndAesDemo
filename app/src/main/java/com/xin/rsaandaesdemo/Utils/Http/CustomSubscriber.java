package com.xin.rsaandaesdemo.Utils.Http;

import android.accounts.NetworkErrorException;
import android.text.TextUtils;

import com.google.gson.JsonSyntaxException;
import com.xin.rsaandaesdemo.Bean.Result;
import com.xin.rsaandaesdemo.Constants.Constants;

import java.net.SocketException;
import java.net.UnknownHostException;

import rx.Subscriber;


/**
 * Created by admin on 2018/4/19.
 */

public abstract class CustomSubscriber<T> extends Subscriber<Result<T>> {

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onError(Throwable e) {

        if (e instanceof NullPointerException) {
            onError("暂无数据");
        } else if (e instanceof JsonSyntaxException) {

            onError("数据解析失败");

        } else if (e instanceof NetworkErrorException ||
                e instanceof RuntimeException ||
                e instanceof SocketException ||
                e instanceof UnknownHostException) {

            onError(TextUtils.isEmpty(e.getMessage()) ? "请求超时" : e.getMessage());

        } else {
            onError("获取数据失败");
        }
    }

    @Override
    public void onNext(Result<T> tResult) {

        if (Constants.CODE == tResult.getCode()) {

            onSuccess(tResult.getResult());

        } else {
            if (TextUtils.isEmpty(tResult.getMsg())) {
                onError("获取数据失败");
            } else {
                onError(tResult.getMsg());
            }
        }

    }

    @Override
    public void onCompleted() {

    }

    public abstract void onError(String err_msg);

    public abstract void onSuccess(T data);

}
