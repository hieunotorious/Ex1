package com.example.rutbai;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button rutbai;ImageView la1;
    ImageView la2;
    ImageView la3;
    TextView thongbao;
    int sonut=0;
    int darut=0;
    boolean batay=true;
    String chuoithongbao="";
    ArrayList<String> cacladarut=new ArrayList<String>();
    int manghinhbai[][]={
            {R.drawable.b2fv,
                    R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                    R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
                    R.drawable.cj,R.drawable.cq,R.drawable.ck},
            {R.drawable.b2fv,
                    R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
                    R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
                    R.drawable.dj,R.drawable.dq,R.drawable.dk},
            {R.drawable.b2fv,
                    R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
                    R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
                    R.drawable.hj,R.drawable.hq,R.drawable.hk},
            {R.drawable.b2fv,
                    R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
                    R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
                    R.drawable.sj,R.drawable.sq,R.drawable.sk}
    };
    String mangtenbai[][]={
            {"rong",
                    "xì chuồn","hai chuồn","ba chuồn","bốn chuồn","năm chuồn",
                    "sáu chuồn","bảy chuồn","tám chuồn","chín chuồn","mười chuồn",
                    "bồi chuồn","đầm chuồn","già chuồn"},
            {"rong",
                    "xì rô","hai rô","ba rô","bốn rô","năm rô",
                    "sáu rô","bảy rô","tám rô","chín rô","mười rô",
                    "bồi rô","đầm rô","già rô"},
            {"rong",
                    "xì cơ","hai cơ","ba cơ","bốn cơ","năm cơ",
                    "sáu cơ","bảy cơ","tám cơ","chín cơ","mười cơ",
                    "bồi cơ","đầm cơ","già cơ"},
            {"rong",
                    "xì bích","hai bích","ba bích","bốn bích","năm bích",
                    "sáu bích","bảy bích","tám bích","chín bích","mười bích",
                    "bồi bích","đầm bích","già bích"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rutbai=(Button)findViewById(R.id.rutbai);
        la1=(ImageView)findViewById(R.id.ivla1);
        la2=(ImageView)findViewById(R.id.ivla2);
        la3=(ImageView)findViewById(R.id.ivla3);
        thongbao=(TextView)findViewById(R.id.txtthongbao);
        rutbai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(darut==0)
                {darut=0;
                    sonut=0;
                    batay=true;
                    chuoithongbao="";
                    la1.setImageResource(R.drawable.b2fv);
                    la2.setImageResource(R.drawable.b2fv);
                    la3.setImageResource(R.drawable.b2fv);
                    cacladarut.clear();
                }
                darut++; 

                Random rd=new Random();
                int x,y;

                while(true)
                {
                    x=rd.nextInt(4);
                    y=rd.nextInt(13)+1;
                    if(cacladarut.contains(mangtenbai[x][y])==false)
                    {
                        cacladarut.add(mangtenbai[x][y]);
                        break;
                    }
                }

                if(y<11)
                    batay=false;
                if(darut==1)
                {
                    sonut+=(y<10)?y:0;
                    labai1.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==2)
                {
                    sonut+=(y<10)?y:0;
                    labai2.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==3)
                {
                    sonut+=(y<10)?y:0;
                    int kq=sonut%10;
                    darut=0;
                    labai3.setImageResource(manghinhbai[x][y]);
                    chuoithongbao+=" --> Số nút là "+ kq;

                }
                thongbao.setText("Các lá đã rút "+ cacladarut.toString() + chuoithongbao + "\n"
                        +"----> Ba tây: "+batay);
            }
        });
    }
}