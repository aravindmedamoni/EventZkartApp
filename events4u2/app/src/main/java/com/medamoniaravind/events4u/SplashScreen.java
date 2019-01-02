package com.medamoniaravind.events4u;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class SplashScreen extends AppCompatActivity {

    ImageView sp_image;
    SharedPreferences sharedPreferences;
    String sp_mobile,sp_pswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sp_image=findViewById(R.id.animation_img);
        sharedPreferences=getSharedPreferences("abhi",MODE_PRIVATE);
        AnimationDrawable animationDrawable=(AnimationDrawable)sp_image.getDrawable();
        animationDrawable.setCallback(sp_image);
        animationDrawable.setVisible(true,true);
        animationDrawable.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sp_mobile=sharedPreferences.getString("mobile","null");
                sp_pswd=sharedPreferences.getString("password","null");
                if (sp_mobile.equals("null") && sp_pswd.equals("null")){
                    startActivity(new Intent(SplashScreen.this,LoginScreen.class));
                    finish();
                }else {
                    startActivity(new Intent(SplashScreen.this,NavigableScreen.class));
                    finish();
                }

            }
        },4*1000);
    }
}

