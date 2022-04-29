package com.example.myapplication;

import java.util.ArrayList;

public class ExerciseTester {

    public static void main(String args[]) {
        ArrayList<Song> localSongList = new ArrayList<Song>();

        User diksha = new User(5, 8, 100, 17);
        Exercise workout = new Exercise(diksha, 23);
        workout.setTypeofRun(TypeofRun.BASE);
        workout.setGenreString(Genre.ROCK);
        workout.setSongs();
        localSongList = workout.getSongList();
        double totalLength = 0;
        for (Song song: localSongList) {
            totalLength = totalLength + song.getDuration();
            System.out.println(song.getTitle() + ", " + song.getDuration() + ", " + song.getTempo() + ", " + song.getGenre());
        }
        System.out.println("The total length of the songs played is " + totalLength + " seconds, " +
                "which corresponds to " + totalLength / 60 + " minutes.");
    }
}

