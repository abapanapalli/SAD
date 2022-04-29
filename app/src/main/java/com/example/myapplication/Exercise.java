package com.example.myapplication;

import java.util.ArrayList;

enum TypeofRun {
    BASE,
    PROGRESSION,
    RECOVERY;
}

enum Genre {
    CLASSICAL,
    JAZZ,
    ELECTRONIC,
    ROCK,
    ALTERNATIVE,
    HIPHOP,
    BLUES,
    ANIME,
    RAP,
    COUNTRY;
}


public class Exercise {

    //Data
    private int duration;
    private double[] seconds;
    private User user;
    TypeofRun run;
    private MasterSong songs;
    ArrayList<Song> songList;
    Genre runGenre;
    String genre;

    //Constructors
    public Exercise(User u, int lengthofrun)
    {
        user = u;
        duration = lengthofrun * 60;
        seconds = new double[lengthofrun * 60];
        songs = new MasterSong();
        songs.load("app/src/main/res/raw/clean_music_genre_data.csv");
    }

    ///Methods
    public void setTypeofRun(TypeofRun userRun) {
        run = userRun;
        switch(run){
            case BASE:
                for (int i = 0; i < duration/8.0; i++) {
                    seconds[i] = user.getMaxHeartRate() * (0.5 + i * 0.2/(duration/8.0));
                }
                for (int i = (int) (duration/8.0); i < duration - duration/8.0; i++) {
                    seconds[i] = user.getMaxHeartRate() * (0.7 + (i - duration/8.0) * 0.15/(duration-duration/8.0));
                }
                for (int i = (int) (duration - duration/8.0); i < duration; i++) {
                    seconds[i] = user.getMaxHeartRate() * (0.7 - (i - (duration - duration/8.0)) * 0.2/(duration/8.0));
                }
                break;

            case PROGRESSION:
                for (int i = 0; i < duration; i++) {
                    if (i < duration/4.0) {
                        seconds[i] = user.getMaxHeartRate() * (0.5 + i * 0.2/(duration/4.0));
                    } else if (i > duration/4.0 && i < duration/2.0) {
                        seconds[i] = user.getMaxHeartRate() * (0.7 + (i - duration/4.0) * 0.08/(duration/4.0));
                    } else if (i > duration/2.0 && i < (3 * duration/4.0)) {
                        seconds[i] = user.getMaxHeartRate() * (0.78 + (i - duration/2.0) * 0.06/(duration/4.0));
                    } else {
                        seconds[i] = user.getMaxHeartRate() * (0.84 + (i - 3 * duration/4.0) * 0.12/(duration/4.0));
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

    public void setGenreString(Genre userGenre) {
        runGenre = userGenre;
        switch(runGenre){
            case CLASSICAL:
                genre = "Classical";
                break;

            case JAZZ:
                genre = "Jazz";
                break;

            case ELECTRONIC:
                genre = "Electronic";
                break;

            case ROCK:
                genre = "Rock";
                break;

            case ALTERNATIVE:
                genre = "Alternative";
                break;

            case HIPHOP:
                genre = "Hip-Hop";
                break;

            case BLUES:
                genre = "Blues";
                break;

            case ANIME:
                genre = "Anime";
                break;

            case RAP:
                genre = "Rap";
                break;

            case COUNTRY:
                genre = "Country";
                break;

        }
    }

    public void setSongs() {
        songList = new ArrayList<Song>();
        ArrayList<Integer> songIDs = new ArrayList<Integer>();
        ArrayList<Double> songDurations = new ArrayList<Double>();
        for (Song s: songs.getSongs()) {
            if (s.getGenre().equals(genre)) {
                songIDs.add(s.getID());
                songDurations.add(s.getDuration());
            }
        }
        ArrayList<Integer> finalIDs = new ArrayList<Integer>();
        for (int i = 0; i < seconds.length; i++) {
            ArrayList<Double> fitNum = new ArrayList<Double>();
            double fitIndex = 1;
            int finalID = 0;
            int selectedDuration = 0;
            int length = 0;
            for (Song s: songs.getSongs()) {
                if (s.getGenre().equals(genre)) {
                    if (!finalIDs.contains(s.getID())) {
                        double totalBPM = 0;
                        length = 0;
                        for (int j = i; j < i + (int) s.getDuration() && j < seconds.length; j++) {
                            totalBPM = totalBPM + seconds[j];
                            length++;
                        }
                        double avgBPM = totalBPM / length;
                        fitNum.add(avgBPM - s.getTempo());
                    }
                }
            }
            for (int k = 0; k < fitNum.size(); k++) {
                if (Math.abs(fitNum.get(k)) < fitIndex) {
                    fitIndex = Math.abs(fitNum.get(k));
                    finalID = songIDs.get(k);
                    selectedDuration = songDurations.get(k).intValue();
                }
            }
            finalIDs.add(finalID);
            i = i + selectedDuration;
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

