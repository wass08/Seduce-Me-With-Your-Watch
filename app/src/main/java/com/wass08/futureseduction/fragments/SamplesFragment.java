package com.wass08.futureseduction.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wass08.futureseduction.R;
import com.wass08.futureseduction.sender.NotificationSender;

/**
 * A simple {@link Fragment} subclass.
 */
public class SamplesFragment extends Fragment {


    public SamplesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_samples, container, false);
        Button manButton = (Button)v.findViewById(R.id.button_man_send);
        manButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendManNotification(view);
            }
        });
        Button womanButton = (Button)v.findViewById(R.id.button_woman_send);
        womanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendWomanNotification(view);
            }
        });
        Button loveButton = (Button)v.findViewById(R.id.button_love_send);
        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLoveNotification(view);
            }
        });
        return v;
    }

    public void sendManNotification(View view) {
        NotificationSender.sendDefaultManNotification(getActivity());
    }

    public void sendWomanNotification(View view) {
        NotificationSender.sendDefaultWomanNotification(getActivity());
    }

    public void sendLoveNotification(View view) {
        NotificationSender.sendDefaultLoveNotification(getActivity());
    }

}
