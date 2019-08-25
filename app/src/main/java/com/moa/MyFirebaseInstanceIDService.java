package com.moa;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String url = "http://5racle.powerlinux.co.kr/push/create";
    @Override
    public void onTokenRefresh(){
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("IDService","Refreshed token : "+refreshedToken);

        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token){
        RequestBody formBody = new FormBody.Builder()
                .add("token", token)
                .build();
        try{
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
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