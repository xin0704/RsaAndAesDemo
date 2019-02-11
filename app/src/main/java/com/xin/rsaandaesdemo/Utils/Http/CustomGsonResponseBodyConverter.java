package com.xin.rsaandaesdemo.Utils.Http;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.xin.rsaandaesdemo.Utils.Encrypt.Aes.Aes;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by admin on 2019/1/24.
 */

public class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {

        String response = value.string();

        String result = null;

        try {
            result = Aes.decode(response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException("数据解密失败");
        }

        InputStream is = new ByteArrayInputStream(result.getBytes());
        InputStreamReader reader = new InputStreamReader(is, Charset.forName("UTF-8"));

        JsonReader jsonReader = gson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}