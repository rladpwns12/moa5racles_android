package com.moa;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SendPushService {
    private static final String url = "http://5racle.powerlinux.co.kr/push/send";
    public static void sendPushService(int pushType){
        try{
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url + "/" + pushType)
                    .get()
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {System.out.println("error + Connect Server Error is " + e.toString());}

                @Override
                public void onResponse(Call call, Response response) throws IOException {System.out.println("Response Body is " + response.body().string());}
            });
        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }
}
