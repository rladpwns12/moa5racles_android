package com.moa;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.moa.adapter.ApplyListAdapter;
import com.moa.model.vo.ApplyListInfoVO;

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
    private List<ApplyListInfoVO> list;
    private ListView listView;
    private ApplyListAdapter applyListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applylist);
        list = new ArrayList<ApplyListInfoVO>();

        new RequestListHttpThread("http://5racle.powerlinux.co.kr/mobile/user/list").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        listView = findViewById(R.id.listView);
        applyListAdapter = new ApplyListAdapter(list, this);
        listView.setAdapter(applyListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int articleNum = ((ApplyListInfoVO)applyListAdapter.getItem(i)).getArticleNum();
//                Intent intent = new Intent(this, userRequestInfoActivity.class);
//                intent.putExtra("articleNum",articleNum);
//                startActivity(intent);
                Toast.makeText(getApplicationContext(),"게시글 번호 : "+articleNum, Toast.LENGTH_LONG).show();
            }
        });
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
                    ApplyListInfoVO applyListInfoVO = new ApplyListInfoVO(obj.getString("date"),obj.getString("time"),
                            obj.getString("nick"),obj.getString("price"),obj.getString("transactionType"),
                            obj.getString("baseAddress"),obj.getString("detailAddress"),Integer.parseInt(obj.get("articleNum").toString()));

                    list.add(applyListInfoVO);
                }
                            }catch (Exception e){
                Log.d("RequestListActivity",e.getMessage());
            }
            return;
        }
    }
}