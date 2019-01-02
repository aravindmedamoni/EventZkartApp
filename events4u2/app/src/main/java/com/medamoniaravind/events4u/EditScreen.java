package com.medamoniaravind.events4u;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditScreen extends AppCompatActivity {
    TextView ed_name,ed_mail,ed_number;
    SharedPreferences sharedPreferences;
    String st_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);
        ed_name=findViewById(R.id.edt_name);
        ed_mail=findViewById(R.id.edt_mail);
        ed_number=findViewById(R.id.edt_num);
        sharedPreferences=getSharedPreferences("abhi",MODE_PRIVATE);
        st_num=sharedPreferences.getString("mobile",null);
        ed_number.setText("Mobile Number: "+st_num);
    }

    public void donebtn(View view) {
    }
}
