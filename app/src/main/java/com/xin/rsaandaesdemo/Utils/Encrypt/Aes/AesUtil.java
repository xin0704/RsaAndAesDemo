package com.xin.rsaandaesdemo.Utils.Encrypt.Aes;

/**
 * Created by admin on 2019/1/31.
 */

import com.xin.rsaandaesdemo.Utils.Encrypt.Base64Utils;

import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * AES 是一种可逆加密算法，对用户的敏感信息加密处理 对原始数据进行AES加密后，在进行Base64编码转化；
 */

public class AesUtil {

    private static String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";//生成key的基础字符串

    /*
     * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
     */
    public static String getAesKey() {

        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 加密
     *
     * @param encData   要加密的内容
     * @param secretKey 加密的秘钥
     * @return 加密后的字符串
     * @throws Exception
     */

    public static String encrypt(String secretKey,String encData) throws Exception {
        if (secretKey == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = secretKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(new byte[cipher.getBlockSize()]);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(encData.getBytes("utf-8"));
        return Base64Utils.encode(encrypted).replaceAll("\r|\n", "");// 此处使用BASE64做转码。
    }

    /**
     * 解密
     *
     * @param sSrc 要解密的内容
     * @param key  解密要秘钥
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String decrypt( String key,String sSrc) throws
            Exception {

        byte[] raw = key.getBytes("ASCII");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(new byte[cipher.getBlockSize()]);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted1 = Base64Utils.decode(sSrc);// 先用base64解密
        byte[] original = cipher.doFinal(encrypted1);
        return new String(original, "utf-8");

    }
}

