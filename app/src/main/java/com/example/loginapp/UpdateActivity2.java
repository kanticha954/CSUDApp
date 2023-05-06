package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateActivity2 extends AppCompatActivity {
    String getA, getB, getC, getD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update2);
        String stid = getIntent().getStringExtra("stid");
        TextView stidText = (TextView) findViewById(R.id.stid2);

        EditText fiedAEdit = (EditText) findViewById(R.id.fieldA);
        EditText fiedBEdit = (EditText) findViewById(R.id.fieldB);
        EditText fiedCEdit = (EditText) findViewById(R.id.fieldC);
        EditText fiedDEdit = (EditText) findViewById(R.id.fieldD);

        Button deleteButton = (Button) findViewById(R.id.delete);
        Button updateButton = (Button) findViewById(R.id.updateButt);
        Button exitButton = (Button) findViewById(R.id.exitButt);

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





        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("func","func delete");
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("func","func update");
                Log.d("get","getA = "+getA+" getB = "+getB+" getC = "+getC+" getD = "+getD);
                Intent intent = new Intent(UpdateActivity2.this, DataViewActivity.class);
                intent.putExtra("stid", stid);
                intent.putExtra("getA",getA);
                intent.putExtra("getB",getB);
                intent.putExtra("getC",getC);
                intent.putExtra("getD",getD);
                startActivity(intent);
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateActivity2.this, DataViewActivity.class);
                startActivity(intent);
            }
        });
    }


}