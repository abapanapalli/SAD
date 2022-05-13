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
     * calls the layout and behavior of the playlist page upon opening the page
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

        Context mContext = getApplicationContext();

        Log.d("Abhinav", "Height" + u.getHeightInches());


        submitrun = (Button) findViewById(R.id.submitbutton2);
        submitrun.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v
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
                    duration = Integer.valueOf(durationInput.getText().toString());
                    Exercise exercise = new Exercise(u,duration, mContext);
                    switch(typeofrun){
                        case 0:
                            exercise.setTypeofRun(TypeofRun.RECOVERY);
                            break;
                        case 1:
                            exercise.setTypeofRun(TypeofRun.BASE);
                            break;
                        case 2:
                            exercise.setTypeofRun(TypeofRun.PROGRESSION);
                            break;
                        default:
                            exercise.setTypeofRun(TypeofRun.PROGRESSION);
                    }
                    switch(genrechoice){
                        case 0:
                            exercise.setGenreString(Genre.CLASSICAL);
                            break;
                        case 1:
                            exercise.setGenreString(Genre.JAZZ);
                            break;
                        case 2:
                            exercise.setGenreString(Genre.ELECTRONIC);
                            break;
                        case 3:
                            exercise.setGenreString(Genre.ROCK);
                            break;
                        case 4:
                            exercise.setGenreString(Genre.ALTERNATIVE);
                            break;
                        case 5:
                            exercise.setGenreString(Genre.HIPHOP);
                            break;
                        case 6:
                            exercise.setGenreString(Genre.BLUES);
                            break;
                        case 7:
                            exercise.setGenreString(Genre.ANIME);
                            break;
                        case 8:
                            exercise.setGenreString(Genre.RAP);
                            break;
                        case 9:
                            exercise.setGenreString(Genre.COUNTRY);
                            break;
                        default:
                            exercise.setGenreString(Genre.HIPHOP);
                    }
                    Log.d("Abhinav", "Height" + u.getHeightInches());
                    Log.d("Abhinav", "Song List " + exercise);
                    exercise.setSongs();
                    Intent intent = new Intent(MainActivityRunPage.this,MainActivityPlaylists.class);
                    intent.putExtra("exercise", exercise);
                    startActivity(intent);
                }
            }
        });
    }
}

