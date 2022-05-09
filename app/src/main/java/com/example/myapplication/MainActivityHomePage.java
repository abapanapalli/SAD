package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityHomePage extends AppCompatActivity {
Button runbutton;
Button settingsbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_page);

        settingsbutton = (Button) findViewById(R.id.SETTINGSBUTTON);
        settingsbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                      Intent intent = new Intent(MainActivityHomePage.this,MainActivitySetup.class);
                      startActivity(intent);
            }
        });




        runbutton = (Button) findViewById(R.id.StartARunButton);
        runbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHomePage.this,MainActivityRunPage.class);
                startActivity(intent);
    }

});}}