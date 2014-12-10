package com.wass08.futureseduction.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.wass08.futureseduction.R;
import com.wass08.futureseduction.sender.NotificationSender;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class CustomFragment extends android.support.v4.app.Fragment {


    private EditText editTitle;
    private EditText editContent;

    public CustomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_custom, container, false);
        editTitle = (EditText)v.findViewById(R.id.custom_input_title);
        editContent = (EditText)v.findViewById(R.id.custom_input_content);
        Button sendCustom = (Button)v.findViewById(R.id.button_custom_send);
        sendCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCustomNotification(view);
            }
        });
        return v;
    }

    public void sendCustomNotification(View v) {
        NotificationSender.sendCustomNotification(getActivity(), editTitle.getText().toString(), editContent.getText().toString());
    }


}
