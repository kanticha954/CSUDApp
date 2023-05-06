package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataViewActivity extends AppCompatActivity {
    String stid = getIntent().getStringExtra("stid");
    String url = "https://demo.hashup.tech/std/items?std_id=63050095";

    String[] getData = new String[10];
    ListView simpleList;
    //String data[] = {"India", "China", "Australia", "Portugol", "America", "NewZealand", "Thailand", "Laos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataview_activity);
        String stid = getIntent().getStringExtra("stid");
        Button newButton = (Button) findViewById(R.id.newButt2);
        Button exitButton = (Button) findViewById(R.id.exit2);
        simpleList = (ListView) findViewById(R.id.listview);

        Log.d("url", "url"+url);
        Log.d("stid","get stid"+stid);
        for (int i = 0; i < getData.length ; i++) {
            Log.d("getData","getData["+i+"]");

        }


        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedItem = (String) adapterView.getItemAtPosition(position);
                Log.d("position", "position"+position);
                //itemSelect.setText("Best Country : "+ countryList[position]);
                Intent intent = new Intent(DataViewActivity.this, UpdateActivity2.class);
                intent.putExtra("stid", stid);
                startActivity(intent);

            }
        });

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataViewActivity.this, InsertActivity.class);
                intent.putExtra("stid",stid);
                startActivity(intent);
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataViewActivity.this, SelectActivity.class);
                startActivity(intent);
            }
        });
        try{
            run();
        }   catch (IOException e) {

        }
    }


    void run() throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                String[] getData = new String[10];
                final String myResponse = response.body().string();
                Log.d("response","response + "+myResponse);
                try {
                    JSONObject jsonObject = new JSONObject(myResponse);
                    JSONArray data = jsonObject.getJSONArray("data");
                    getData = new String[data.length()];
                    for (int i = 0; i < data.length() ; i++) {
                        getData[i] = data.getJSONObject(i).getString("field_a").toString();
                        //Log.d("getData","getData["+i+"]");
                        //Log.d("get", data.getJSONObject(i).getString("field_a").toString());
                       // Log.d("get", data.getJSONObject(i).getString("field_a").toString());
                    }

                    DataViewActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DataViewActivity.this, R.layout.listview, R.id.textView, getData);
                            simpleList.setAdapter(arrayAdapter);
                        }
                    });


                    //Log.d("get", data.getJSONObject(0).getString("field_a").toString());
                } catch (JSONException err) {
                    Log.d("Error", err.toString());
                }
            }
        });
    }

}