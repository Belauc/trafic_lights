package com.example.traficlights;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class YellowColorFragment extends Fragment {

    public YellowColorFragment() {
        // Required empty public constructor
    }

    public static YellowColorFragment newInstance(String param1, String param2) {
        YellowColorFragment fragment = new YellowColorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_yellow_color, container, false);
    }

}
