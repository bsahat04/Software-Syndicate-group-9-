package com.smartappsusa.rinder;
import static com.smartappsusa.rinder.R.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SearchFilter extends AppCompatActivity implements View.OnClickListener{
    private Spinner cleanliness;
    private Spinner sleepSchedule;
    private Spinner noiseLevel;
    private Spinner social;
    private Spinner budget;
    private Spinner hobbies;
    private FirebaseAuth authentication;
    private FirebaseFirestore database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filter);

        cleanliness = findViewById(R.id.cleanliness);
        sleepSchedule = findViewById(R.id.sleep_schedule);
        noiseLevel = findViewById(R.id.noise_level);
        social = findViewById(R.id.social);
        budget = findViewById(R.id.budget);
        hobbies = findViewById(R.id.hobbies);
        findViewById(R.id.save).setOnClickListener(this);

        authentication = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        loadFilters();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.save){
            saveFilters();
        }
    }

    private void loadFilters(){
        String userId = null;
        if (authentication.getCurrentUser() != null) {
            userId = authentication.getCurrentUser().getUid();
        }
        database.collection("users").document(userId).get().addOnSuccessListener(documentSnapshot -> {
            if(documentSnapshot.exists()){
                cleanliness.setSelection(documentSnapshot.getLong("cleanliness").intValue());
                sleepSchedule.setSelection(documentSnapshot.getLong("sleepSchedule").intValue());
                noiseLevel.setSelection(documentSnapshot.getLong("noiseLevel").intValue());
                social.setSelection(documentSnapshot.getLong("social").intValue());
                budget.setSelection(documentSnapshot.getLong("budget").intValue());
                hobbies.setSelection(documentSnapshot.getLong("hobbies").intValue());
            }
        });
    }

    private void saveFilters(){
        String userId = null;
        if (authentication.getCurrentUser() != null) {
            userId = authentication.getCurrentUser().getUid();
        }
        Map<String, Object> filters = new HashMap<>();
        filters.put("cleanliness", cleanliness.getSelectedItemPosition());
        filters.put("sleepSchedule", sleepSchedule.getSelectedItemPosition());
        filters.put("noiseLevel", noiseLevel.getSelectedItemPosition());
        filters.put("social", social.getSelectedItemPosition());
        filters.put("budget", budget.getSelectedItemPosition());
        filters.put("hobbies", hobbies.getSelectedItemPosition());

        database.collection("users").document(userId).update(filters).addOnSuccessListener(aVoid -> {
            Toast.makeText(SearchFilter.this, "The Filter was saved successfully.", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(e -> {
            Toast.makeText(SearchFilter.this, "Error with saving filters, please try again.", Toast.LENGTH_SHORT).show();
        });
    }
}

