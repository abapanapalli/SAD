package com.example.myapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MasterSong {

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
     * @param source the name of the file as an absolute path
     */

    public void load(String source)
    {
        // Construct the Scanner and File objects for reading
        try  {
            File inputFile = new File(source);
            Scanner in = new Scanner(inputFile);

            // Read the input file
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String[] fields = line.split(",");
                Song song = new Song(fields[1], fields[2], Double.parseDouble(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]));
                songs.add(song);
            }

            in.close();
        }
        catch (FileNotFoundException fileEx)  {
            //this.source = null;
            fileEx.printStackTrace();
        }
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
            System.out.println(song.getTitle() + ", " + song.getArtist() + ", " + song.getDuration() + ", " + song.getTempo() + ", " + song.getValence());
        }
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
