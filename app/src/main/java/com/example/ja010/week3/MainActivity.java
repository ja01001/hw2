package com.example.ja010.week3;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.ja010.week3.R.attr.colorAccent;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    TextView t1,t2;
    int eng,kor,mat,sum, ave;
    ImageView im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        e3 = (EditText)findViewById(R.id.e3);
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        im1 = (ImageView) findViewById(R.id.im1);


    }

    public void Onclick(View v){ // 이벤트
        if(v.getId() == R.id.b1){
            kor = v(e1.getText().toString());
            mat = v(e2.getText().toString());
            eng = v(e3.getText().toString());
            init(kor,mat,eng);
        }
        else if (v.getId() == R.id.b2){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            t1.setText("0원");
            t2.setText("0원");
            im1.setImageResource(0);
            Toast.makeText(getApplicationContext(),"초기화 되었습니다.",Toast.LENGTH_SHORT).show();
        }
    }
    void init(int a,int b,int c){//계산
        sum = a+b+c;
        ave = sum/3;
        t1.setText(sum+"점");
        t2.setText(ave+"점");
        if (ave >= 90){
            im1.setImageResource(R.drawable.a);
        }
        else if (ave >= 80){
            im1.setImageResource(R.drawable.b);
        }
        else if (ave >= 70){
            im1.setImageResource(R.drawable.c);
        }
        else if (ave >= 60){
            im1.setImageResource(R.drawable.d);
        }
        else{
            im1.setImageResource(R.drawable.f);
        }
    }
    // 0값 검사
    int v (String x){
        int zz;
       if( x.getBytes().length == 0){
           return 0;
       }
       else{
           zz = Integer.parseInt(x);
            return zz;
        }
    }

}
