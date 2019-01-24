package com.xin.rsaandaesdemo.Bean;

/**
 * Created by admin on 2019/1/23.
 */

public class User {

    private String userAccount;

    private String userPwd;

    public User() {
    }

    public User(String userAccount, String userPwd) {
        this.userAccount = userAccount;
        this.userPwd = userPwd;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userAccount='" + userAccount + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
