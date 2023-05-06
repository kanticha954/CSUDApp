package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InsertActivity extends AppCompatActivity {
    String getA, getB, getC, getD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        String stid = getIntent().getStringExtra("stid");
        Button saveButton = (Button) findViewById(R.id.save);
        Button exitButton = (Button) findViewById(R.id.exitButt);
        TextView stidText = (TextView) findViewById(R.id.stid);

        EditText fiedAEdit = (EditText) findViewById(R.id.fieldA);
        EditText fiedBEdit = (EditText) findViewById(R.id.fieldB);
        EditText fiedCEdit = (EditText) findViewById(R.id.fieldC);
        EditText fiedDEdit = (EditText) findViewById(R.id.fieldD);

        Log.d("stid","get stid"+stid);

        stidText.setText(stid);

        fiedAEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                getA = fiedAEdit.getText().toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        fiedBEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                getB = fiedBEdit.getText().toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        fiedCEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                getC = fiedCEdit.getText().toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        fiedDEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                getD = fiedDEdit.getText().toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("func","func save");
                Log.d("get","getA = "+getA+" getB = "+getB+" getC = "+getC+" getD = "+getD);
                Intent intent = new Intent(InsertActivity.this, DataViewActivity.class);
                startActivity(intent);

            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertActivity.this, DataViewActivity.class);
                startActivity(intent);
            }
        });

    }
}