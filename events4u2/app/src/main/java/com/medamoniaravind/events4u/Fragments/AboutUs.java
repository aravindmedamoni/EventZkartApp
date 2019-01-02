package com.medamoniaravind.events4u.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.medamoniaravind.events4u.R;

public class AboutUs extends Fragment {
    TextView abt_text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.aboutus,container,false);
        abt_text=view.findViewById(R.id.abt_txt);
        abt_text.setText("Feeling lonely? Feeling bored?? huhh?\n" +
                "\n" +
                "If you moved to an other city...if your from the same city yet you are not aware of various set of things going on in the city. Don't worry, here is the app for you!\n" +
                "\n" +
                "International, national, local events all under one roof for you. Let it be the famous concert of your favorite super star singer or the upcoming band of college performing in the local cafe or a five star hotel.\n" +
                "\n" +
                "LOL....hahahaha.....rofl........LOL....hahaha(laughs)..In this stressfull and busy life missing the laughs and fun...? Wanna go out for a stand up comedy night or shows.\n" +
                "\n" +
                "Wanna learn any class? Cooking..? dancing? Yoga? Or else a few day workshop?\n" +
                "\n" +
                "You wanna spent holiday in the best resorts of your city...or attend international carnivals?\n" +
                "\n" +
                "Any professional conferences need your presence? Or a motivational speaker want to meet you?\n" +
                "\n" +
                "Cricket is your best friend? IPL's are fun! Wanna participate in any run's? or a championship?\n" +
                "\n" +
                "Not only these many events like new year, fesitivals like holi...and so onnn there are many events going in and around your city...This app will be the one stop for all of those.\n" +
                "\n" +
                "You can book tickets and get discounts. You can even gift an experience to your love one's.\n" +
                "\n" +
                "Download this app and get rid of your boredom...");
        return view;
    }
}
