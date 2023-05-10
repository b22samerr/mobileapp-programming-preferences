package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private EditText skrivText;
    private Button button;
    private String sendText;
    SharedPreferences myPreferenceRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        skrivText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        myPreferenceRef = getSharedPreferences("pref", MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = myPreferenceRef.edit();
                sendText = skrivText.getText().toString();
                editor.putString("name", sendText);
                editor.apply();
                Log.d("==>", "going back");
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}