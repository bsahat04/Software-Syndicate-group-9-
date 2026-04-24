package com.smartappsusa.rinder;


import java.util.HashMap;
import java.util.Map;
public class UserProfile {
    private String username;
    private int cleanliness;
    private int budget;
    private int sleepSchedule;
    private int social;
    private int noise;
    private String hobbies;


    public UserProfile(String username, int cleanliness, int budget, int sleepSchedule, int social, int noise, String hobbies){
        setUsername(username);
        setCleanliness(cleanliness);
        setBudget(budget);
        setSleepSchedule(sleepSchedule);
        setSocial(social);
        setNoise(noise);
        setHobbies(hobbies);
    }


    //empty constructor is needed for firebase
    public UserProfile(){


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


    public void setCleanliness(int cleanliness){
        this.cleanliness = cleanliness;
    }


    public void setUsername(String username){
        this.username = username;
    }


    public void setBudget(int budget){
        this.budget = budget;
    }
    public void setSleepSchedule(int sleepSchedule){
        this.sleepSchedule = sleepSchedule;
    }
    public void setSocial(int social){
        this.social = social;
    }
    public void setNoise(int noise){
        this.noise = noise;
    }


    public void setHobbies(String hobbies){
        this.hobbies = hobbies;
    }


    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("cleanliness", cleanliness);
        map.put("budget", budget);
        map.put("sleepSchedule", sleepSchedule);
        map.put("social", social);
        map.put("noise", noise);
        map.put("hobbies", hobbies);
        return map;
    }


    public static UserProfile fromMap(Map<String, Object> map){
        return new UserProfile((String) map.get("username"), ((Long) map.get("cleanliness")).intValue(),
                ((Long) map.get("budget")).intValue(), ((Long) map.get("sleepSchedule")).intValue(),
                ((Long) map.get("social")).intValue(), ((Long) map.get("noise")).intValue(),
                (String) map.get("hobbies"));
    }




}

