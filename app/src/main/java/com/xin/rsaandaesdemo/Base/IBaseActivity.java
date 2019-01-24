package com.xin.rsaandaesdemo.Base;

import android.app.Activity;
import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.xin.rsaandaesdemo.R;


/**
 * Created by admin on 2018/3/27.
 */

public abstract class IBaseActivity extends AppCompatActivity implements View.OnClickListener, IBaseView {

    public Activity mContext;

    public Dialog loadingDialog;//转圈刷新效果

    public abstract int initContentView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设定为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(initContentView());

        mContext = this;

        initDialogStyle();

        initData();
        initViews();
        initListener();

    }

    protected void initData() {
    }

    protected void initViews() {
    }

    protected void initListener() {
    }

    /**
     * 设置转圈加载效果
     */
    private void initDialogStyle() {

        if (loadingDialog == null) {

            loadingDialog = new Dialog(this, R.style.CustomerDialog);

        }
        //设置布局
        loadingDialog.setContentView(R.layout.loading_view);
        //设置点击外部不被取消
        loadingDialog.setCanceledOnTouchOutside(false);

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void showDialog() {
        loadingDialog.show();
    }

    @Override
    public void hideDialog() {
        loadingDialog.dismiss();
    }

    @Override
    public void showToast(String msg) {

        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();

    }


}
