package com.smartappsusa.rinder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener{
    private EditText email, password;
    private FirebaseAuth authentication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        findViewById(R.id.register).setOnClickListener(this);
        findViewById(R.id.login).setOnClickListener(this);
        authentication = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        var emailText = email.getText().toString().trim();
        var passwordText = password.getText().toString().trim();

        if(!Authentication.isValidEmailPassword(emailText, passwordText)){
            Toast.makeText(this, "Enter a valid email and password!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(view.getId() == R.id.register){
            register(emailText, passwordText);
        }
        else if(view.getId() == R.id.login){
            login(emailText, passwordText);
        }
    }

    private void register(String email, String password){
        authentication.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(HomeScreen.this, "Account Created Successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomeScreen.this, SecondScreen.class));
                    finish();
                }
                else{
                    Toast.makeText(HomeScreen.this, "Account Registration Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void login(String email, String password){
        authentication.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(HomeScreen.this, "Logged In Successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomeScreen.this, SecondScreen.class));
                    finish();
                }
                else{
                    Toast.makeText(HomeScreen.this, "Email or password is incorrect!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}