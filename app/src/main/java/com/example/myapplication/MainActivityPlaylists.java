package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityPlaylists extends AppCompatActivity {
Button backtohome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_playlists);

        Exercise exercise = (Exercise) getIntent().getSerializableExtra("exercise");

        backtohome = (Button) findViewById(R.id.backtohomebutton);
        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityPlaylists.this,MainActivityHomePage.class);
                startActivity(intent);
            }

    });
}}