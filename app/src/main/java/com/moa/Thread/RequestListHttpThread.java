package com.moa.Thread;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestListHttpThread extends Thread {
    private String url;
    private String result;

    public RequestListHttpThread(String url){
        this.url = url;
    }

    @Override
    public void run() {
        HttpURLConnection connection;
        try{
            connection = (HttpURLConnection)new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type","application/json");

            int status = connection.getResponseCode();
            InputStream inputStream;

            if(status != HttpURLConnection.HTTP_OK){
                inputStream = connection.getErrorStream();
            }else{
                inputStream = connection.getInputStream();
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

            StringBuffer stringBuffer = new StringBuffer();
            String line = bufferedReader.readLine();
            while(line != null){
                stringBuffer.append(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            result = stringBuffer.toString();
            System.out.println(result);

            //실패시
//            if(status != HttpURLConnection.HTTP_OK){
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(), "실패!\n"+result, Toast.LENGTH_LONG).show();
//                        Log.d("whyError?",result);
//                    }
//                });
//
//                return;
//            }

        }catch (Exception e){

        }
    }
}
