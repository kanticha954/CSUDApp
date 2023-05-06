package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SelectActivity extends AppCompatActivity {
    String stid ;
    //String url;
    //String url = "https://publicobject.com/helloworld.txt";
    String url = "https://demo.hashup.tech/std/items?std_id=100";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        EditText stidEdit = (EditText) findViewById(R.id.sdid);
        Button loginButton = (Button) findViewById(R.id.login);
        Button exitButton = (Button) findViewById(R.id.exit2);


        stidEdit.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                stid = stidEdit.getText().toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectActivity.this, DataViewActivity.class);
                startActivity(intent);
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (stid != null) {
//                    url = "https://demo.hashup.tech/std/items?std_id="+stid;
//                    Log.d("url","url"+url);

                    Log.d("stid", "stid : " + stid);

                    Log.d("status", "Status : Login Success");
                    Intent intent = new Intent(SelectActivity.this, DataViewActivity.class);
                    intent.putExtra("stid", stid);
                    startActivity(intent);

                } else {
                    Log.d("stid", "stid : " + stid);
                    Log.d("status", "Status : Login Error");
                    Intent intent = new Intent(SelectActivity.this, DataViewActivity.class);
                    intent.putExtra("stid", stid);
                    startActivity(intent);

                }
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
                final String myResponse = response.body().string();
                Log.d("response","response + "+myResponse);
            }
        });
    }

}