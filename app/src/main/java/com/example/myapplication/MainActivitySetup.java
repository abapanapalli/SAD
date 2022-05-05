package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

public class MainActivitySetup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int age, weight, heightft, heightin;
    EditText ageInput;
    EditText weightInput;
    EditText heightftInput;
    EditText heightinInput;

    Button button;


    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_setup);
        spinner = findViewById(R.id.editLevel);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ActivityLevel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        ageInput = (EditText) findViewById(R.id.editAge);
        weightInput = (EditText) findViewById(R.id.editTextWeight);
        heightftInput = (EditText) findViewById(R.id.editTextFeet);
        heightinInput = (EditText) findViewById(R.id.editTextInches);

        button = (Button) findViewById(R.id.submitbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = Integer.valueOf(ageInput.getText().toString());
                weight = Integer.valueOf(weightInput.getText().toString());
                heightft = Integer.valueOf(heightftInput.getText().toString());
                heightin = Integer.valueOf(heightinInput.getText().toString());

                showToast(String.valueOf(age));
                showToast(String.valueOf(weight));
                showToast(String.valueOf(heightft));
                showToast(String.valueOf(heightin));

                Intent intent = new Intent(MainActivitySetup.this,MainActivityHomePage.class);
                startActivity(intent);




            }
        });
    }

    public void saveData(){

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void showToast(String text){
        Toast.makeText(MainActivitySetup.this, text, Toast.LENGTH_SHORT).show();
    }
}