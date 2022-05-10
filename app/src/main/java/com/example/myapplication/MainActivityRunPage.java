package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genre.setAdapter(genreadapter);

        typeofrun = spinner.getSelectedItemPosition();
        durationInput = (EditText) findViewById(R.id.editDuration);
        genrechoice = genre.getSelectedItemPosition();


        User u = (User) getIntent().getSerializableExtra("user");


        submitrun = (Button) findViewById(R.id.submitbutton2);
        submitrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(durationInput.getText().toString().matches("")){
                    Toast.makeText(MainActivityRunPage.this,"Please fill in all the required fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    duration = Integer.valueOf(durationInput.getText().toString());
                    Exercise exercise = new Exercise(u,duration);
                    Intent intent = new Intent(MainActivityRunPage.this,MainActivityPlaylists.class);
                    intent.putExtra("exercise", exercise);
                    startActivity(intent);
                }



        }
    });}


}

