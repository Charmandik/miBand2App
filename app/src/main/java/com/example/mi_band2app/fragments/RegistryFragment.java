package com.example.mi_band2app.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mi_band2app.MainActivity;
import com.example.mi_band2app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class RegistryFragment extends Fragment {

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity.getInstance().registryFragment = this;
        return inflater.inflate(R.layout.registry_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button registryBtn = view.findViewById(R.id.registry_btn);
        final EditText registryEmail = view.findViewById(R.id.registry_email);
        final EditText registryPass = view.findViewById(R.id.registry_pass);
        EditText registryConfirmPass = view.findViewById(R.id.registry_confirm_pass);
        EditText registryUsername = view.findViewById(R.id.registry_username);
        EditText registryGender = view.findViewById(R.id.registry_gender);
        EditText registryBirthData = view.findViewById(R.id.registry_birth_data);
        EditText registryWeight = view.findViewById(R.id.registry_weight);
        EditText registryHeight = view.findViewById(R.id.registry_height);
        EditText registryGoal = view.findViewById(R.id.registry_goal);

        registryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(registryEmail.getText().toString(),registryPass.getText().toString());
            }
        });
    }

    public void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity.getInstance(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            MainActivity.getInstance().setLoginFragment();
                        }
                        else;
                        //todo: message if catched error

                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity.getInstance().registryFragment = null;
    }
}
