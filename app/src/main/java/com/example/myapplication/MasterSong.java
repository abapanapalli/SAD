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

    public void load(InputStream inputStream)
    {
        // Construct the Scanner and File objects for reading
//        try  {
            Scanner in = new Scanner(inputStream);

//            InputStream is = getResources().openRawResource(resourceId);

            // Read the input file
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String[] fields = line.split(",");
                Song song = new Song(Integer.parseInt(fields[0]), fields[1], fields[2], Double.parseDouble(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]), fields[6]);
                songs.add(song);
                // System.out.println(line);
            }

            in.close();
//        }
//        catch (FileNotFoundException fileEx)  {
//            //this.source = null;
//            fileEx.printStackTrace();
//        }
    }
//
//	/**
//	 * Loads a list of songs from a given file that is selected from a pop-up dialog window
//	 */
//
//	public void pick()
//	{
//		JFileChooser chooser = new JFileChooser(".");
//		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
//		{
//			load(chooser.getSelectedFile().getAbsolutePath());
//		}
//	}


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

//    public void sortBPM() {
//        int min = songs.getTempo(0);
//        for (int i = 1; i < songs.size(); i++) {
//            if(songs.get(i) < min) {
//                min = songs.get(i);
//            }
//        }
//        songs.remove((Integer) min);
//        songs.add(0, min);
//    }
}
