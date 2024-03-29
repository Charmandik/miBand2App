package com.example.mi_band2app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mi_band2app.MainActivity;
import com.example.mi_band2app.R;

public class ProfileFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity.getInstance().profileFragment = this;
        return inflater.inflate(R.layout.profile_fragment, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity.getInstance().profileFragment = null;
    }
}
