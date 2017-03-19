package com.example.ja010.week3;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Switch sw1;
    Chronometer c1;
    GridLayout l1,l2,l3,l4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        c1 = (Chronometer)findViewById(R.id.ch2);
        l1 = (GridLayout)findViewById(R.id.first);
        l2 = (GridLayout)findViewById(R.id.second);
        l3 =(GridLayout)findViewById(R.id.third);
        l4 = (GridLayout)findViewById(R.id.fourth);

        swc();
    }
    public void clcl(View v){// 클릭이벤트
        if(v.getId()==R.id.bnext1){
            lay2();
        }
        else if(v.getId()==R.id.bbf2){
            lay1();
        }
        else if(v.getId() == R.id.bnext2){
            lay3();
        }
        else if(v.getId()==R.id.bbf3){
            lay2();
        }
        else if(v.getId() == R.id.bnext3){
            lay4();
        }
        else if(v.getId() == R.id.bbf4){
            lay3();
        }
    }
    void swc(){
        sw1 = (Switch)findViewById(R.id.s1);
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               //실험  Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                if(isChecked == true){
                    count();
                    lay1();

                }
                else{
                    reset();
                }
            }
        });

    }
    void reset(){// 초기화 작업
        c1.setBase(SystemClock.elapsedRealtime()); // time 초기화
        c1.setVisibility(View.INVISIBLE); // time close

        l1.setVisibility(View.INVISIBLE);
        l2.setVisibility(View.INVISIBLE);
        l3.setVisibility(View.INVISIBLE);
        l4.setVisibility(View.INVISIBLE);
    }

    void count(){// timer 실행
        c1.setVisibility(View.VISIBLE); // time open
        c1.setFormat("예약시작 경과시간 : %s");
        c1.start();

    }
    void lay1(){ // layout datapicker 화면 출력
        //작동확인 Toast.makeText(getApplicationContext(),"화면출력",Toast.LENGTH_SHORT).show();
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.INVISIBLE);
    }
    void lay2(){ //timepicker 화면출력
        l1.setVisibility(View.INVISIBLE);
        l2.setVisibility(View.VISIBLE);
        l3.setVisibility(View.INVISIBLE);
    }
    void lay3(){ //people check layer
        l2.setVisibility(View.INVISIBLE);
        l3.setVisibility(View.VISIBLE);
        l4.setVisibility(View.INVISIBLE);
    }
    void lay4(){ //final layer
        l3.setVisibility(View.INVISIBLE);
        l4.setVisibility(View.VISIBLE);
    }
}
