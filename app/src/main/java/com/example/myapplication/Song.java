package com.example.myapplication;

public class Song {

    // Data

    private String title;
    private String artist;
    private double duration;
    private double tempo;
    private double valence;

    // Constructor

    public Song(String t, String a, double d, double bpm, double v) {
        title = t;
        artist = a;
        duration = d;
        tempo = bpm;
        valence = v;
    }

    // Methods

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getValence() {
        return valence;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

}
