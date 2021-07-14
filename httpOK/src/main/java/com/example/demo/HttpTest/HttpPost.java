package com.example.demo.HttpTest;

import okhttp3.*;

import java.io.IOException;

public class HttpPost {
    public static final MediaType Json
            = MediaType.get("application/json;charset=utf-8");
    public static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {

        String aaa = post("https://www.baidu.com", "aaa");
        System.out.println(aaa);
    }

    private static String post(String url,String json){
        RequestBody body = RequestBody.create(json,Json);
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .post(body)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
