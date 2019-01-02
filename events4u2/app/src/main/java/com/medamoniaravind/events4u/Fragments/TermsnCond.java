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


public class TermsnCond extends Fragment {
    TextView tmncd_tv1,tmncd_tv2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tmncd,container,false);
        tmncd_tv1=view.findViewById(R.id.tmncd_tv1);
        tmncd_tv2=view.findViewById(R.id.tmncd_tv2);
        tmncd_tv1.setText("Welcome to EventsNow!!\n" +
                "EventsNow enables people to explore happening events in the city and gets the event of the organizer live on the website. we promote events and sell the event tickets on our website. This page contains the terms and conditions, which will govern the usage of our services.\n" +
                "\n" +
                "By using EventsNow website on your desktop or mobile or EventsNow mobile app, you the user/registrant is agreeing to these Terms and Conditions and there will be a legally binding contract with EventsNow. If you disagree with any part of these terms, we request you to exit immediately. Your use of the EventsNow is entirely at your own risk for which we shall not be liable for any issue.\n");
        tmncd_tv2.setText(
                "\n 1.The content of the pages of this site is for your general information. It is liable to change without notification. EventsNow reserves the right to modify or replace any Terms or Conditions without giving any prior notice.\n" +
                        "2.Rights of Admission are reserved and can be controlled, only by the organizer of the event.\n" +
                        "3.Neither EventsNow nor its employees, agents, third-party information providers, merchants, licensors or the like warrant that the Website or its operation will be accurate, reliable, uninterrupted or error-free. No agent or representative has the authority to create any warranty regarding the Website on behalf of EventsNow. We reserve the right to change or discontinue, any aspect or features of the Website at any time.\n" +
                        "4.Organizers hold the right to frisk and limit entry at the event venue.\n" +
                        "5.EventsNow cannot be held responsible or assume any liability for the misfortune or robbery of any individual assets of the ticket buyers or their representatives attending the event.\n" +
                        "6.All payments/orders related disputes should be raised within 24 hours of the payment. No disputes related to payments/orders will be considered as valid after 24 hours of the payment.\n" +
                        "7.The essential ticket/pass holder (name said on it) ought to be available alongside the ID confirmation to get the entry into the venue. Inability to create an ID verification may restrict the entry of the individual into the event.\n" +
                        "8.You will be issued a e-receipt for the cash that you pay to EventsNow at the time of enrollment for an event.\n" +
                        "9.Please protect the Tickets / Passes from any kind of damage, tampering and alteration. If Tickets / Passes should are found to be damaged, tampered or altered the organizer reserves the right to deny entry of the individual to the event.\n" +
                        "10.Kindly reach the venue at least an hour before the start time of the event to avoid last minute rush and delays in collecting tickets/passes.\n" +
                        "11.The design and content on Eventsnow is copyrighted and licensed, reproduction, copying and misuse of the design and content of Eventsnow is a criminal offense.\n" +
                        "12.All trademarks duplicated in this site which are not the property of, or authorized to, the administrator are recognized on the website.\n" +
                        "13.Unauthorized utilization of this site may offer ascent to a case for damage and/or be a criminal offense.\n" +
                        "14.Eventsnow might time and again redirect users or use links to other websites for informative and operational purposes based on the requirement, It does not imply that we support the other website (s) or it's purpose and we would not be responsible for that particular website's functionality or content.\n" +
                        "15.Any disputes shall be subject to the exclusive jurisdiction of the Indian courts.");
        return view;
    }
}
