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
    private double[] seconds;
    private User user;
    TypeofRun run;
    private MasterSong songs;
    ArrayList<Song> songList;

    //Constructors
    public Exercise(User u, int lengthofrun)
    {
        user = u;
        duration = lengthofrun * 60;
        seconds = new double[lengthofrun * 60];
        songs = new MasterSong();
        songs.load("app/src/main/res/raw/clean_music_data.csv");
    }

    ///Methods
    public void setTypeofRun(TypeofRun userRun) {
        run = userRun;
        switch(run){
            case BASE:
                for (int i = 0; i < duration/8; i++) {
                    seconds[i] = user.getMaxHeartRate() * (0.5 + i * 0.2/(duration/8));
                }
                for (int i = duration/8; i < duration - duration/8; i++) {
                    seconds[i] = user.getMaxHeartRate() * (0.7 + (i - duration/8) * 0.15/(duration-duration/8));
                }
                for (int i = duration - duration/8; i < duration; i++) {
                    seconds[i] = user.getMaxHeartRate() * (0.7 - (i - (duration - duration/8)) * 0.2/(duration/8));
                }
                break;

            case PROGRESSION:
                for (int i = 0; i < duration; i++) {
                    if (i < duration/4) {
                        seconds[i] = user.getMaxHeartRate() * (0.5 + i * 0.2/(duration/4));
                    } else if (i > duration/4 && i < duration/2) {
                        seconds[i] = user.getMaxHeartRate() * (0.7 + (i - duration/4) * 0.08/(duration/4));
                    } else if (i > duration/2 && i < (3 * duration/4)) {
                        seconds[i] = user.getMaxHeartRate() * (0.78 + (i - duration/2) * 0.06/(duration/4));
                    } else {
                        seconds[i] = user.getMaxHeartRate() * (0.84 + (i - 3 * duration/4) * 0.12/(duration/4));
                    }
                }
                break;

            case RECOVERY:
                for (int i = 0; i < duration; i++) {
                    seconds[i] = user.getMaxHeartRate() * (0.7 - i * 0.2/(duration));
                }
                break;
        }
    }

    public void setSongs() {
        songList = new ArrayList<Song>();
        double[] fitNum = new double[songs.getSongs().size()];
        int[] songIDs = new int[songs.getSongs().size()];
        int a = 0;
        for (Song s: songs.getSongs()) {
            songIDs[a] = s.getID();
            a++;
        }
        ArrayList<Integer> finalIDs = new ArrayList<Integer>();
        for (int i = 0; i < seconds.length; i++) {
            double fitIndex = 1;
            int SongCounter = 0;
            int finalID = 0;
            int length = 0;
            for (Song s: songs.getSongs()) {
                if (!finalIDs.contains(s.getID())) {
                    double totalBPM = 0;
                    length = 0;
                    for (int j = i; j < i + (int) s.getDuration() && j < seconds.length; j++) {
                        totalBPM = totalBPM + seconds[j];
                        length++;
                    }
                    double avgBPM = totalBPM / length;
                    fitNum[SongCounter] = avgBPM - s.getTempo();
                    SongCounter++;
                }
            }
            for (int k = 0; k < songs.getSongs().size(); k++) {
                if (Math.abs(fitNum[k]) < fitIndex) {
                    fitIndex = Math.abs(fitNum[k]);
                    finalID = songIDs[k];
                }
            }
            finalIDs.add(finalID);
            i = i + length;
        }
        for (int k: finalIDs) {
            songList.add(songs.getSongs().get(songs.findID(k)));
        }
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

//    public ArrayList<Song> setPlaylist(){
//
//    }
}

