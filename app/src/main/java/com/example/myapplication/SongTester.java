package com.example.myapplication;

public class SongTester {

    public static void main(String[] args) {
        MasterSong songs = new MasterSong();
        songs.load("app/src/main/res/raw/clean_music_data.csv");
        songs.printSongs();
    }
}

