package com.example.choits.saneapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class RadialActivity extends ActionBarActivity {
    private TextView tv_yellow;
    private TextView tv_orange;
    private TextView tv_green;

    private SharedPreferences pref;
    private Boolean flag_first;

    protected void checkFirst(){
        pref=getSharedPreferences("pref",0);
        flag_first=pref.getBoolean("isFirst",true);

        if(flag_first==true){
            SharedPreferences.Editor editor=pref.edit();
            editor.putBoolean("isFirst", false);
            editor.commit();

            Intent i = new Intent("register.register");
            startActivity(i);
        }
        if(flag_first==false){

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkFirst();

        tv_yellow=(TextView)findViewById(R.id.btn_join_yellow);
        tv_yellow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("register.register");
                startActivity(i);
            }
        });

        tv_orange=(TextView)findViewById(R.id.btn_QnA_Orange);
        tv_orange.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("QnaActivity");
                startActivity(i);
            }
        });

        tv_green=(TextView)findViewById(R.id.btn_report_green);
        tv_green.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("MakeReport");
                startActivity(i);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}