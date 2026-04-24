package com.smartappsusa.rinder;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondScreen extends AppCompatActivity {

    private EditText username, cleanliness, budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        username = findViewById(R.id.username);
        cleanliness = findViewById(R.id.cleanliness);
        budget = findViewById(R.id.budget);

        findViewById(R.id.saveProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var name = username.getText().toString();
                if (name.isBlank() || cleanliness.getText().toString().isBlank() || budget.getText().toString().isBlank()) {
                    Toast.makeText(view.getContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int clean = Integer.parseInt(cleanliness.getText().toString());
                int budg = Integer.parseInt(budget.getText().toString());
                UserProfile profile = new UserProfile(name, clean, budg, 0, 0, 0, "");

                Toast.makeText(view.getContext(), "Profile saved for " + profile.getUsername(), Toast.LENGTH_LONG).show();
            }
        });
    }
}