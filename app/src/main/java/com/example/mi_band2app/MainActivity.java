package com.example.mi_band2app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.mi_band2app.fragments.LoginFragment;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        instance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setSwitcherFragment();
        
    }

    public void setStartFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new StartFragment());
        fragmentTransaction.commit();
    }

    public void setRegistryFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new RegistryFragment());
        fragmentTransaction.commit();
    }

    public void setLoginFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new LoginFragment());
        fragmentTransaction.commit();
    }

    public void setSwitcherFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new SwitcherFragment());
        fragmentTransaction.commit();
    }

    public void setStatusFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.switcher_container, new StartFragment());
        fragmentTransaction.commit();
    }



    static public MainActivity getInstance() {
        return instance;
    }


}
