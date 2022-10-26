package com.example.prac_4;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView1);
        etInput = (EditText)findViewById(R.id.editTextNumber1);
        bControl = (Button)findViewById(R.id.button1);

        guess = (int)(Math.random()*100);
        gameFinished = false;

    }

    public void onClick(View v){
        if (!gameFinished) {
            if (etInput.getText().toString().compareTo("") == 0) {
                tvInfo.setText(getResources().getString(R.string.error));
            }
            else {
                int inp = Integer.parseInt(etInput.getText().toString());
                if (inp > guess) {
                    if (inp <= 100) {
                        tvInfo.setText(getResources().getString(R.string.ahead));
                    }
                    else {
                        tvInfo.setText(getResources().getString(R.string.mnogo));
                    }
                }
                if (inp < guess) {
                    tvInfo.setText(getResources().getString(R.string.behind));
                }
                if (inp == guess) {
                    tvInfo.setText(getResources().getString(R.string.hit));
                    bControl.setText(getResources().getString(R.string.play_more));
                    gameFinished = true;
                }
            }
        }
        else {
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            guess = (int)(Math.random()*100);
            gameFinished = false;
        }

        etInput.setText("");

    }

}