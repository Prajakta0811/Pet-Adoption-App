package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editLocation, editSize, editAge;
    RadioGroup radioGender;
    RadioButton radioMale, radioFemale;
    Button btnSubmit;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editLocation = findViewById(R.id.editLocation);
        editSize = findViewById(R.id.editSize);
        editAge = findViewById(R.id.editAge);
        radioGender = findViewById(R.id.radioGender);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        btnSubmit = findViewById(R.id.btnSubmit);
        imgPet = findViewById(R.id.imgPet);

        // Handle button click
        btnSubmit.setOnClickListener(v -> {
            String location = editLocation.getText().toString().trim();
            String size = editSize.getText().toString().trim();
            String age = editAge.getText().toString().trim();
            String gender = "";

            int selectedId = radioGender.getCheckedRadioButtonId();
            if (selectedId == R.id.radioMale) {
                gender = "Male";
            } else if (selectedId == R.id.radioFemale) {
                gender = "Female";
            }

            // Validate fields
            if (location.isEmpty() || size.isEmpty() || age.isEmpty() || gender.isEmpty()) {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
            } else {
                String message = "Searching for a " + age + " " + gender +
                        " pet, size " + size + " in " + location;
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
