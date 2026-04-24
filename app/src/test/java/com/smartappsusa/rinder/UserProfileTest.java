package com.smartappsusa.rinder;


import org.junit.Test;
import static org.junit.Assert.*;


import java.util.Map;
public class UserProfileTest {


    @Test
    public void testGetUsername(){
        UserProfile user = new UserProfile("Drake", 0, 0, 0,
                0, 0, "music");
        assertEquals("Drake", user.getUsername());
    }


    @Test
    public void testGetCleanliness(){
        UserProfile user = new UserProfile("Drake", 4, 0, 0,
                0, 0, "music");
        assertEquals(4, user.getCleanliness());
    }


    @Test
    public void testGetBudget(){
        UserProfile user = new UserProfile("Drake", 4, 2, 0,
                0, 0, "music");
        assertEquals(2, user.getBudget());
    }


    @Test
    public void testGetSleepSchedule(){
        UserProfile user = new UserProfile("Drake", 4, 2, 5,
                0, 0, "music");
        assertEquals(5, user.getSleepSchedule());
    }


    @Test
    public void testGetSocial(){
        UserProfile user = new UserProfile("Drake", 4, 2, 5,
                10, 0, "music");
        assertEquals(10, user.getSocial());
    }


    @Test
    public void testGetNoise() {
        UserProfile user = new UserProfile("Drake", 4, 2, 5,
                10, 7, "music");
        assertEquals(7, user.getNoise());
    }
    @Test
    public void testGetHobbies() {
        UserProfile user = new UserProfile("Drake", 4, 2, 5,
                10, 7, "music");
        assertEquals("music", user.getHobbies());
    }


    @Test
    public void testToMap(){
        UserProfile user = new UserProfile("Drake", 4, 2, 5,
                10, 7, "music");
        Map<String, Object> map = user.toMap();
        assertEquals("Drake", map.get("username"));
        assertEquals(4, map.get("cleanliness"));
        assertEquals(2, map.get("budget"));
        assertEquals(5, map.get("sleepSchedule"));
        assertEquals(10, map.get("social"));
        assertEquals(7, map.get("noise"));
        assertEquals("music", map.get("hobbies"));
    }


    @Test
    public void testIntegration(){
        UserProfile user = new UserProfile("Drake", 4, 2, 5,
                10, 7, "music");
        Map<String, Object> map = user.toMap();
        UserProfile user2 = UserProfile.fromMap(map);


        assertEquals(user.getUsername(), user2.getUsername());
        assertEquals(user.getBudget(), user2.getBudget());
    }
}
