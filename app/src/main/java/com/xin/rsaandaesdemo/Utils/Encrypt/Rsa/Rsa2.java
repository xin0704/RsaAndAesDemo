package com.xin.rsaandaesdemo.Utils.Encrypt.Rsa;

import com.xin.rsaandaesdemo.Constants.Constants;
import com.xin.rsaandaesdemo.Utils.Encrypt.Base64Utils;

import java.security.PublicKey;

/**
 * Created by admin on 2019/1/23.
 */

public class Rsa2 {

    public static String encode(String param) throws Exception {

        String result = null;

        // 从字符串中得到公钥
        PublicKey publicKey = RSAUtils.loadPublicKey(Constants.PUBLIC_KEY);
        // 加密
        byte[] encryptByte = RSAUtils.encryptData(param.getBytes(), publicKey);
        // 为了方便观察吧加密后的数据用base64加密转一下，要不然看起来是乱码,所以解密是也是要用Base64先转换
        result = Base64Utils.encode(encryptByte);

        return result;
    }

    public static String decode(String param) throws Exception {

        String result = null;

        // 从字符串中得到公钥
        PublicKey publicKey = RSAUtils.loadPublicKey(Constants.PUBLIC_KEY);
        // 因为RSA加密后的内容经Base64再加密转换了一下，所以先Base64解密回来再给RSA解密
        byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(param), publicKey);

        result = new String(decryptByte);

        return result;
    }

}
