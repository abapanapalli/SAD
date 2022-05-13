package com.example.myapplication;

public class Playlist {

    // Data
    String name;
    String artist;
    int titleImage;

    // Constructor

    /**
     * Constructs a Playlist object that initializes a given song name, artist, and title image.
     * @param name name of the song
     * @param artist song artist
     * @param titleImage title image that appears in the recycler view
     */

    public Playlist(String name, String artist, int titleImage) {
        this.name = name;
        this.artist = artist;
        this.titleImage = titleImage;
    }


}
