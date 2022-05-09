package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

public class MainActivitySetup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
  private int age, weight, heightft, heightin, activityLevel;
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
        activityLevel = spinner.getSelectedItemPosition();




        button = (Button) findViewById(R.id.savebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = Integer.valueOf(ageInput.getText().toString());
                weight = Integer.valueOf(weightInput.getText().toString());
                heightft = Integer.valueOf(heightftInput.getText().toString());
                heightin = Integer.valueOf(heightinInput.getText().toString());


                saveData();


                Intent intent = new Intent(MainActivitySetup.this,MainActivityHomePage.class);
                startActivity(intent);




            }
        });

        loadData();
        updateViews();
    }

    public void saveData(){
        SharedPreferences runningData = getSharedPreferences("runningData", MODE_PRIVATE);
        SharedPreferences.Editor edits = runningData.edit();

        edits.putInt("age", Integer.parseInt(ageInput.getText().toString()));
        edits.putInt("weight", Integer.parseInt(weightInput.getText().toString()));
        edits.putInt("height in feet", Integer.parseInt(heightftInput.getText().toString()));
        edits.putInt("height in inches", Integer.parseInt(heightinInput.getText().toString()));

        edits.putInt("activity level", spinner.getSelectedItemPosition());
        Log.d("diksha","activityLevel:"+ activityLevel);

        edits.apply();
        edits.commit();

        Toast.makeText(this, "Your information has been saved!",Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences runningData = getSharedPreferences("runningData", MODE_PRIVATE);
        age = runningData.getInt("age",0);
        weight = runningData.getInt("weight",0);
        heightft = runningData.getInt("height in feet", 0);
        heightin = runningData.getInt("height in inches",0);
       activityLevel = runningData.getInt("activity level",0);
    }
    public void updateViews(){
        ageInput.setText(String.valueOf(age));
        weightInput.setText(String.valueOf(weight));
        heightftInput.setText(String.valueOf(heightft));
        heightinInput.setText(String.valueOf(heightin));
        spinner.setSelection(activityLevel);
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
    }}

