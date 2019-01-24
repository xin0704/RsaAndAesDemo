package com.xin.rsaandaesdemo.Base;

/**
 * Created by admin on 2018/4/19.
 */

public class IBasePresenter <V extends IBaseView> {

    public V view;

    public IBasePresenter() {

    }

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    public boolean isViewAttached() {
        return view != null;
    }

}
