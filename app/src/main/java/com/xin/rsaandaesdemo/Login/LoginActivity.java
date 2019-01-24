package com.xin.rsaandaesdemo.Login;

import android.view.View;
import android.widget.EditText;

import com.xin.rsaandaesdemo.Base.IBaseActivity;
import com.xin.rsaandaesdemo.Bean.User;
import com.xin.rsaandaesdemo.R;

public class LoginActivity extends IBaseActivity implements LoginView<User> {

    private EditText mEtUserAccount;

    private EditText mEtUserPwd;

    private LoginPresenter loginPresenter = new LoginPresenter();

    @Override
    public int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        super.initViews();

        loginPresenter.attachView(this);

        mEtUserAccount = findViewById(R.id.et_user_account);
        mEtUserPwd = findViewById(R.id.et_user_pwd);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_login:

                String userAccount = mEtUserAccount.getText().toString().trim();
                String userPwd = mEtUserPwd.getText().toString().trim();

                //开始登录操作
                loginPresenter.login(userAccount, userPwd);

                break;
        }

    }

    @Override
    public void loginSuccess(User data) {

    }
}
