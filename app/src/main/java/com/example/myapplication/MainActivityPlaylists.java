package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_playlists);

        Exercise exercise = (Exercise) getIntent().getSerializableExtra("exercise");

        Log.d("Abhinav", "Exercise Object " + exercise);

//        backtohome = (Button) findViewById(R.id.backtohomebutton);
//        backtohome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivityPlaylists.this,MainActivityHomePage.class);
//                startActivity(intent);
//            }
//        });

        exercise.setSongs();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        playlistArrayList = new ArrayList<Playlist>();

        myAdapter = new Adapter(this, playlistArrayList);
        recyclerView.setAdapter(myAdapter);

        songName = new String[exercise.getSongList().size()];
        for (int i = 0; i < songName.length; i++) {
            for (Song song: exercise.getSongList()) {
                songName[i] = song.getTitle();
            }
        }

        songArtist = new String[exercise.getSongList().size()];
        for (int i = 0; i < songArtist.length; i++) {
            for (Song song: exercise.getSongList()) {
                songArtist[i] = song.getArtist();
            }
        }

        imageResourceId = new int[exercise.getSongList().size()];
        for (int i = 0; i < songName.length; i++) {
            imageResourceId[i] = R.drawable.personalrecordlogo3;
        }

        getData();
    }

    private void getData() {
        for(int i = 0; i < songName.length; i++) {
            Playlist song = new Playlist(songName[i], songArtist[i], imageResourceId[i]);
            playlistArrayList.add(song);
        }

        myAdapter.notifyDataSetChanged();
    }
}