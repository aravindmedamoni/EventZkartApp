package com.medamoniaravind.events4u.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.medamoniaravind.events4u.R;


public class LocationFrag extends Fragment {
    ListView ctsm_lstvw;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.custom_location,container,false);
        ctsm_lstvw=view.findViewById(R.id.cstm_lv);
        String[] cities={"Hyderabad","Amaravathi","Vijayavada","Vishakapatnam","Rajamandri","Varangal","Mbnr"};
        ArrayAdapter arrayAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,cities);
        ctsm_lstvw.setAdapter(arrayAdapter);
        ctsm_lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(getContext(), "hyd selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getContext(), "Amaravathi selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getContext(), "Vijayavada selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getContext(), "Vishakapatnam selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getContext(), "Rajamandri selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getContext(), "Varangal selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(getContext(), "Mbnr selected", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
        return view;
    }
}
