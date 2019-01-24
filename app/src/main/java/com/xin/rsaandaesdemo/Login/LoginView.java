package com.xin.rsaandaesdemo.Login;

import com.xin.rsaandaesdemo.Base.IBaseView;

/**
 * Created by admin on 2019/1/23.
 */

public interface LoginView<T> extends IBaseView {

    void loginSuccess(T data);

}
