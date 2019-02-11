package com.xin.rsaandaesdemo.Login;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import com.xin.rsaandaesdemo.Base.IBasePresenter;
import com.xin.rsaandaesdemo.Bean.User;
import com.xin.rsaandaesdemo.Constants.Urls;
import com.xin.rsaandaesdemo.Utils.Encrypt.Aes.Aes;
import com.xin.rsaandaesdemo.Utils.Http.CustomSubscriber;
import com.xin.rsaandaesdemo.Utils.Http.ServiceFactory;

import okhttp3.RequestBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2019/1/23.
 */

public class LoginPresenter extends IBasePresenter<LoginView> implements LoginInterface {

    @Override
    public void login(String userName, String userPwd) {

        if (TextUtils.isEmpty(userName)) {
            view.showToast("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(userPwd)) {
            view.showToast("请输入密码");
            return;
        }

        User user = new User(userName, userPwd);

        RequestBody body = null;

//        try {
//            body = Rsa.encode(new Gson().toJson(user));
//        } catch (Exception e) {
//            e.printStackTrace();
//            view.showToast("数据加密失败");
//            return;
//        }

        try {
            body = Aes.encode(new Gson().toJson(user));
        } catch (Exception e) {
            e.printStackTrace();
            view.showToast("数据加密失败");
            return;
        }

        ServiceFactory.getInstance()
                .createService(Urls.BASE_URL, LoginService.class)
                .login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomSubscriber<User>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        view.showDialog();
                    }

                    @Override
                    public void onError(String err_msg) {
                        view.hideDialog();
                        view.showToast(err_msg);
                    }

                    @Override
                    public void onSuccess(User data) {
                        view.hideDialog();
                        Log.d("==========",data.toString());
                    }
                });

    }


}
