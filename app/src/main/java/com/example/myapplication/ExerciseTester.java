package com.example.myapplication;

import java.util.ArrayList;

public class ExerciseTester {

    public static void main(String args[]) {
        ArrayList<Song> localSongList = new ArrayList<Song>();

        User diksha = new User(5, 8, 100, 17);
        Exercise workout = new Exercise(diksha, 60);
        workout.setTypeofRun(TypeofRun.PROGRESSION);
        workout.setGenreString(Genre.RAP);
        workout.setSongs();
        localSongList = workout.getSongList();
        for (Song song: localSongList) {
            System.out.println(song.getTitle() + ", " +  song.getDuration() + ", " + song.getTempo() + ", " + song.getGenre());
        }
    }
}

