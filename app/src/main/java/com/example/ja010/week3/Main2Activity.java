package com.example.ja010.week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Switch sw1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        swc();

    }
    void swc(){
        sw1 = (Switch)findViewById(R.id.s1);
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               //실험  Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                if(isChecked == true){
                    count();
                    lays();

                }
                else{
                    reset();
                }
            }
        });

    }
    void reset(){// 초기화 작업

    }

    void count(){// timer 실행
    }
    void lays(){ // layout datapicker 화면 출력
        //작동확인 Toast.makeText(getApplicationContext(),"화면출력",Toast.LENGTH_SHORT).show();

    }
}
