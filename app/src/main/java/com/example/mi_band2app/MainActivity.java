package com.example.mi_band2app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mi_band2app.fragments.ActionFragment;
import com.example.mi_band2app.fragments.ActionGraphicFragment;
import com.example.mi_band2app.fragments.LoginFragment;
import com.example.mi_band2app.fragments.ProfileFragment;
import com.example.mi_band2app.fragments.RecomendationFragment;
import com.example.mi_band2app.fragments.RegistryFragment;
import com.example.mi_band2app.fragments.StartFragment;
import com.example.mi_band2app.fragments.StatusFragment;
import com.example.mi_band2app.fragments.SwitcherFragment;

public class MainActivity extends AppCompatActivity {

    static MainActivity instance;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public StartFragment startFragment = null;
    public RegistryFragment registryFragment = null;
    public LoginFragment loginFragment = null;
    public SwitcherFragment switcherFragment = null;
    public StatusFragment statusFragment = null;
    public ActionGraphicFragment actionGraphicFragment = null;
    public ProfileFragment profileFragment = null;
    public RecomendationFragment recomendationFragment = null;
    public ActionFragment actionFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        instance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        setStartFragment();

    }

    public void setStartFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new StartFragment());
        fragmentTransaction.addToBackStack("null");
        fragmentTransaction.commit();
    }

    public void setRegistryFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new RegistryFragment());
        fragmentTransaction.addToBackStack("registry");
        fragmentTransaction.commit();
    }

    public void setLoginFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new LoginFragment());
        fragmentTransaction.addToBackStack("login");
        fragmentTransaction.commit();
    }

    public void setSwitcherFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new SwitcherFragment());
        fragmentTransaction.addToBackStack("switcher");
        fragmentTransaction.commit();
    }

    public void setStatusFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.switcher_container, new StatusFragment());
        fragmentTransaction.commit();
    }

    public void setActionGraphicFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.switcher_container, new ActionGraphicFragment());
        fragmentTransaction.commit();
    }

    public void setProfileFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.switcher_container, new ProfileFragment());
        fragmentTransaction.commit();
    }

    public void setRecomendationFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.switcher_container, new RecomendationFragment());
        fragmentTransaction.commit();
    }

    public void setActionFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.switcher_container, new ActionFragment());
        fragmentTransaction.commit();
    }



    static public MainActivity getInstance() {
        return instance;
    }


}
