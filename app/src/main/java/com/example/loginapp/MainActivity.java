package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    String username ;
    String password ;
    //String url = "http://203.150.107.144:7777/login";
    String url = "https://publicobject.com/helloworld.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText usernameEdit = (EditText) findViewById(R.id.sdid);
        EditText passwordEdit = (EditText) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.login);
        Button startButton = (Button) findViewById(R.id.exit2);

        usernameEdit.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                username = usernameEdit.getText().toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        passwordEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                password = passwordEdit.getText().toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SelectActivity.class);
                startActivity(intent);
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(InsertActivity.this, MainActivity.class);
                //startActivity(intent);

                if (username != null && password != null) {
                    Log.d("username", "username : " + username);
                    Log.d("password", "password : " + password);
                    Log.d("status", "Status : Login Success");

//                    Intent intent = new Intent(InsertActivity.this, MainActivity.class);
//                    startActivity(intent);
                } else {
                    Log.d("username", "username : " + username);
                    Log.d("password", "password : " + password);
                    Log.d("status", "Status : Login Error");
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
