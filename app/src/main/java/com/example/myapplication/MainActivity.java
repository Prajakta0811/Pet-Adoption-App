package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editLocation;
    RadioGroup radioGender;
    Spinner spinnerSize, spinnerAge;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editLocation = findViewById(R.id.editLocation);
        radioGender = findViewById(R.id.radioGender);
        spinnerSize = findViewById(R.id.spinnerSize);
        spinnerAge = findViewById(R.id.spinnerAge);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Set dropdown values for Size
        ArrayAdapter<CharSequence> sizeAdapter = ArrayAdapter.createFromResource(
                this, R.array.pet_sizes, android.R.layout.simple_spinner_item);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSize.setAdapter(sizeAdapter);

        // Set dropdown values for Age
        ArrayAdapter<CharSequence> ageAdapter = ArrayAdapter.createFromResource(
                this, R.array.pet_ages, android.R.layout.simple_spinner_item);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(ageAdapter);

        // Handle button click
        btnSubmit.setOnClickListener(v -> {
            String location = editLocation.getText().toString().trim();
            int selectedGenderId = radioGender.getCheckedRadioButtonId();
            String gender = (selectedGenderId == R.id.radioMale) ? "Male" : "Female";
            String size = spinnerSize.getSelectedItem().toString();
            String age = spinnerAge.getSelectedItem().toString();

            // For now, just log or toast the values
            String message = "Location: " + location + "\nGender: " + gender +
                    "\nSize: " + size + "\nAge: " + age;

            android.widget.Toast.makeText(MainActivity.this, message, android.widget.Toast.LENGTH_LONG).show();
        });
    }
}
