package com.medamoniaravind.events4u.Customclasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.medamoniaravind.events4u.Eventpojo;
import com.medamoniaravind.events4u.R;

import java.util.List;

public class CustomhomeAdapter extends ArrayAdapter {
    Context ctx;
    List<Eventpojo> lst;
    TextView cst_tv1,cst_tv2,cst_tv3,cst_tv4;
    ImageView cst_iv5;
    public CustomhomeAdapter(Context context, List<Eventpojo> list) {
        super(context, R.layout.custom_home,list);
        this.ctx=context;
        this.lst=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater.from(ctx));
        convertView=layoutInflater.inflate(R.layout.custom_home,null,false);
        cst_tv1=convertView.findViewById(R.id.cs_title);
        cst_tv2=convertView.findViewById(R.id.cs_venue);
        cst_tv3=convertView.findViewById(R.id.cs_date);
        cst_tv4=convertView.findViewById(R.id.cs_price);
        cst_iv5=convertView.findViewById(R.id.cs_image);
        Eventpojo id=lst.get(position);
        String title=id.getEp_title();
        cst_tv1.setText(title);
        String venue=id.getEp_venue();
        cst_tv2.setText(venue);
        String date=id.getEp_date();
        cst_tv3.setText(date);
        String price=id.getEp_price();
        cst_tv4.setText("Rs "+price);
        Glide.with(ctx).load(id.getEp_image()).into(cst_iv5);
        return convertView;
    }
}
