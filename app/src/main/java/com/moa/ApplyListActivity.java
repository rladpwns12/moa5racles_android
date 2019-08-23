package com.moa;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.moa.adapter.ListAdapter;
import com.moa.model.vo.RequestListVO;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplyListActivity extends Activity {
    private List<RequestListVO> list;
    private ListView listView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applylist);
        list = new ArrayList<RequestListVO>();

        new RequestListHttpThread("http://192.168.30.164:8089/mobile/host/list").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        listView = findViewById(R.id.listView);
        listAdapter = new ListAdapter(list, this);
        listView.setAdapter(listAdapter);
    }


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
                connection.setRequestProperty("Content-Type","application/json");


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
                JSONObject object = XML.toJSONObject(result);


                //실패시
                if(status != HttpURLConnection.HTTP_OK){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "실패!\n"+result, Toast.LENGTH_LONG).show();
                        }
                    });
                    return;
                }

                //성공시
                JSONArray jsonArray = object.getJSONObject("List").getJSONArray("item");

                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject obj = jsonArray.getJSONObject(i);
                    list.add(new RequestListVO(obj.get("date").toString(),obj.get("time").toString(),
                            obj.get("nick").toString(),obj.get("price").toString()));
                }
                            }catch (Exception e){
                Log.d("RequestListActivity",e.getMessage());
            }
            return;
        }
    }
}