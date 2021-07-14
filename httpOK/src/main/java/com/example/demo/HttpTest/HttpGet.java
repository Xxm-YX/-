package com.example.demo.HttpTest;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class HttpGet {

    public static void main(String[] args) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        String url = "http://localhost:8080/v1/models";
        //创建一个Request
        final Request request = new Request.Builder()
                .url(url)
                .build();
        //new call

        Call call = mOkHttpClient.newCall(request);

        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String string = response.body().string();
                System.out.println(string);
            }
        });
    }

}
