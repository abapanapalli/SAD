package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityHomePage extends AppCompatActivity {
Button runbutton;
Button settingsbutton;

    /**
     * calls the layout and behavior of the home page upon opening the page
     * @param savedInstanceState Bundle object expected by the onCreate method
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_page);

        User u = (User) getIntent().getSerializableExtra("user");

        settingsbutton = (Button) findViewById(R.id.SETTINGSBUTTON);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            /**
             * Opens the setup page when the button is clicked
             * @param view the button view being clicked
             */

            @Override
            public void onClick(View view) {
                      Intent intent = new Intent(MainActivityHomePage.this,MainActivitySetup.class);
                      startActivity(intent);

            }
        });




        runbutton = (Button) findViewById(R.id.StartARunButton);
        runbutton.setOnClickListener(new View.OnClickListener() {
            /**
             * Opens the run page and passes the user object to run home page when the button is clicked
             * @param v the button view being clicked
             */

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHomePage.this,MainActivityRunPage.class);
                intent.putExtra("user", u);
                startActivity(intent);
    }

});}}