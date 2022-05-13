package com.example.myapplication;

import java.io.Serializable;

public class Song implements Serializable {

    // Data

    final private int ID; // Keeps track of what song is being manipulated
    private String title; // The title of the song
    private String artist; // The artist which produced the song
    private double duration; // How long the song runs for, measured in seconds
    private double tempo; // The number of beats per minute (bpm)
    private double valence; // Describes the musical positiveness conveyed by a track
    private String genre; // The genre of the music

    // Constructor

    // Constructs a Song object which contains five parameters (title, artist, duration, tempo, and valence)

    public Song(int id, String t, String a, double d, double bpm, double v, String g) {
        ID = id;
        title = t;
        artist = a;
        duration = d;
        tempo = bpm;
        valence = v;
        genre = g;
    }

    // Methods

    /**
     * Method which gets the ID of a song
     * @return ID The ID of the song
     */

    public int getID() {
        return ID;
    }

    /**
     * Method which gets the title of a song
     * @return title The title of the song
     */

    public String getTitle() {
        return title;
    }

    /**
     * Method which sets the title of a song
     * @param title The new title of the song
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method which gets the artist of a song
     * @return artist The artist of the song
     */

    public String getArtist() {
        return artist;
    }

    /**
     * Method which sets the artist of a song
     * @param artist The new artist of the song
     */

    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Method which gets the duration of a song (measured in seconds)
     * @return duration The duration of the song
     */

    public double getDuration() {
        return duration;
    }

    /**
     * Method which sets the duration of a song
     * @param duration The new duration of the song
     */

    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Method which gets the tempo of a song (measured in beats per minute - bpm)
     * @return tempo The tempo of the song
     */

    public double getTempo() {
        return tempo;
    }

    /**
     * Method which sets the tempo of a song
     * @param tempo The new tempo of the song
     */

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    /**
     * Method which gets the valence of a song, measured on a scale from 0 to 1
     * @return valence The valence of the song
     */

    public double getValence() {
        return valence;
    }

    /**
     * Method which sets the valence of a song
     * @param valence The new valence of the song
     */

    public void setValence(double valence) {
        this.valence = valence;
    }

    /**
     * Method which gets the genre of a song
     * @return genre The genre of the song
     */

    public String getGenre() {
        return genre;
    }

    /**
     * Method which sets the genre of a song
     * @param genre The new genre of the song
     */

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return this.getID() + ", " + this.getTitle() +  ", " + this.getArtist() +  ", " + this.getDuration() +  ", " + this.getTempo() +  ", " + this.getValence() +  ", " + this.getGenre();
    }


}
