package com.medamoniaravind.events4u.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.medamoniaravind.events4u.Customclasses.CustomhomeAdapter;
import com.medamoniaravind.events4u.Eventpojo;
import com.medamoniaravind.events4u.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    ListView home_lv;
    TextView home_event;
    List<Eventpojo> list=new ArrayList<Eventpojo>();
    String url="http://vdtlabs.com/eventzapp/list_events.json";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home,container,false);
        home_event=view.findViewById(R.id.hm_event);
        home_lv=view.findViewById(R.id.hm_lv);
        searchevetns();
        return view;
    }

    public void searchevetns(){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("events",response.toString());
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        String title=jsonObject.getString("title");
                        String price=jsonObject.getString("price");
                        String date=jsonObject.getString("date");
                        String venue=jsonObject.getString("venue");
                        String image=jsonObject.getString("image");

                        list.add(new Eventpojo(title,price,date,venue,image));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                CustomhomeAdapter customhomeAdapter=new CustomhomeAdapter(getContext(),list);
                customhomeAdapter.notifyDataSetChanged();
                home_lv.setAdapter(customhomeAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);

    }
}
