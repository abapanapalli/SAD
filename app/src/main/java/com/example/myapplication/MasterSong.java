package com.example.myapplication;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MasterSong implements Serializable {

    // Data

    private ArrayList<Song> songs;

    // Constructor

    /**
     * Constructs a MasterSong object with an empty list of words
     */

    public MasterSong()
    {
        songs = new ArrayList<Song>();
    }

    // Methods

    /**
     * Loads a list of songs from a given text file
     * @param inputStream the name of the file as an absolute path
     */

    public void load(InputStream inputStream) {
        // Construct the Scanner and File objects for reading
        Scanner in = new Scanner(inputStream);
        // Read the input file
        while(in.hasNextLine()) {
            String line = in.nextLine();
            String[] fields = line.split(",");
            Song song = new Song(Integer.parseInt(fields[0]), fields[1], fields[2], Double.parseDouble(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]), fields[6]);
            songs.add(song);
        }
        in.close();
    }

    /**
     * Prints the songs in the list
     */

    public void printSongs() {
        for (Song song: songs) {
            System.out.println(song.getID() + ", " + song.getTitle() + ", " + song.getArtist() + ", " + song.getDuration() + ", " + song.getTempo() + ", " + song.getValence() + song.getGenre());
        }
    }

    public int findID(int inputID) {
        int i = 0;
        int finalVal = 0;
        for (Song song: songs) {
            if (song.getID() == inputID) {
                finalVal = i;
            }
            i++;
        }
        return finalVal;
    }

    public ArrayList<Song> getSongs(){
        return songs;
    }

}
