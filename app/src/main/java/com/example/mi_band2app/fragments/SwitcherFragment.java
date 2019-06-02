package com.example.mi_band2app.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mi_band2app.MainActivity;
import com.example.mi_band2app.R;

public class SwitcherFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity.getInstance().switcherFragment = this;
        return inflater.inflate(R.layout.switcher_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button statusBtn = view.findViewById(R.id.switcher_status);
        Button actionBtn = view.findViewById(R.id.switcher_action);
        Button profileBtn = view.findViewById(R.id.switcher_profile);

        statusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().setStatusFragment();
            }
        });

        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().setActionGraphicFragment();
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().setProfileFragment();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity.getInstance().switcherFragment = null;
    }
}
