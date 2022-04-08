package com.example.myapplication;

import java.util.ArrayList;

enum TypeofRun {
    BASE,
    PROGRESSION,
    RECOVERY;
}

public class Exercise {

    //Data
    private int duration;
    private double[] minutes;
    private User user;
    TypeofRun run;
    private MasterSong songs;

    //Constructors
    public Exercise(User u, int lengthofrun)
    {
        user = u;
        this.duration = lengthofrun;
        minutes = new double[lengthofrun];
        MasterSong songs = new MasterSong();
        songs.load("app/src/main/res/raw/clean_music_data.csv");;
    }

    ///Methods
    public void setTypeofRun() {
        switch(run){
            case BASE:
                for (int i = 0; i < duration/8; i++) {
                    minutes[i] = user.getMaxHeartRate() * (0.5 + i * 0.2/(duration/8));
                }
                for (int i = duration/8; i < duration - duration/8; i++) {
                    minutes[i] = user.getMaxHeartRate() * (0.7 + (i - duration/8) * 0.15/(duration-duration/8));
                }
                for (int i = duration - duration/8; i < duration; i++) {
                     minutes[i] = user.getMaxHeartRate() * (0.7 - (i - (duration - duration/8)) * 0.2/(duration/8));
                }
                break;

            case PROGRESSION:
                for (int i = 0; i < duration; i++) {
                    if (i < duration/4) {
                        minutes[i] = user.getMaxHeartRate() * (0.5 + i * 0.2/(duration/4));
                    } else if (i > duration/4 && i < duration/2) {
                        minutes[i] = user.getMaxHeartRate() * (0.7 + (i - duration/4) * 0.08/(duration/4));
                    } else if (i > duration/2 && i < (3 * duration/4)) {
                        minutes[i] = user.getMaxHeartRate() * (0.78 + (i - duration/2) * 0.06/(duration/4));
                    } else {
                        minutes[i] = user.getMaxHeartRate() * (0.84 + (i - 3 * duration/4) * 0.12/(duration/4));
                    }
                }
                break;

            case RECOVERY:
                for (int i = 0; i < duration; i++) {
                    minutes[i] = user.getMaxHeartRate() * (0.7 - i * 0.2/(duration));
                }
                break;

        }
    }

    public void getSongs() {
        for (int i = 0; i < minutes.length;) {
            int fitIndex = 0;
            double totalBPM = 0;
            for (Song song: songs.getSongs()) { // Modify the getSongs() and MasterSong class data so that it can be used more as a Controller Class
                double length = song.getDuration();
                for (int j = i; j < i + length; j++) {
                     totalBPM = totalBPM + minutes[j];
                }
                double avgBPM = totalBPM / duration;
                double fitNum = song.getTempo() / avgBPM;
            }
        }
    }

//    public ArrayList<Song> setPlaylist(){
//
//    }
}
