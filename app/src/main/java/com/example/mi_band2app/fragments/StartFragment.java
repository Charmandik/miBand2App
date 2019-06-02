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

public class StartFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity.getInstance().startFragment = this;
        return inflater.inflate(R.layout.start_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button signInBtn = view.findViewById(R.id.start_signin);
        Button signUpBtn = view.findViewById(R.id.start_signup);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().setLoginFragment();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().setRegistryFragment();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity.getInstance().startFragment = null;
    }
}
