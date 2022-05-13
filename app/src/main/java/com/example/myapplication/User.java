package com.example.myapplication;

import android.os.Parcelable;

import java.io.Serializable;

enum ActivityLevel {
    LIGHT,
    MODERATE,
    FREQUENT;
}

public class User implements Serializable {

    //Data
    private int heightft;
    private int heightin;
    private double weightlbs;
    private int age;
    private int maxheartrate;
    private int height;
    private int level;
    ActivityLevel stitch;

    //Constructors

    /**
     * Constructs a User object that initializes a given height in feet and inches, a weight in lbs, and age in years for a user
     * @param feet height of user in feet
     * @param inches height of user in inches
     * @param lbs weight of user in lbs
     * @param age age of user in years
     */

    public User(int feet, int inches, double lbs, int age) {
        this.heightft = feet;
        this.heightin = inches;
        this.weightlbs= lbs;
        this.age = age;
        this.maxheartrate = 220 - age;
        this.height = (12 * heightft) + heightin;
    }

    //Methods

    /**
     * Returns the height of the user in feet
     * @return the height of the user in feet
     */
    public int getHeightFeet() {
        return heightft;
    }

    /**
     * Returns the height of the user in inches
     * @return the height of the user in inches
     */
    public int getHeightInches() {
        return heightin;
    }

    /**
     * Returns the weight on the user in lbs
     * @return the weight of the user in lbs
     */
    public double getWeight() {
        return weightlbs;
    }

    /**
     * Return the age of the user in years
     * @return the age of the user in years
     */
    public int getAge() {
        return age;
    }

    /**
     * Calculates and returns the maximum heart rate of the user
     * @return the maximum heart rate of the user
     */
    public int getMaxHeartRate() {
        return maxheartrate;
    }

    /**
     * Sets the activity level of the user
     */
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

    /**
     * Returns the activity level of the user
     * @return the activity level of the user
     */
    public int getLevel() {
        return level;
    }
}

