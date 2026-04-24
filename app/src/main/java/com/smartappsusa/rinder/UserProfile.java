package com.smartappsusa.rinder;


import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
public class UserProfile {
    private String userId;
    private String username;
    private String email;
    private int cleanliness;
    private int budget;
    private int sleepSchedule;
    private int social;
    private int noise;
    private List<String> hobbies;


    public UserProfile(String userId, String username, String email, int cleanliness, int budget,
                       int sleepSchedule, int social, int noise, List<String> hobbies){
        this.userId = userId;
        setUsername(username);
        setEmail(email);
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

    public String getUserId() {
        return this.userId;
    }
    public String getUsername(){


        return this.username;
    }

    public String getEmail(){
        return this.email;
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


    public List<String> getHobbies(){


        return this.hobbies;
    }


    public void setCleanliness(int cleanliness){
        this.cleanliness = cleanliness;
    }


    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
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


    public void setHobbies(List<String> hobbies){
        this.hobbies = hobbies;
    }

    public void addHobbies(String hobby){
        if (hobby != null && !hobby.trim().isEmpty()){
            this.hobbies.add(hobby.trim());
        }
    }

    public void removeHobby(String hobby){
        this.hobbies.remove(hobby);
    }


    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("username", username);
        map.put("email", email);
        map.put("cleanliness", cleanliness);
        map.put("budget", budget);
        map.put("sleepSchedule", sleepSchedule);
        map.put("social", social);
        map.put("noise", noise);
        map.put("hobbies", hobbies);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static UserProfile fromMap(Map<String, Object> map) {
        return new UserProfile(
                (String) map.get("userId"),
                (String) map.get("username"),
                (String) map.get("email"),
                ((Long) map.get("cleanliness")).intValue(),
                ((Long) map.get("budget")).intValue(),
                ((Long) map.get("sleepSchedule")).intValue(),
                ((Long) map.get("social")).intValue(),
                ((Long) map.get("noise")).intValue(),
                (List<String>) map.get("hobbies")
        );
    }







}

