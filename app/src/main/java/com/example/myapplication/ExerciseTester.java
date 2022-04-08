package com.example.myapplication;

import java.util.ArrayList;

public class ExerciseTester {

    public static void main(String args[]) {
        ArrayList<Song> localSongList = new ArrayList<Song>();

        User diksha = new User(5, 8, 100, 17);
        Exercise workout = new Exercise(diksha, 30);
        workout.setTypeofRun(TypeofRun.PROGRESSION);
        workout.setSongs();
        localSongList = workout.getSongList();
    }
}
