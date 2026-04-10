package com.smartappsusa.rinder;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener{
    private EditText email, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        findViewById(R.id.submit_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.submit_button){
            if(email.getText().toString().isBlank()){
                Toast.makeText(this, "Email cannot be empty!", Toast.LENGTH_SHORT).show();
            }
            else if(password.getText().toString().isBlank()){
                Toast.makeText(this, "Password cannot be empty!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Account Created Successfully!", Toast.LENGTH_SHORT).show();
                // Username and password are good, and account can be created.
            }
        }
    }
}
