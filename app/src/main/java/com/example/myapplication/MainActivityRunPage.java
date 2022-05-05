package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivityRunPage extends AppCompatActivity {
Button submitrun;
Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_run_page);

        spinner = findViewById(R.id.editTypeRun);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.RunOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




        submitrun = (Button) findViewById(R.id.submitbutton2);
        submitrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityRunPage.this,MainActivityPlaylists.class);
                startActivity(intent);
        }
    });}


}

