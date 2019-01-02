package com.medamoniaravind.events4u;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginScreen extends AppCompatActivity {

    EditText number_et,pswd_et;
    String lg_number,lg_pswd;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String url="http://vdtlabs.com/eventzapp/api.php?url=user_login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        sharedPreferences=getSharedPreferences("abhi",MODE_PRIVATE);
        number_et=findViewById(R.id.lgnumber);
        pswd_et=findViewById(R.id.lgpassword);
    }
    public void clickloginbtn(View view){
        lg_number=number_et.getText().toString();
        lg_pswd=pswd_et.getText().toString();
        progressDialog=new ProgressDialog(LoginScreen.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("please wait");
        progressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jobj=new JSONObject(response);
                    String status=jobj.getString("error");
                    String msg=jobj.getString("msg");
                    if (status.equals("FALSE")){
                        String id=jobj.getString("id");
                        editor=sharedPreferences.edit();
                        editor.putString("mobile",lg_number);
                        editor.putString("password",lg_pswd);
                        editor.putString("id",id);
                        editor.commit();
                        startActivity(new Intent(LoginScreen.this,NavigableScreen.class));
                        Toast.makeText(LoginScreen.this, msg, Toast.LENGTH_SHORT).show();
                        // progressDialog.dismiss();
                        finish();
                    }else {
                        Toast.makeText(LoginScreen.this, msg, Toast.LENGTH_SHORT).show();
                        // progressDialog.dismiss();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginScreen.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("mobile",lg_number);
                hashMap.put("password",lg_pswd);
                return hashMap;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(LoginScreen.this);
        requestQueue.add(stringRequest);

    }

    public void clickrgstrbtn(View view) {
        number_et.setText("");
        pswd_et.setText("");
        startActivity(new Intent(LoginScreen.this,RegisterScreen.class));
    }

    public void clickfrgtpswd(View view) {
        startActivity(new Intent(LoginScreen.this,ForgotScreen.class));
    }
}
