package com.moa;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.moa.adapter.RequestListAdapter;
import com.moa.model.vo.RequestListVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RequestListActivity extends Activity {
    private List<RequestListVO> list;
    private ListView listView;
    private RequestListAdapter requestListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestlist);
        list = new ArrayList<RequestListVO>();

        new RequestListHttpThread("http://localhost:8089/mobile/requestlist").start();
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
                if(status != HttpURLConnection.HTTP_OK){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "실패!\n"+result, Toast.LENGTH_LONG).show();
                            Log.d("whyError?",result);
                        }
                    });
                    return;
                }

                //성공시
                JSONArray jsonArray = new JSONArray(result);
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    list.add(new RequestListVO(object.get("date").toString(),object.get("time").toString(),
                            object.get("nick").toString(),object.get("price").toString()));
                }

            }catch (Exception e){
                Log.d("RequestListActivity",e.getStackTrace().toString());
            }
        }
    }




}