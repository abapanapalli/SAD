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
        songs.load("/Users/abhinavb/AndroidStudioProjects/MyApplication/app/src/main/res/raw/clean_music_data.csv");
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

//    public void setSongs() {
//        songList = new ArrayList<Song>();
//
////        songs.printSongs();
////        for (double d: seconds) {
////        	System.out.println(d);
////        }
//
//        for (int i = 0; i < seconds.length;) {
//            double fitIndex = 0.8;
//            double totalBPM = 0;
//            double fitNum = 0;
//            ArrayList<Song> songDatabase = songs.getSongs();
//            for (Song song: songDatabase) { // Modify the getSongs() and MasterSong class data so that it can be used more as a Controller Class
//                double length = song.getDuration();
//                for (int j = i; j < i + (int) length && j < seconds.length; j++) {
//                     totalBPM = totalBPM + seconds[j];
//                }
//                System.out.println(totalBPM);
//                double avgBPM = totalBPM / (int) length;
//                fitNum = avgBPM / song.getTempo();
//                System.out.println(fitNum);
//                if (Math.abs(1 - fitNum) < fitIndex) {
//                	System.out.println("the criteria has been met.");
//                    fitIndex = fitNum;
//                    songList.add(song);
//                    i = i + duration;
////                    System.out.println(length);
////                    System.out.println(totalBPM);
////                    System.out.println(avgBPM);
////                    System.out.println(fitIndex);
//                }
//            }
//        }
//    }

    public void setSongs() {
        songList = new ArrayList<Song>();
        // ArrayList<Integer> songIDs = new ArrayList<Integer>();
        double[] fitNum = new double[songs.getSongs().size()];
        int[] songIDs = new int[songs.getSongs().size()];
        for (int i = 0; i < songs.getSongs().size(); i++) {
            for (Song s: songs.getSongs()) {
                songIDs[i] = s.getID();
            }
        }
        ArrayList<Integer> finalIDs = new ArrayList<Integer>();
        double fitIndex = 1;
        for (int i = 0; i < seconds.length; i++) {
            int SongCounter = 0;
            for (Song s: songs.getSongs()) {
                double totalBPM = 0;
                int length = 0;
                for (int j = i; j < i + (int) s.getDuration() && j < seconds.length; j++) {
                    totalBPM = totalBPM + seconds[j];
                    length++;
                }
                double avgBPM = totalBPM / length;
                fitNum[SongCounter] = avgBPM/s.getTempo();
                // System.out.println(avgBPM/s.getTempo());
                if (Math.abs(1-avgBPM/s.getTempo()) < fitIndex) {
                    fitIndex = avgBPM/s.getTempo();
                    finalIDs.add(s.getID());
                    System.out.println(s.getTempo());
                    i = i + length;
                }
                SongCounter++;
            }
        }
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    // From stack overflow

    public static double getMax(double[] inputArray){
        double maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = i;
            }
        }
        return maxValue;
    }

//    public ArrayList<Song> setPlaylist(){
//
//    }
}
