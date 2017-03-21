package com.example.ja010.week3;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.ja010.week3.R.id.t1;

public class Main2Activity extends AppCompatActivity {
    Switch sw1;
    Chronometer c1;
    GridLayout l1,l2,l3,l4;
    DatePicker d1;
    TimePicker p1;
    TextView t1,t2,t3,t4,t5;
    EditText e1,e2,e3;
    int ad,yo,ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        c1 = (Chronometer)findViewById(R.id.ch2);
        l1 = (GridLayout)findViewById(R.id.first);
        l2 = (GridLayout)findViewById(R.id.second);
        l3 =(GridLayout)findViewById(R.id.third);
        l4 = (GridLayout)findViewById(R.id.fourth);
        t1 = (TextView)findViewById(R.id.tx1);
        t2 = (TextView)findViewById(R.id.tx2);
        t3 = (TextView)findViewById(R.id.tx3);
        t4 = (TextView)findViewById(R.id.tx4);
        t5 = (TextView)findViewById(R.id.tx5);
        e1 = (EditText)findViewById(R.id.ex1);
        e2 = (EditText)findViewById(R.id.ex2);
        e3 = (EditText)findViewById(R.id.ex3);
        setTitle("레스토랑 예약 시스템 ");
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
            int ad = zero(e1.getText().toString());
            int yo =zero(e2.getText().toString());
            int ch = zero(e3.getText().toString());
            peoples(ad,yo,ch);
        }
        else if(v.getId() == R.id.bbf4){
            lay3();
        }
    }
    void swc(){ // switch
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
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
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
        dp();
    }
    void lay2(){ //timepicker 화면출력
        l1.setVisibility(View.INVISIBLE);
        l2.setVisibility(View.VISIBLE);
        l3.setVisibility(View.INVISIBLE);
        tp();
    }
    void lay3() { //people check layer
        l2.setVisibility(View.INVISIBLE);
        l3.setVisibility(View.VISIBLE);
        l4.setVisibility(View.INVISIBLE);
        peoples(ad,yo,ch);


    }
    void lay4(){ //final layer
        l3.setVisibility(View.INVISIBLE);
        l4.setVisibility(View.VISIBLE);
    }
    void dp(){
        d1 = (DatePicker)findViewById(R.id.dk2);
        d1.init(d1.getYear(), d1.getMonth(), d1.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
               dataset(year,monthOfYear,dayOfMonth);
            }
        });
    }
    void dataset(int a, int b, int c){
        String xx = String.format("날짜:                                      %d년 %d월 %d일",a,b+1,c);
        t1.setText(xx);
    }
    void tp(){
        p1 = (TimePicker)findViewById(R.id.tk1);
        p1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timeset(hourOfDay,minute);
            }
        });
    }
    void timeset(int a ,int b){
        String xzz = String.format("시간:                                      %d 시 %d 분",a,b);
        t2.setText(xzz);
    }
    void peoples(int a,int b, int c){//문자를 받기

        String xx = String.format("성인:                                      %d 명",a);
        String xy= String.format("청소년:                                  %d 명",b);
        String xz = String.format("어린이:                                 %d 명",c);
        t3.setText(xx);
        t4.setText(xy);
        t5.setText(xz);
    }
    int zero(String a){
            int zz;
        if(a.getBytes().length == 0){
            return 0;
        }
        else{
            zz = Integer.parseInt(a);
            return zz;
        }
    }
}
