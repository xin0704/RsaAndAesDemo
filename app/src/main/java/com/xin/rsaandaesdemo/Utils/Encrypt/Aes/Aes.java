package com.xin.rsaandaesdemo.Utils.Encrypt.Aes;

import android.util.Log;

import com.xin.rsaandaesdemo.Base.MyApplication;
import com.xin.rsaandaesdemo.Constants.Constants;
import com.xin.rsaandaesdemo.Utils.Encrypt.Rsa.Rsa2;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by admin on 2019/1/30.
 */

public class Aes {

    public static RequestBody encode(String param) throws Exception {

        // 生成 AES 秘钥
        String aes_key = AesUtil.getAesKey();
        Log.d("========",aes_key);
        // 加密
        String result = AesUtil.encrypt(aes_key, param);
        // 用RSA加密AES秘钥
        String result_aes_key = Rsa2.encode(aes_key);
        //将加密后的AES秘钥存在SP中 方便接口调用的时候传递给服务器解密数据
        MyApplication.editor
                .putString(Constants.AES_SP_KEY,result_aes_key)
                .commit();

        return RequestBody.create(MediaType.parse(Constants.MEDIA_TYPE), result);
    }

    public static String decode(String param) throws Exception {

        //从sp中取得RSA加密后的AES秘钥
        String aes_key = MyApplication.sp.getString(Constants.AES_SP_KEY, "");
        //用RSA公钥解密AES秘钥  解密后的AES秘钥 可以直接用来解密数据
        aes_key = Rsa2.decode(aes_key);
        //通过AES 解密数据
        String result = AesUtil.decrypt(aes_key, param);

        return result;
    }

}
