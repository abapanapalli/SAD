package com.example.myapplication;

enum ActivityLevel {
    LIGHT,
    MODERATE,
    FREQUENT;
}

public class User {

    //Data
    private int heightft;
    private int heightin;
    private double weightlbs;
    private int age;
    private int maxheartrate;
    int height;
    private int level;
    ActivityLevel stitch;

    //Constructors
    public User(int feet, int inches, double lbs, int age) {
        this.heightft = feet;
        this.heightin = inches;
        this.weightlbs= lbs;
        this.age = age;
        this.maxheartrate = 220 - age;
        this.height = (12 * heightft) + heightin;
    }

    //Methods
    public int getHeightFeet() {
        return heightft;
    }
    public int getHeightInches() {
        return heightin;
    }
    public double getWeight() {
        return weightlbs;
    }
    public int getAge() {
        return age;
    }
    public int getMaxHeartRate() {
        return maxheartrate;
    }
    public void setActivityLevel() {
        switch(stitch) {
            case LIGHT:
                level = 1;
                break;

            case MODERATE:
                level = 2;
                break;

            case FREQUENT:
                level = 3;
                break;

        }

    }

    public int getLevel() {
        return level;
    }
}

