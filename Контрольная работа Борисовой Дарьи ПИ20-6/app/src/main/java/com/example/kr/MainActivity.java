package com.example.kr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editTextNumber);
        editText2 = findViewById(R.id.editTextNumber2);
    }

    public void onEnterButtonClick(View view)
    {
        int pulse1 = Integer.parseInt(editText1.getText().toString());
        int pulse2 = Integer.parseInt(editText2.getText().toString());
        int diff = Math.abs(pulse1-pulse2);

        Intent myIntent;
        if (diff < 13)
        {
            myIntent = new Intent(this, MainActivity2.class);
        }
        else
        {
            myIntent = new Intent(this, MainActivity3.class);
        }

        startActivity(myIntent);
    }
}