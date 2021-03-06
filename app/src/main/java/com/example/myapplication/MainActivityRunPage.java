package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivityRunPage extends AppCompatActivity {
Button submitrun;
Spinner spinner;
Spinner genre;

private int typeofrun, duration, genrechoice;
EditText durationInput;

    /**
     * calls the layout and behavior of the run page upon opening the page
     * @param savedInstanceState Bundle object expected by the onCreate method
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_run_page);

        spinner = findViewById(R.id.editTypeRun);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.RunOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        genre = findViewById(R.id.Genre);

        ArrayAdapter<CharSequence> genreadapter = ArrayAdapter.createFromResource(this, R.array.GenreOptions, android.R.layout.simple_spinner_item);
        genreadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genre.setAdapter(genreadapter);

        typeofrun = spinner.getSelectedItemPosition();
        durationInput = (EditText) findViewById(R.id.editDuration);
        genrechoice = genre.getSelectedItemPosition();


        User u = (User) getIntent().getSerializableExtra("user");

        submitrun = (Button) findViewById(R.id.submitbutton2);
        submitrun.setOnClickListener(new View.OnClickListener() {
            /**
             * Opens the playlist page and passes the user, duration, and type of run parameters to the playlist page when the button is clicked
             * @param v the button view being clicked
             */
            @Override
            public void onClick(View v) {

                typeofrun = spinner.getSelectedItemPosition();
                durationInput = (EditText) findViewById(R.id.editDuration);
                genrechoice = genre.getSelectedItemPosition();

                if(durationInput.getText().toString().matches("")) {
                    Toast.makeText(MainActivityRunPage.this,"Please fill in all the required fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivityRunPage.this,MainActivityPlaylists.class);
                    intent.putExtra("duration", durationInput.getText().toString());
                    intent.putExtra("type of run", typeofrun = spinner.getSelectedItemPosition());
                    intent.putExtra("genre", genrechoice = genre.getSelectedItemPosition());
                    intent.putExtra("user", u);
                    startActivity(intent);
                }
            }
        });
    }
}

