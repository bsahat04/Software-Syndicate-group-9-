package com.smartappusa.rinder;
public class UserProfile {
    private String username;
    private int cleanliness;
    private int budget;
    private int sleepSchedule;
    private int social;
    private int noise;
    private String hobbies;

    public UserProfile(String username, int cleanliness, int budget, int sleepSchedule, int social, int noise, String hobbies){
        this.username = username;
        this.cleanliness = cleanliness;
        this.budget = budget;
        this.sleepSchedule = sleepSchedule;
        this.social = social;
        this.noise = noise;
        this.hobbies = hobbies;
    }

    public String getUsername(){
        return this.username;
    }

    public int getCleanliness() {
        return this.cleanliness;
    }

    public int getBudget(){
        return this.budget;
    }
    
    public int getSleepSchedule(){
        return this.sleepSchedule;
    }

    public int getSocial(){
        return this.social;
    }

    public int getNoise(){
        return this.noise;
    }

    public String getHobbies(){
        return this.hobbies;
    }
}

