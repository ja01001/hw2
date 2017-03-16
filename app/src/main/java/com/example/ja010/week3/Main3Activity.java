package com.example.ja010.week3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relativelayout);




    }

    public void click(View v) { // 이벤트
        if (v.getId() == R.id.button0) {
            Intent ac = new Intent(Main3Activity.this, MainActivity.class);
            startActivity(ac);
        } else if (v.getId() == R.id.button1) {
            Intent ab = new Intent(Main3Activity.this, Main2Activity.class);
            startActivity(ab);
        }


    }
}