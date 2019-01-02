package com.medamoniaravind.events4u.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.medamoniaravind.events4u.R;

import java.net.URI;

public class Contact extends Fragment {

    TextView ct_wtsapp,ct_mail;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.contact,container,false);
       ct_wtsapp=view.findViewById(R.id.cnct_wtsapp);
       ct_mail=view.findViewById(R.id.cntct_mail);
       ct_mail.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Intent.ACTION_SEND);
               intent.setData(Uri.parse("aravindmedamoni@gmail.com"));
               intent.putExtra(Intent.EXTRA_SUBJECT,"hii this msg from eventzkart");
               intent.putExtra(Intent.EXTRA_TEXT,"this is my first msg");
               intent.setType("message/rfc822");
               getContext().startActivity(Intent.createChooser(intent,"send email"));
           }
       });

       ct_wtsapp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Intent.ACTION_SEND);
               intent.putExtra(Intent.EXTRA_SUBJECT,"Install this App");
               intent.setPackage("com.gbwhatsapp");
               intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id="+getContext().getPackageName());
               intent.setType("text/plain");
               getContext().startActivity(Intent.createChooser(intent,"send to whatsapp"));
           }
       });
        return view;
    }
}
