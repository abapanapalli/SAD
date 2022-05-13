package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivityPlaylists extends AppCompatActivity {

    Button backtohome;

    RecyclerView recyclerView;
    ArrayList<Playlist> playlistArrayList;
    Adapter myAdapter;
    String[] songName;
    String[] songArtist;
    int[] imageResourceId;
    int duration, typeofrun, genrechoice;

    /**
     * calls the layout and behavior of the playlist page upon opening the page
     * @param savedInstanceState Bundle object expected by the onCreate method
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_playlists);

        Context mContext = getApplicationContext();

        String durationInput = (String) getIntent().getSerializableExtra("duration");
        duration = Integer.valueOf(durationInput);
        typeofrun = (int) getIntent().getSerializableExtra("type of run");
        genrechoice = (int) getIntent().getSerializableExtra("genre");
        User u = (User) getIntent().getSerializableExtra("user");

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

        exercise.setSongs();

        backtohome = (Button) findViewById(R.id.backtohomebutton);
        backtohome.setOnClickListener(new View.OnClickListener() {
            /**
             * Opens the home page and passes the user object back to the home page when the button is clicked
             * @param v the button view being clicked
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityPlaylists.this,MainActivityHomePage.class);
                intent.putExtra("user", u);
                startActivity(intent);
            }
        });

        exercise.setSongs();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        playlistArrayList = new ArrayList<Playlist>();

        myAdapter = new Adapter(this, playlistArrayList);
        recyclerView.setAdapter(myAdapter);

        songName = new String[exercise.getSongList().size()];
        songArtist = new String[exercise.getSongList().size()];
        imageResourceId = new int[exercise.getSongList().size()];

        int i = 0;
        for (Song song: exercise.getSongList()) {
            songName[i] = song.getTitle();
            songArtist[i] = song.getArtist();
            imageResourceId[i] = R.drawable.personalrecordlogo3;
            i++;
        }

        getData();
    }

    /**
     * Adds songs in created in playlist to recycler view ArrayList to display on screen
     */
    private void getData() {
        for(int i = 0; i < songName.length; i++) {
            Playlist song = new Playlist(songName[i], songArtist[i], imageResourceId[i]);
            playlistArrayList.add(song);
        }

        myAdapter.notifyDataSetChanged();
    }
}