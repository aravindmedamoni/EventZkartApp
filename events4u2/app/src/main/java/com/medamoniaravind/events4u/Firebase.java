package com.medamoniaravind.events4u;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class Firebase extends FirebaseInstanceIdService {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String frbs_tokenid;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
       frbs_tokenid=FirebaseInstanceId.getInstance().getToken();
       Log.d("token",frbs_tokenid.toString());
       sharedPreferences=getSharedPreferences("aravnd",MODE_PRIVATE);
       editor=sharedPreferences.edit();
       editor.putString("token",frbs_tokenid);
       editor.commit();

    }
}
