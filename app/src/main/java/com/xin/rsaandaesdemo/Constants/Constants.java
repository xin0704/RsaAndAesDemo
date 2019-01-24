package com.xin.rsaandaesdemo.Constants;

import okhttp3.MediaType;

/**
 * Created by admin on 2019/1/23.
 */

public class Constants {

    public final static int CODE = 200;

    public final static String MEDIA_TYPE = "application/json; charset=utf-8";

    //这是客户端用来加密、解密的公钥  私钥放在后台（后台用私钥加密、解密数据）
    public static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp+bR2Zl/vXJD3X7s2dZF\n" +
            "qitsz7GEvMBiGt5LIVOXcD7CSzvyq+pzWBSbWUgHTSHqCNw6f2ikdqZM67yRf5bI\n" +
            "YBuXYur+TskGH4L0Qg4uGTM/QRvcDYRzguvC1iSkJ/MIq4jhUkSmpUSTyNrAv7Zt\n" +
            "s793HpMIEDeyR1gT+YVWCeqAuacbxlYfxqQLBdPZSD3fvRU0wlaxxHs+a6UABl9f\n" +
            "2v8L+P/6gUH0ikLRapFWunQYnNUW8ocnc68a/p+MzO+YozYnQCsI5kLBkMeShMkf\n" +
            "3k1URLfFJCR903qMJGL1buPNwn4A21cCkbMfHywVSik3maSQ9PAM+F1OCltAUy0Z\n" +
            "AwIDAQAB";

}
