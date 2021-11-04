package com.example.md13;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfo;
    private EditText etInput;
    private Button bControl;

    private int number;
    private boolean isGameFinished;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.textView);
        etInput = (EditText) findViewById(R.id.editTextNumber);
        bControl = (Button) findViewById(R.id.button);

        genNumber();
        isGameFinished = false;
    }

    public void onClick(View v)
    {
        if (!isGameFinished)
        {
            int inValue = Integer.parseInt(etInput.getText().toString());
            if (inValue == number)
            {
                isGameFinished = true;
                tvInfo.setText(getResources().getString(R.string.hit));
                bControl.setText(getResources().getString(R.string.play_more));
            }
            else if (inValue < number)
            {
                tvInfo.setText(getResources().getString(R.string.behind));
            }
            else
            {
                tvInfo.setText(getResources().getString(R.string.ahead));
            }
        }
        else
        {
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            genNumber();
        }
    }

    private void genNumber()
    {
        number = (int) (Math.random() * 101);
        bControl.setText(getResources().getString(R.string.input_value));
    }
}