package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivitySetup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText ageInput, weightInput, heightftInput, heightinInput;
    Button button;
    SharedPreferences sp;

    Integer ageInputInt, weightInputInt, heightftInputInt, heightinInputInt;


    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_setup);

        ageInput = (EditText) findViewById(R.id.editAge);
        weightInput = (EditText) findViewById(R.id.editTextWeight);
        heightftInput = (EditText) findViewById(R.id.editTextFeet);
        heightinInput = (EditText) findViewById(R.id.editTextInches);
        button = (Button) findViewById(R.id.submitbutton);

        spinner = findViewById(R.id.editLevel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ActivityLevel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        sp = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ageInputInt = Integer.valueOf(ageInput.getText().toString());
                weightInputInt = Integer.valueOf(weightInput.getText().toString());
                heightftInputInt = Integer.valueOf(heightftInput.getText().toString());
                heightinInputInt = Integer.valueOf(heightinInput.getText().toString());

                SharedPreferences.Editor editor = sp.edit();

                editor.putInt("age", ageInputInt);
                editor.putInt("weight", weightInputInt);
                editor.putInt("heightft", heightftInputInt);
                editor.putInt("heightin", heightinInputInt);
                editor.commit();
                Toast.makeText(MainActivitySetup.this, "Data Saved", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void saveData() {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void showToast(String text) {
        Toast.makeText(MainActivitySetup.this, text, Toast.LENGTH_SHORT).show();
    }
}