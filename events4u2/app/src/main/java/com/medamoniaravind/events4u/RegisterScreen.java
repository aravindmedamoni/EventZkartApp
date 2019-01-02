package com.medamoniaravind.events4u;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class RegisterScreen extends AppCompatActivity {

    EditText rgst_usrname,rgst_email,rgst_num,rgst_pswd;
    String username,email,cellnum,pswd;
    String url="http://vdtlabs.com/eventzapp/api.php?url=user_registration";
    ProgressDialog progressDialog;


    FirebaseAuth mAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    String otpsent;
    PhoneAuthProvider.ForceResendingToken forceresend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        mAuth = FirebaseAuth.getInstance();
        rgst_usrname=findViewById(R.id.rg_usrname);
        rgst_email=findViewById(R.id.rg_email);
        rgst_num=findViewById(R.id.rg_mbnumber);
        rgst_pswd=findViewById(R.id.rg_pswd);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                sendDatatoFirebase(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Log.w("", "onVerificationFailed", e);

                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    // ...
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                    // ...
                }


            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                otpsent = s;
                forceresend = forceResendingToken;

            }
        };



    }


    protected void sendDatatoFirebase(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("", "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w("", "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });

    }



    public void sendOtp(View view){
        String mnum = rgst_num.getText().toString();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(mnum,30,TimeUnit.SECONDS,RegisterScreen.this,mCallbacks);
    }


    public void clickeregister(View view) {
        username=rgst_usrname.getText().toString();
        email=rgst_email.getText().toString();
        cellnum=rgst_num.getText().toString();
        pswd=rgst_pswd.getText().toString();
        progressDialog=new ProgressDialog(RegisterScreen.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("please wait");
        progressDialog.show();
      /* rgst_usrname.setText("");
       rgst_email.setText("");*/

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                       // OnVerificationStateChangedCallbacks




                try {
                    JSONObject js=new JSONObject(response);
                    String status=js.getString("error");
                    String msg=js.getString("msg");
                    if (status.equals("FALSE")){
                        rgst_usrname.setText("");
                        rgst_email.setText("");
                        rgst_num.setText("");
                        rgst_pswd.setText("");
                        Toast.makeText(RegisterScreen.this, msg, Toast.LENGTH_SHORT).show();
                    }else {
                        rgst_num.setText("");
                        rgst_pswd.setText("");
                        Toast.makeText(RegisterScreen.this, msg, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterScreen.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("name",username);
                hashMap.put("email",email);
                hashMap.put("mobile",cellnum);
                hashMap.put("password",pswd);

                return hashMap;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(RegisterScreen.this);
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



}
